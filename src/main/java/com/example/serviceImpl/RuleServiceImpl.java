package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RuleDao;
import com.example.entity.Bill;
import com.example.entity.Rule;
import com.example.service.RuleService;
/**
 * @author Ittipol
 *
 */
@Service
public class RuleServiceImpl implements RuleService {
	
	@Autowired
	private RuleDao ruleDao;


	@Override
	public Bill doPromo(Bill bill){
		// Validate promotion
		double total = bill.getCustomerNumber() * bill.getPricePerPerson();
		List<Rule> rules = ruleDao.findAll();
		List<Rule> rulePromotion = new ArrayList<Rule>();
		
		// Validate and add promotion rules
		for(Rule rule : rules){
			if(isPromotion(bill,rule)){
				rulePromotion.add(rule);
			}
		}
		
		// calculate and sort rules
		rulePromotion = calculateRuleTotal(bill,rulePromotion);
		
		
		// set bill total
		if(!rulePromotion.isEmpty()){
			bill.setRule(rulePromotion.get(0));
			bill.setTotal(rulePromotion.get(0).getTotal());
		}else{
			bill.setTotal(total);
		}
		
		
		return bill;
	}
	
	
	
	private List<Rule> calculateRuleTotal(Bill bill, List<Rule> rules){
		
		double discount = 0.0;
		for(Rule rule : rules){
			if(rule.isDiscountGroupFlg()){
				//discount by count member
				rule.setTotal(bill.getPricePerPerson() * rule.getDiscountGroup());
			}else{
			// discount by Percent and total 
				if(rule.isDiscountPercentFlg())
				{
					// using percent
					discount = (int)((bill.getPricePerPerson()*bill.getCustomerNumber())*(rule.getDiscountPercent()/100.0f));
				}else{
					// using percent
					discount = rule.getDiscountTotal();
				}
				rule.setTotal((bill.getPricePerPerson()*bill.getCustomerNumber()) - discount);
			}
		}
		
		
		rules.sort(Comparator.comparing(Rule::getTotal));
		
		return rules;
	}
	
	
	
	
	private boolean isPromotion(Bill bill,Rule rule){
		
//		System.out.println(rule.toString());
//		System.out.println(bill.toString());
		boolean result = true;
		
		if(rule.getPaymentLimit() > 0 && !rule.isDiscountGroupFlg()){
			if((bill.getPricePerPerson()*bill.getCustomerNumber())	>=	rule.getPaymentLimit()){
				return true;
			}else{
				result = false;
			}
		}
		
		if(!bill.getCouponCode().equals(rule.getPromotionCode())){
			result = false;
		}else{
			result = true;
		}
		
		if((bill.getCustomerNumber() != rule.getNumberCustomer()) && rule.getNumberCustomer() != 0){
			result = false;
		}
		
		return result;
	}
	
	@Override
	@Transactional
	public void save(Rule rule) {
		ruleDao.save(rule);
	}

	@Override
	@Transactional
	public void delete(int ruleId) {
		ruleDao.delete(ruleId);		
	}

	@Override
	public List<Rule> findAll() {
		return ruleDao.findAll();
	}
}
