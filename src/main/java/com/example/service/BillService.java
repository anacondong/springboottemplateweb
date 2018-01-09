package com.example.service;

import java.util.List;

import com.example.entity.Bill;
import com.example.entity.Rule;

/**
 * @author Ittipol
 *
 */
public interface BillService {
	public List<Bill> findAll();
	public void save(Bill bill);
	public void delete(int billId);
}
