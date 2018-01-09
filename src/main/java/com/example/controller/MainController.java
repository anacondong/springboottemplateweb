/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Bill;
import com.example.entity.Rule;
import com.example.service.BillService;
import com.example.service.RuleService;

/**
 * @author Ittipol
 *
 */
@Controller
public class MainController {
	
	@Autowired 
	RuleService ruleService;
	
	
	@Autowired 
	BillService billService;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String homePost(Model model,@RequestParam(value = "customerNumber") int customerNumber, 
			@RequestParam(value = "pricePerPerson") double pricePerPerson, 
			@RequestParam(value = "couponCode") String couponCode){
		Bill bill = new Bill(customerNumber,pricePerPerson,couponCode);
		bill = ruleService.doPromo(bill);
		billService.save(bill); // save bill
		model.addAttribute("bill",bill);
		model.addAttribute("totals",bill.getTotal());
		
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homeGet(Model model){
		return "index";
	}
	
	
	
	@RequestMapping(value="/addRule", method=RequestMethod.POST)
	public String rulePost(Model model,@ModelAttribute("rule") Rule rule){

		ruleService.save(rule);
		model.addAttribute("rules",ruleService.findAll());
		return "rule";
	}

	
	@RequestMapping(value="/rule", method=RequestMethod.GET)
	public String ruleGet(Model model){
		model.addAttribute("rules",ruleService.findAll());
		return "rule";
	}
	
	
	@RequestMapping(value="/removeRule", method=RequestMethod.GET)
	public String rulePost(Model model,@RequestParam(value = "id") int id){
		ruleService.delete(id);
		model.addAttribute("rules",ruleService.findAll());
		return "rule";
	}
	
	
	@RequestMapping(value="/bills", method=RequestMethod.GET)
	public String billsList(Model model){
		model.addAttribute("bills",billService.findAll());
		return "bill";
	}
	
}
