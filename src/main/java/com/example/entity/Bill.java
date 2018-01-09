package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bill {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "RULE_ID")
	private Rule rule;
	
	private double total;
	private int customerNumber;
	private double pricePerPerson;
	private String couponCode;
	
	@Override
	public String toString() {
		return "Bill [id=" + id + ", rule=" + rule + ", total=" + total + ", customerNumber=" + customerNumber
				+ ", pricePerPerson=" + pricePerPerson + ", couponCode=" + couponCode + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public double getPricePerPerson() {
		return pricePerPerson;
	}
	public void setPricePerPerson(double pricePerPerson) {
		this.pricePerPerson = pricePerPerson;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	
	public Bill(int customerNumber, double pricePerPerson, String couponCode) {
		super();
		this.customerNumber = customerNumber;
		this.pricePerPerson = pricePerPerson;
		this.couponCode = couponCode;
	}
	public Bill() {
		super();
	}
	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
}
