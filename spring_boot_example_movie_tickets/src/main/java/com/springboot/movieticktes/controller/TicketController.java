package com.springboot.movieticktes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.movieticktes.entities.Ticket;
import com.springboot.movieticktes.repository.TicketsRepository;

@Controller
public class TicketController {
	
	@Autowired
	TicketsRepository ticketrepo;
	
	@RequestMapping("/showCreateTicket")
	public String showCreateTicket() {
		
		return "createTicket";
	}
	
	@RequestMapping("/createTicket")
	public String createTicket(Ticket ticket, ModelMap modelMap) {
		
		ticketrepo.save(ticket);
		modelMap.addAttribute("msg","Ticket purchased successfully");
		
		return "createTicket";
	}

}
