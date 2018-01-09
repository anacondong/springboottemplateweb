/**
 * 
 */
package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entity.Bill;

/**
 * @author Ittipol
 *
 */
@Transactional
@RepositoryRestResource
public interface BillDao extends JpaRepository<Bill,Integer>{
	
	public List<Bill> findById(@Param("id") int id);

}
