package com.techouts.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techouts.dao.ForgotPassword;
import com.techouts.dao.SetPasswordDao;
import com.techouts.dao.impl.ForgotPasswordImplimentation;
import com.techouts.dao.impl.RegisterDaoImpl;
import com.techouts.dao.impl.SetPasswordDaoImplimentation;
import com.techouts.models.ForgotPasswordDetails;
import com.techouts.models.SetPassword;


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
		return "resetpasswords";
	}

	@RequestMapping(value = { "/resetpasswords" })
	public String getSetPasswordDone(@Valid SetPassword setPassword, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors())
			return "resetpasswords";
		SetPasswordDao setPasswordDaoImplimentation = new SetPasswordDaoImplimentation();
		model.addAttribute("setPasswordDaoImplimentation", setPasswordDaoImplimentation);
		setPasswordDaoImplimentation.insert(setPassword);
		return "successs";
	}

}
