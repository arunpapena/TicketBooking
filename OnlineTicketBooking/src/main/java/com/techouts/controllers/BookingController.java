package com.techouts.ticketbooking.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.techouts.ticketbooking.models.BusInfo;
import com.techouts.ticketbooking.models.SourceDestination;
import com.techouts.ticketbooking.services.BusInfoService;
import com.techouts.ticketbooking.services.PassengersDataService;
import com.techouts.ticketbooking.services.SourceDestinationService;
import com.techouts.ticketbooking.validations.BookingValidator;

@Controller
@RequestMapping(value={"/main","/"})
public class BookingController {

	int userId=12345;
	private static final String SOURCE="source-destination";
	private static final String MODEL="model";
	@Autowired
	BookingValidator bookingValidator;
	@Autowired
	SourceDestinationService sourceDestinationService;
	@Autowired
	BusInfoService busInfoService;
	@Autowired
	PassengersDataService passengerDataService;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getCustomerForm(Model model) {
		SourceDestination sourceDestination = new SourceDestination();
		model.addAttribute(sourceDestination);
		return SOURCE;
	}
	@RequestMapping(value="/insertsourcedestination",method=RequestMethod.GET)
	public String save(@Valid SourceDestination sourceDestination , BindingResult result, Model model, HttpServletRequest request) {
		model.addAttribute("sourceDestination", sourceDestination);
		bookingValidator.validate(sourceDestination, result);
		HttpSession session=request.getSession();  
        session.setAttribute("source",sourceDestination.getFromAddress());
        session.setAttribute("destination",sourceDestination.getToAddress());
		if (result.hasErrors()) {
			return SOURCE;
		}
		else {
			 Boolean resultGot=sourceDestinationService.insertRoute(userId,sourceDestination);
			if(!resultGot)
			{
				return "redirect:viewresources";
			}
			else
			{
				return SOURCE;
			}
		}
	}
	@RequestMapping(value="viewresources",method=RequestMethod.GET)
	public ModelAndView viewResources( HttpServletRequest request)
	{
		HttpSession session=request.getSession();  
        String source = (String) session.getAttribute("source");
        String destination = (String) session.getAttribute("destination");
		List<BusInfo> list=busInfoService.getAllBusInfo(source,destination);
		 session.invalidate();
		 if(!list.isEmpty())
		 {
			 return new ModelAndView("viewresources", "list",list);
		 }
		 else
		 {
			 return new ModelAndView("noresources","response","Sorry No Resources Available for Now!!!!!!!");
		 }
	}
	@RequestMapping(value="/bookingpage",method=RequestMethod.POST)
	public ModelAndView showBookingPage(@RequestParam int busNo) { 
		List<BusInfo> list=busInfoService.getSelectedBusInfo(busNo);
			ModelMap model=new ModelMap();
			model.addAttribute("list", list);
			model.addAttribute("userId", userId);
			model.addAttribute("firstName", "Surendra");
			model.addAttribute("wallet", "8000");
			return new ModelAndView("bookingpage",MODEL,model);
	}
	@RequestMapping(value="/pricecal",method=RequestMethod.POST)
	@ResponseBody
	public String priceCaluculation(@RequestParam String noOfTickets,@RequestParam String price){

		int tickets=Integer.parseInt(noOfTickets);
		int priceForOneTicket=Integer.parseInt(price);
		return Integer.toString(tickets*priceForOneTicket);
		
	}
	@RequestMapping(value="/inserttopassenger",method=RequestMethod.POST)
	@ResponseBody
	public String insertToPassenger(@RequestParam String name,@RequestParam String age){
		
		int passengerAge=Integer.parseInt(age);
		boolean result=passengerDataService.insertPassenger(userId,name,passengerAge );
		if(!result)
			return "successfully inserted";
		return "failed";
		
	}
	@RequestMapping(value="/checkingwallet/{pricePerTicket}/{noOfTickets}/{wallet}",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView checkingWalletBalance(@PathVariable("pricePerTicket") String pricePerTicket,@PathVariable("noOfTickets") String noOfTickets,@PathVariable("wallet") String wallet){
		ModelMap model=new ModelMap();
		int oneTicket=Integer.parseInt(pricePerTicket);
		
		System.out.println("asdssdff");
		// chnages made need to be commited 
		int ticketsCount=Integer.parseInt(noOfTickets);
		int walletBalance=Integer.parseInt(wallet);
		if(walletBalance<(oneTicket*ticketsCount))
		{
			model.addAttribute("walletBalance", walletBalance);
			return new ModelAndView("ticketsbookingfailed",MODEL,model);
		}
		else
		{
			int balanceAmount=(walletBalance-(oneTicket*ticketsCount));
			model.addAttribute("balanceAmount", balanceAmount);
			return new ModelAndView("ticketsbookingsuccess",MODEL,model);
		}
	}
	
}
