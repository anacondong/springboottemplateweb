/**
 * 
 */
package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ittipol
 *
 */
@Entity
public class Rule {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private int numberCustomer;
	
	private double paymentLimit;
	
	private String promotionCode;
	
	private boolean discountPercentFlg;
	
	private double discountTotal;
	
	private int discountPercent;
	
	private boolean discountGroupFlg;
	
	private int discountGroup;
	
	private double total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberCustomer() {
		return numberCustomer;
	}
	public void setNumberCustomer(int numberCustomer) {
		this.numberCustomer = numberCustomer;
	}
	public double getPaymentLimit() {
		return paymentLimit;
	}
	public void setPaymentLimit(double paymentLimit) {
		this.paymentLimit = paymentLimit;
	}
	public String getPromotionCode() {
		return promotionCode;
	}
	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
	public boolean isDiscountPercentFlg() {
		return discountPercentFlg;
	}
	public void setDiscountPercentFlg(boolean discountPercentFlg) {
		this.discountPercentFlg = discountPercentFlg;
	}
	public double getDiscountTotal() {
		return discountTotal;
	}
	public void setDiscountTotal(double discountTotal) {
		this.discountTotal = discountTotal;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	public boolean isDiscountGroupFlg() {
		return discountGroupFlg;
	}
	public void setDiscountGroupFlg(boolean discountGroupFlg) {
		this.discountGroupFlg = discountGroupFlg;
	}
	public int getDiscountGroup() {
		return discountGroup;
	}
	public void setDiscountGroup(int discountGroup) {
		this.discountGroup = discountGroup;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Rule [id=" + id + ", name=" + name + ", numberCustomer=" + numberCustomer + ", paymentLimit="
				+ paymentLimit + ", promotionCode=" + promotionCode + ", discountPercentFlg=" + discountPercentFlg
				+ ", discountTotal=" + discountTotal + ", discountPercent=" + discountPercent + ", discountGroupFlg="
				+ discountGroupFlg + ", discountGroup=" + discountGroup + ", total=" + total + "]";
	}
	public Rule(Integer id, Bill bill, String name, int numberCustomer, double paymentLimit, String promotionCode,
			boolean discountPercentFlg, double discountTotal, int discountPercent, boolean discountGroupFlg,
			int discountGroup, double total) {
		super();
		this.id = id;
		this.name = name;
		this.numberCustomer = numberCustomer;
		this.paymentLimit = paymentLimit;
		this.promotionCode = promotionCode;
		this.discountPercentFlg = discountPercentFlg;
		this.discountTotal = discountTotal;
		this.discountPercent = discountPercent;
		this.discountGroupFlg = discountGroupFlg;
		this.discountGroup = discountGroup;
		this.total = total;
	}
	public Rule() {
		super();
	}
	
}
