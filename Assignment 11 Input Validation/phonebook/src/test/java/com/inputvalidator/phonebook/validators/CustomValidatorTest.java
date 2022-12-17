// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.validators;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CustomValidatorTest {
	@Test
	public void validatingNameTest() {
		List<String> list = Arrays.asList("Bruce Schneier", "Robert, Patricia", "1234 James", "O’’Malley, Thomas.",
				"Christopher O’Daniel-Joseph", "Paul");

		for (String s : list) {
			System.out.println(s);
			NameValidator.isValidName(s);
		}

	}

	@Test
	public void isvalidPhoneTest() {
		List<String> list = Arrays.asList("+1(703)111-2121", "+32 (21) 212-2324", "Nr 102-123-1234",
				"123 TEST", "+1234 (201) 123-1234", "(001) 123-1234", "12345.12345",
				"(703) 123-1234 ext 204");

		for (String s : list) {
			System.out.print(s);
			PhoneValidator.isValidPhone(s);
		}
	}

}
