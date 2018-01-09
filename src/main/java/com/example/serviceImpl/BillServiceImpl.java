package com.example.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BillDao;
import com.example.entity.Bill;
import com.example.service.BillService;
/**
 * @author Ittipol
 *
 */
@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDao billDao;
	
	@Override
	@Transactional
	public void save(Bill bill) {
		billDao.save(bill);
	}

	@Override
	@Transactional
	public void delete(int billId) {
		billDao.delete(billId);		
	}

	@Override
	public List<Bill> findAll() {
		return billDao.findAll();
	}
	
	
	

}
