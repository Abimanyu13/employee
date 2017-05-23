package com.krypto.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.krypto.entity.EmployeeEntity;



/**
 * @author Krypto IT Solutiona
 *
 */
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
	List<EmployeeEntity> findByEmail(String email);
	List<EmployeeEntity> findBySsn(String ssn);

}
