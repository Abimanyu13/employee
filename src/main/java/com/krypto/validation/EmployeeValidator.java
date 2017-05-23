package com.krypto.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

	public String validateCreateRequest(String firstName, String lastName, String dateOfBirth, String ssn, Long salary,
			String email) {
		List<String> validations = new ArrayList<>();
		if (firstName == null || firstName.equals("")) {
			validations.add("firstName");
		}
		if (lastName == null || lastName.equals("")) {
			validations.add("lastName");
		}

		if (dateOfBirth == null || dateOfBirth.equals("")) {
			validations.add("dateOfBirth");
		}

		if (ssn == null || ssn.equals("")) {
			validations.add("ssn");
		}

		if (email == null || email.equals("") || !email.contains("@")) {
			validations.add("email");
		}
		String validationStr = validations.isEmpty() ? "" : validations.toString();

		return validationStr;

	}

	public String validateUpdateRequest(Long id, String firstName, String lastName, String dateOfBirth, String ssn,
			Long salary, String email) {
		List<String> validations = new ArrayList<>();

		if (id == null || id.equals("")) {
			validations.add("id");
		}

		if (firstName == null || firstName.equals("")) {
			validations.add("firstName");
		}
		if (lastName == null || lastName.equals("")) {
			validations.add("lastName");
		}

		if (dateOfBirth == null || dateOfBirth.equals("")) {
			validations.add("dateOfBirth");
		}

		if (ssn == null || ssn.equals("")) {
			validations.add("ssn");
		}

		if (email == null || email.equals("") || !email.contains("@")) {
			validations.add("email");
		}

		String validationStr = validations.isEmpty() ? "" : validations.toString();

		return validationStr;

	}

}
