// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.validators;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PhoneValidatorTest {

	@Test
	public void isvalidPhoneAcceptableTest() {
		List<String> list = Arrays.asList("12345", "(703)111-2121", "123-1234", "+1(703)111-2121", "+32 (21) 212-2324",
				"1(703)123-1234", "011 701 111 1234", "12345.12345", "011 1 703 111 1234");

		for (String s : list) {
			System.out.print(s);
			PhoneValidator.isValidPhone(s);
		}
	}

	@Test
	public void isvalidPhoneUnAcceptableTest() {
		List<String> list = Arrays.asList("123", "1/703/123/1234", "Nr 102-123-1234", "<script>alert(“XSS”)</script>",
				"+1234 (201) 123-1234", "(001) 123-1234", "+01 (703) 123-1234", "(703) 123-1234 ext 204");

		for (String s : list) {
			System.out.print(s);
			PhoneValidator.isValidPhone(s);
		}
	}
}
