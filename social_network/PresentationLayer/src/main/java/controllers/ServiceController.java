package controllers;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bussiness.service_layer.IService;
import bussiness.service_layer.IUser;
import bussiness.service_layer.IUserService;
import domain.service.Service;
import fr.unicaen.am.model.TypeService;
import fr.unicaen.am.model.User;
import fr.unicaen.am.model.UserService;
import model.ServiceBean;
import utils.SessionManager;
/**
 * Controleur de Spring MVC pour la gestion des services
 * @author LAHBIB Amani, KHARAIM Nikita - Université de Caen Normandie, France
 * @since January, 2016
 */
@Controller
public class ServiceController {

	@Autowired
	private IService serviceService;
	
	@Autowired
	private IUserService userServiceService;
	
	@Autowired
	private IUser userService;
	
	@RequestMapping(value="/services-list", method = RequestMethod.GET)
    public String home(HttpSession session,Model model) {
		SessionManager.initializeSession(session,userService);
        return "servicesList";
    }
	
	
	@RequestMapping(value="/ajouterAssociation/{type}/{id}/{date}", method = RequestMethod.GET)
    public String ajouterAssociation(@PathVariable("id") long id,@PathVariable("type") String type,@PathVariable("date") long date,HttpSession session,Model model) {
		SessionManager.initializeSession(session,userService);
		Service s = serviceService.getService(id);
	       
	       
	       UserService us = new UserService();
	       us.setCreationDate(new Date());
	       us.setStartDate(new Date());
	       us.setEndDate(new Date(date));
	       us.setService(s);
	       us.setPerson((User)session.getAttribute("user"));
	       if(type.equals("offre"))
	       us.setTypeService(TypeService.OFFRE);
	       else
	    	   us.setTypeService(TypeService.DEMANDE);
	       
	       //serviceService.addService(s);
	       userServiceService.addUserService(us);
        return "redirect:/services-list";
    }
	
	/*
     * Method used to populate the services list in view.
     * 
     */
    @ModelAttribute("services")
    public Collection<Service> initializeServices() {
    	
        return serviceService.getAllServices();
        
    }
    
    /*
     * Method used to populate the Comments list in view.
     * 
     */
    @ModelAttribute("userServicesDemande")
    public Collection<UserService> initializeUserServicesDemande(HttpSession session) {
    	SessionManager.initializeSession(session,userService);
    	User user = (User) session.getAttribute("user");
        return userServiceService.getUserServicesDemande(user.getEmail());
        
    }
    
    /*
     * Method used to populate the Comments list in view.
     * 
     */
    @ModelAttribute("userServicesOffert")
    public Collection<UserService> initializeUserServicesOffre(HttpSession session) {
    	SessionManager.initializeSession(session,userService);
    	User user = (User) session.getAttribute("user");
        return userServiceService.getUserServicesOffert(user.getEmail());
        
    }

	@RequestMapping(value = "/services", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String getServicesList() {
		return serviceService.getServicesLabel().toString();
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, headers = "Accept=*/*")
	public @ResponseBody String getCategoriesList() {
		return serviceService.getAllCategories().toString();
	}
	
	

	@RequestMapping(value = "/addSkill", method = RequestMethod.GET)
	public String skill(ModelMap model,HttpSession session) {
		SessionManager.initializeSession(session,userService);
		ServiceBean service = new ServiceBean();
		model.addAttribute("service", service);
		return "ajoutService";
	}
	
	@RequestMapping(value = "/addNeed", method = RequestMethod.GET)
	public String need(ModelMap model,HttpSession session) {
		SessionManager.initializeSession(session,userService);
		ServiceBean service = new ServiceBean();
		model.addAttribute("service", service);
		return "ajoutService";
	}
	
	
	
	
	@RequestMapping(value = "/addSkill", method = RequestMethod.POST)
	 public String saveSkill(@Valid ServiceBean service, BindingResult result, ModelMap model,HttpSession session){
		 
       Service s = new Service();
       s.setCategorie(service.getCategorie());
       s.setDescription(service.getDesc());
       s.setTitle(service.getTitle());
       
       UserService us = new UserService();
       us.setCreationDate(new Date());
       us.setStartDate(service.getDebut());
       us.setEndDate(service.getFin());
       us.setService(s);
       us.setPerson((User)session.getAttribute("user"));
       us.setTypeService(TypeService.OFFRE);
       
       serviceService.addService(s);
       userServiceService.addUserService(us);
       return "redirect:/home";
   }
	
	@RequestMapping(value = "/addNeed", method = RequestMethod.POST)
	 public String saveNeed(@Valid ServiceBean service, BindingResult result, ModelMap model,HttpSession session){
		 
      Service s = new Service();
      s.setCategorie(service.getCategorie());
      s.setDescription(service.getDesc());
      s.setTitle(service.getTitle());
      
      UserService us = new UserService();
      us.setCreationDate(new Date());
      us.setStartDate(service.getDebut());
      us.setEndDate(service.getFin());
      us.setService(s);
      us.setPerson((User)session.getAttribute("user"));
      us.setTypeService(TypeService.DEMANDE);
      
      serviceService.addService(s);
      userServiceService.addUserService(us);
      return "redirect:/home";
  }
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
    public String deleteService(@PathVariable("id") long id,HttpSession session, Model model) {
		SessionManager.initializeSession(session,userService);
		userServiceService.deleteUserService(id);
		User user = (User)session.getAttribute("user");
		Collection<UserService> userServicesOffert = userServiceService.getUserServicesOffert(user.getEmail());
		Collection<UserService> userServicesDemande = userServiceService.getUserServicesDemande(user.getEmail());
		model.addAttribute("userServicesDemande", userServicesDemande);
		model.addAttribute("userServicesOffert", userServicesOffert);
        return "redirect:/services-list";
    }

}
