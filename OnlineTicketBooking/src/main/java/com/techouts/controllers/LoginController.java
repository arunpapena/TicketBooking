package com.techouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.dao.impl.UserCredentialsImpl;
import com.techouts.models.UpdatePassword;
import com.techouts.models.UpdateUser;
import com.techouts.models.User;



@Controller
@RequestMapping(value = "/")
public class LoginController {

	@RequestMapping(value = "/")
	public String getLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView getProceed(@Valid User user, BindingResult bindingResult, ModelAndView model) {
		model.addObject("user", user);
		UserCredentialsImpl userCredentialsImpl = new UserCredentialsImpl();
		if (userCredentialsImpl.isUserRegistered(user.getEmail())) {
			if (userCredentialsImpl.getPassword(user.getEmail()).equals(user.getPassword())) {
				if (!userCredentialsImpl.isNewUser(user.getEmail())) {
					model.addObject("updateRecord", new UpdateUser());
					model.addObject("user", userCredentialsImpl.getUserDetails(user.getEmail()));
					model.setViewName("profile");
					return model;
				} else {
					model = new ModelAndView();
					model.addObject("updatePassword", new UpdatePassword());
					model.addObject("user", user.getEmail());
					model.setViewName("resetpassword");

					return model;
				}
			} else {
				System.out.println("User credentials are wrong");
				return model.addObject("login");
			}
		} else {
			System.out.println("user is not registerd");
			return model.addObject("login");
		}
	}


	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView updateUserPassword(@Valid UpdatePassword updatePassword, BindingResult bindingResult, ModelAndView model) {
		model.addObject("updatePassword", updatePassword);

		if (bindingResult.hasErrors()) {
			model.setViewName("resetpassword");
			return model;
		} else {
			
			UserCredentialsImpl userCredentialsImpl = new UserCredentialsImpl();
			if (updatePassword.getCurrentPassword()
					.equals(userCredentialsImpl.getPassword(updatePassword.getEmail()))) {
				if (updatePassword.getNewPassword().equals(updatePassword.getConfirmPassword())) {
					userCredentialsImpl.updateFlag(updatePassword.getNewPassword(), updatePassword.getEmail());
					model.addObject("updateRecord", new UpdateUser());
					model.addObject("email", updatePassword.getEmail());
					model.addObject("user", userCredentialsImpl.getUserDetails(updatePassword.getEmail()));
					model.setViewName("profile");
					return model;
				} else {
					System.out.println("password missmatch occured");
					model.setViewName("resetpassword");
					return model;
				}
			} else {
				System.out.println("entered current password is wrong");
				model.setViewName("resetpassword");
				return model;
			}

		}
	}

	@RequestMapping(value = "/changeRecord", method = RequestMethod.POST)
	public String getUserDetails(@Valid UpdateUser updateRecord, BindingResult bindingResult, Model model) {
		model.addAttribute("updateRecord", updateRecord);
		System.out.println("updating....");
		if (bindingResult.hasErrors()) {
			System.out.println("error occured while updating user");
			return "profile";
		} 
		
		return "profile";
		/*else {
			differentActions();
			String action = request.getParameter("action");
			if()
			System.out.println("successfully viewed and Updated record");
		}*/
		
	}
	
	@RequestMapping(value = "/changeRecord", params="save", method=RequestMethod.POST)
	public String updateDetails(@Valid UpdateUser updateRecord, BindingResult bindingResult, Model model){
		model.addAttribute("updateRecord", updateRecord);
		System.out.println(updateRecord.getEmail());
		new UserCredentialsImpl().updateUserDetails(updateRecord.getName(), updateRecord.getContact(), updateRecord.getEmail());
		new UserCredentialsImpl().getUserDetails(updateRecord.getEmail()); 
		System.out.println("updating....");
		return "profile";
	}
	
	@RequestMapping(value = "/changeRecord", params="recharge", method=RequestMethod.POST)
	public String rechargeWallet(@Valid UpdateUser updateRecord, BindingResult bindingResult, Model model){
		model.addAttribute("updateRecord", updateRecord);
		System.out.println("updating wallet....");
		return "profile";
	}
	
	@RequestMapping(value = "/changeRecord", params="logout", method=RequestMethod.POST)
	public String logout(@Valid UpdateUser updateRecord, BindingResult bindingResult, Model model){
		model.addAttribute("updateRecord", updateRecord);
		System.out.println("logging out....");
		return "profile";
	}
	
	/**/
}
