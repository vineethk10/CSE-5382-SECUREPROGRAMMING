// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.validators;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NameValidatorTest {

	@Test
	public void validatingNameAcceptableTest() {
		List<String> list = Arrays.asList("Bruce Schneier", "Schneier, Bruce", "Schneier, Bruce Wayne",
				"O’Malley, John F.", "John O’Malley-Smith", "Cher");

		for (String s : list) {
			System.out.println(s);
			NameValidator.isValidName(s);
		}

	}

	@Test
	public void validatingNameUnAcceptableTest() {

		List<String> list = Arrays.asList("Ron O’’Henry", "L33t Hacker", "<Script>alert(“XSS”)</Script>",
				"Brad Everett Samuel Smith", "select * from users;", "Ron O’Henry-Smith-Barnes");

		for (String s : list) {
			System.out.println(s);
			NameValidator.isValidName(s);
		}

	}
}
