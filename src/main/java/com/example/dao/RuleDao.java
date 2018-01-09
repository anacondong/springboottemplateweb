/**
 * 
 */
package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.entity.Rule;

/**
 * @author Ittipol
 *
 */
@Transactional
@RepositoryRestResource
public interface RuleDao extends JpaRepository<Rule,Integer>{
	
	public List<Rule> findByName(@Param("name") String name);
	
//	@Modifying
//    @Transactional
//    @Query("delete from Rule r where r.id= ?1")
//    void deleteRuleById(int id);
	
}
