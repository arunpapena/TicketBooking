package com.techouts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techouts.techoutstravel.dao.ForgotPassword;
import com.techouts.techoutstravel.dao.SetPasswordDao;
import com.techouts.techoutstravel.daoimpl.ForgotPasswordImplimentation;
import com.techouts.techoutstravel.daoimpl.RegisterDaoImpl;
import com.techouts.techoutstravel.daoimpl.SetPasswordDaoImplimentation;
import com.techouts.techoutstravel.model.ForgotPasswordDetails;
import com.techouts.techoutstravel.model.SetPassword;

@Controller
@RequestMapping("/forgot")
public class ForgotPasswordController {
	@RequestMapping("/")
	public String getRegister(Model model) {
		ForgotPasswordDetails forgotPasswordDetails = new ForgotPasswordDetails();
		model.addAttribute("forgotPasswordDetails", forgotPasswordDetails);
		return "forgotpassword";
	}

	@RequestMapping(value = { "/forgotpassword" }, method = RequestMethod.POST)
	public String getForgotpasswordDone(@Valid ForgotPasswordDetails forgotPasswordDetails, BindingResult bindingResult,
			Model model, HttpSession session) {
		if (bindingResult.hasErrors())
			return "forgotpassword";
		ForgotPassword  forgotPasswordImplimentation = new ForgotPasswordImplimentation();
		RegisterDaoImpl registerDaoImpl = new RegisterDaoImpl();
		model.addAttribute("forgotPasswordDetails", forgotPasswordDetails);
		if (!(registerDaoImpl.getAllEmails().contains(forgotPasswordDetails.getEmail().toLowerCase())
				&& registerDaoImpl.getAllContacts().contains(forgotPasswordDetails.getContact().toLowerCase()))) {
			forgotPasswordDetails.empty();
			return "invaliddata";

		}
		forgotPasswordImplimentation.insert(forgotPasswordDetails);
		SetPassword setPassword = new SetPassword();
		setPassword.setEmail(forgotPasswordDetails.getEmail());
		setPassword.setContact(forgotPasswordDetails.getContact());
		model.addAttribute("setPassword", setPassword);
		session.setAttribute("email", forgotPasswordDetails.getEmail());
		session.setAttribute("contact", forgotPasswordDetails.getContact());
		return "resetpassword";
	}

	@RequestMapping(value = { "/resetpassword" })
	public String getSetPasswordDone(@Valid SetPassword setPassword, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors())
			return "resetpassword";
		SetPasswordDao setPasswordDaoImplimentation = new SetPasswordDaoImplimentation();
		model.addAttribute("setPasswordDaoImplimentation", setPasswordDaoImplimentation);
		setPasswordDaoImplimentation.insert(setPassword);
		return "success";
	}

}
