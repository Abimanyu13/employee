package com.krypto.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.krypto.dao.EmployeeRepository;
import com.krypto.entity.EmployeeEntity;
import com.krypto.validation.EmployeeValidator;

/**
 * @author Krypto IT Solutions
 *
 */
@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeDao;

	@Autowired
	private EmployeeValidator employeeValidator;

	/**
	 * @param id
	 * @return
	 */
	public EmployeeEntity getEmployee(Long id) {
		EmployeeEntity empEntity = employeeDao.findOne(id);
		/*
		 * EmployeeBean empBean = new EmployeeBean();
		 * empBean.setEmployeeId(empEntity.getEmployeeId());
		 * empBean.setFirstName(empEntity.getFirstName());
		 * empBean.setLastName(empEntity.getLastName());
		 * empBean.setEmail(empEntity.getEmail());
		 * empBean.setSsn(empEntity.getSsn());
		 * empBean.setSalary(empEntity.getSalary());
		 * empBean.setDateOfBirth(empEntity.getDateOfBirth());
		 */
		return empEntity;

	}

	/**
	 * @param ssn
	 * @return
	 */
	public List<EmployeeEntity> getEmployeeBySSN(String ssn) {
		List<EmployeeEntity> empEntityList = employeeDao.findBySsn(ssn);

		return empEntityList;

	}

	/**
	 * @param email
	 * @return
	 */
	public List<EmployeeEntity> getEmployeeByEmail(String email) {
		List<EmployeeEntity> empEntityList = employeeDao.findByEmail(email);

		return empEntityList;

	}

	/**
	 * @param firstName
	 * @param lastname
	 * @param dateOfBirth
	 * @param ssn
	 * @param salary
	 * @param email
	 * @return
	 */
	public EmployeeEntity createEmployee(String firstName, String lastName, String dateOfBirth, String ssn, Long salary,
			String email) {
		EmployeeEntity empEntity = null;
		String validations = employeeValidator.validateCreateRequest(firstName, lastName, dateOfBirth, ssn, salary,
				email);
		if (validations.isEmpty()) {
			empEntity = new EmployeeEntity();
			empEntity.setFirstName(firstName);
			empEntity.setLastName(lastName);
			empEntity.setEmail(email);
			empEntity.setSsn(ssn);
			empEntity.setSalary(salary);
			empEntity.setCreationDate(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date db = null;
			try {
				db = sdf.parse(dateOfBirth);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			empEntity.setDateOfBirth(db);
			empEntity = employeeDao.save(empEntity);
			empEntity.setStatus("Success");

		}else{
			empEntity = new EmployeeEntity();	
			empEntity.setStatus("failure");
			empEntity.setValidations(validations);
		}
		return empEntity;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param ssn
	 * @param salary
	 * @param email
	 * @return
	 */
	public EmployeeEntity updateEmployee(Long id, String firstName, String lastName, String dateOfBirth, String ssn,
			Long salary, String email) {
		EmployeeEntity empEntity = null;
		String validations = employeeValidator.validateUpdateRequest(id, firstName, lastName, dateOfBirth, ssn, salary,
				email);
		if (validations.isEmpty()) {

			empEntity = employeeDao.findOne(id);
			empEntity.setFirstName(firstName);
			empEntity.setLastName(lastName);
			empEntity.setEmail(email);
			empEntity.setSsn(ssn);
			empEntity.setSalary(salary);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date db = null;
			try {
				db = sdf.parse(dateOfBirth);
			} catch (ParseException e) {

				e.printStackTrace();
			}
			empEntity.setDateOfBirth(db);
			empEntity.setUpdatedDate(new Date());
			empEntity = employeeDao.save(empEntity);
			empEntity.setStatus("success");
		}else{
			empEntity = new EmployeeEntity();	
			empEntity.setStatus("failure");
			empEntity.setValidations(validations);
		}

		return empEntity;
	}

}
