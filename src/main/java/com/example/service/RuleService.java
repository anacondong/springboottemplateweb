package com.example.service;

import java.util.List;

import com.example.entity.Bill;
import com.example.entity.Rule;

/**
 * @author Ittipol
 *
 */
public interface RuleService {
	public List<Rule> findAll();
	public Bill doPromo(Bill bill);
	public void save(Rule rule);
	public void delete(int ruleId);
}
