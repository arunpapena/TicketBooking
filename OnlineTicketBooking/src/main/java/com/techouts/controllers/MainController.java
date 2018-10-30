package com.techouts.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techouts.techoutstravel.dao.RegisterDao;
import com.techouts.techoutstravel.daoimpl.RegisterDaoImpl;
import com.techouts.techoutstravel.mail.JavaSendEmail;
import com.techouts.techoutstravel.model.User;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("/")
	public String getRegister(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	
	@RequestMapping(value={"/register"}, method=RequestMethod.POST)
	public String getRegistrationDone(@Valid User user, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors())
			return "register";
		RegisterDao registerDao= new RegisterDaoImpl();
		model.addAttribute("user", user);
		if(registerDao.getAllEmails().contains(user.getEmail().toLowerCase())||registerDao.getAllContacts().contains(user.getContact().toLowerCase())){
			user.empty();
	         return "userexists";	
			
		}
		registerDao.insert(user);
		JavaSendEmail javaSendEmail=new JavaSendEmail();
		javaSendEmail.sendMail(user.getName(),user.getEmail());
		
		return "success";
	}
	
}
