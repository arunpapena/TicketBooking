package com.techouts.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.payment.dto.PaymentDTO;
import com.payment.service.PaymentInsert;

@Controller
@RequestMapping(value="/")
public class PaymentController {
	PaymentDTO paymentDTO;
	@RequestMapping(value="/")
		public String showform(Model model) {
		PaymentDTO paymentDTO=new PaymentDTO();
		model.addAttribute("paymentDTO", paymentDTO);
		return "payment";
		}
		
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@Valid PaymentDTO paymentDTO, BindingResult bindingResult, Model model) {
		PaymentInsert paymentInsert=new PaymentInsert();
		/*To insert a data into table */
		paymentInsert.save(paymentDTO);
		List<PaymentDTO> list = new ArrayList<PaymentDTO>();
		list.add(paymentDTO);
		this.paymentDTO=paymentDTO;
		model.addAttribute("List", list);
		return "viewpay";
	}
	@RequestMapping(value="/success",method=RequestMethod.POST)
	public String success() {
		if(paymentDTO.getAmount()+paymentDTO.getWallet()<1250) return "error";
		return "success";
	}
	
	@RequestMapping(value="/printTicket",method=RequestMethod.GET)
	public String printTicket() {
		return "printTicket";
	}

}
