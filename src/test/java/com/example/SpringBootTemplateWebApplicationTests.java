package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.RuleDao;
import com.example.entity.Bill;
import com.example.service.RuleService;

import junit.framework.Assert;
/**
 * @author Ittipol
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTemplateWebApplicationTests {

	
	@Autowired
	RuleDao ruleDao;
	
	@Autowired 
	RuleService ruleService;
	
	
	@Test
	public void case1() {
		int customerNumber = 1; 
		double pricePerPerson = 500; 
		String couponCode = "DIS10";
		double total = setPropertyTest(customerNumber,pricePerPerson,couponCode);
		Assert.assertEquals(450.0, total);
	}
	
	@Test
	public void case2() {
		int customerNumber = 1; 
		double pricePerPerson = 2000; 
		String couponCode = "STARCARD";
		double total = setPropertyTest(customerNumber,pricePerPerson,couponCode);
		Assert.assertEquals(1800.0, total);
		
	}
	@Test
	public void case3() {
		int customerNumber = 2; 
		double pricePerPerson = 1500; 
		String couponCode = "DIS10";
		double total = setPropertyTest(customerNumber,pricePerPerson,couponCode);
		Assert.assertEquals(2250.0, total);
	}
	
	@Test
	public void case4() {
		int customerNumber = 4; 
		double pricePerPerson = 100; 
		String couponCode = "STARCARD";
		double total = setPropertyTest(customerNumber,pricePerPerson,couponCode);
		Assert.assertEquals(300.0, total);
	}
	
	
	
	
	private double setPropertyTest( int customerNumber, double pricePerPerson,String couponCode){
		Bill bill = new Bill(customerNumber,pricePerPerson,couponCode);
		bill = ruleService.doPromo(bill);
		return bill.getTotal();
		
	}
	
	
}
