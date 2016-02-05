package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bussiness.service_layer.ICycleService;
import bussiness.service_layer.IUser;
import bussiness.service_layer.IUserService;
import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.Echange;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
import utils.CycleManager;
import utils.NotifWebSocket;
import utils.SessionManager;


/**
 * Controleur du Spring MCV respensable de la recherche des cycles d'échange entre plusieurs utilisateur (max 10)
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Controller
public class CycleController {

	@Autowired
	private ICycleService cycleService;

	@Autowired
	private IUserService userServiceService;

	@Autowired
	private IUser userService;


	private static List<List<Echange>> echanges;

	private static List<Echange> echange;
	
	private static long idUS;
	
	@RequestMapping(value = "/searchcycle/{id}", method = RequestMethod.GET)
	public String searchCycles(@PathVariable("id") long id, HttpSession session, Model model) {
		
		SessionManager.initializeSession(session,userService);
		User user = (User) session.getAttribute("user");
		UserService userService = userServiceService.retrieveUserService(id);
		if (userService != null)
			echanges = new CycleManager().searchCycle(user, userService.getService(), userServiceService);
		model.addAttribute("cycle", echanges);
		return "cycle";
	}

	@RequestMapping(value = "/requestechange/{index}/{id}", method = RequestMethod.GET)
	public String requestEchange(@PathVariable("index") int index, @PathVariable("id") long id, HttpSession session,
			Model model) {
		SessionManager.initializeSession(session,userService);
		UserService us = userServiceService.retrieveUserService(id);
		List<Cycle> ce = cycleService.getByUserServices(us);
		boolean success = false;
		if(ce.isEmpty()){
		 Cycle c = new Cycle(us,new Date());
		echange = echanges.get(index);
		idUS = id;
		success = cycleService.addCycle(c, echange);
		}else{
			for(Echange e : ce.get(0).getEchanges())
				if(e.getOffrant().getEmail().equals(((User)session.getAttribute("user")).getEmail()) ||
						e.getDemandeur().getEmail().equals(((User)session.getAttribute("user")).getEmail())){
					e.setAccepted(true);
					success = cycleService.updateCycle(ce.get(0), e);
					break;
				}
		}
		if (success){
			return "redirect:/home";
		}else {
			model.addAttribute("error",
					"une erreur s'est produite !! La demande n'est pas transmise, essayer de nouveau SVP");
			return "cycle";
		}
	}
	
	@RequestMapping(value = "/notif", method = RequestMethod.GET)
	public @ResponseBody String notifEchange(HttpSession session,
			Model model) {
		SessionManager.initializeSession(session,userService);
		if(echange!=null){
			NotifWebSocket.sendNotif(echange,idUS,((User)session.getAttribute("user")).getEmail());
			echange = null;
		}
		return "sended";
	}
	
	@RequestMapping(value = "/collab/{id}", method = RequestMethod.GET)
	public String collab(@PathVariable("id") long id,HttpSession session,
			Model model) {
		SessionManager.initializeSession(session,userService);
		 List<Cycle> c = cycleService.getByUserServices(userServiceService.retrieveUserService(id));
		 List<List<Echange>> echan = new ArrayList<>();
		 echan.add(c.get(0).getEchanges());
		 model.addAttribute("cycle", echan);
		return "cycle";
	}
	
	@RequestMapping(value = "/collab", method = RequestMethod.GET)
	public String collabs(HttpSession session,
			Model model) {
		SessionManager.initializeSession(session,userService);
		 List<Cycle> c = cycleService.getByDemandeur((User)session.getAttribute("user"));
		 model.addAttribute("cycle", c);
		return "collaborations";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCollab(@PathVariable("id") long id,HttpSession session,
			Model model) {
		cycleService.removeCycle(id);
		return "redirect:/collab";
	}
	
	

	

}
