package controllers;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bussiness.service_layer.ICommentService;
import bussiness.service_layer.ICycleService;
import bussiness.service_layer.IUser;
import bussiness.service_layer.IUserService;
import domain.chat.Message;
import fr.unicaen.am.model.Comment;
import fr.unicaen.am.model.Cycle;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
import utils.SessionManager;
/**
 * Controleur de Spring MVC pour la gestion de l'accueil
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Controller
public class HomeController {
	
	@Autowired
    private IUserService userServiceService;
	
	@Autowired
    private ICommentService commentService;

	@Autowired
	private IUser userService;
	
	@Autowired
	private ICycleService cycleService;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(HttpSession session,Model model) {
		userServiceService.removeOldServices();
		SessionManager.initializeSession(session,userService);
		User user = (User)session.getAttribute("user");
		Collection<UserService> userServices = userServiceService.getUserServices(user);
		Collection<UserService> userServicesOffert = userServiceService.getUserServicesOffert(user.getEmail());
		Collection<UserService> userServicesDemande = userServiceService.getUserServicesDemande(user.getEmail());
		model.addAttribute("userServicesDemande", userServicesDemande);
		model.addAttribute("userServicesOffert", userServicesOffert);
		model.addAttribute("userServices", userServices);
		for(Cycle cycle : cycleService.getByOffrant(user))
			if(cycle.getDateCreation().equals(new Date())){
				model.addAttribute("cyclenotif",cycle.getUserService());
				break;
	}
        return "home";
    }
	
	/*
     * Method used to populate the Comments list in view.
     * 
     */
    @ModelAttribute("comments")
    public List<Message> initializeSections() {
 
        List<Message> comments = commentService.getAllMessages();
        
        return comments;
    }
    
    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
	 public String saveSkill(HttpSession session, @RequestParam( value="content", required=true ) String content
		        , @RequestParam( value="userService", required=true) long id){
    	SessionManager.initializeSession(session,userService);
    	User user = (User) session.getAttribute("user");
    	
      Comment comment = new Comment();
      comment.setContent(content);
      comment.setDatePost(new Date());
      comment.setSender(user);
      UserService us = userServiceService.retrieveUserService(id);
      comment.setUserService(us);
      comment.setReceiver(us.getPerson());
      
      commentService.addMessage(comment);
      
      return "redirect:/home";
  }
    
    @RequestMapping(value="/removecomment/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("id") long id,HttpSession session, Model model) {
    	commentService.removeMessage(id);
        return "redirect:/home";
    }
	

}
