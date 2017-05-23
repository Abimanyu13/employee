package com.krypto.resource;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.krypto.entity.EmployeeEntity;
import com.krypto.service.EmployeeService;

/**
 * @author Krypto IT Solutiona
 *
 */
@RestController
@RequestMapping(value = "/employees")
class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeEntity getEmployee(@PathParam("id") final Long id) {
		return employeeService.getEmployee(id);

	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param dateOfBirth
	 * @param ssn
	 * @param salary
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeEntity createEmployee(@FormParam("firstname") final String firstName,
			@FormParam("lastname") final String lastName,
			@FormParam("dateofbirth") final String dateOfBirth,
			@FormParam("ssn") final String ssn,
			@FormParam("salary") final Long salary,
			@FormParam("email") final String email) {
		
		return employeeService.createEmployee(firstName, lastName,dateOfBirth, ssn, salary, email);
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
	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeEntity updateEmployee(@FormParam("id") final Long id,
			@FormParam("firstname") final String firstName,
			@FormParam("lastname") final String lastName,
			@FormParam("dateofbirth") final String dateOfBirth,
			@FormParam("ssn") final String ssn,
			@FormParam("salary") final Long salary,
			@FormParam("email") final String email) {
		
		return employeeService.updateEmployee(id,firstName, lastName,dateOfBirth, ssn, salary, email);
	}
	
	/**
	 * @param ssn
	 * @return
	 */
	@RequestMapping(value = "/employeebyssn", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeEntity>  getEmployeeBySSN(@PathParam("ssn") final String ssn) {
		return employeeService.getEmployeeBySSN(ssn);

	}
	
	/**
	 * @param email
	 * @return
	 */
	@RequestMapping(value = "/employeebyemail", method = RequestMethod.GET)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeEntity>  getEmployeeByEmail(@PathParam("email") final String email) {
		return employeeService.getEmployeeByEmail(email);

	}
}