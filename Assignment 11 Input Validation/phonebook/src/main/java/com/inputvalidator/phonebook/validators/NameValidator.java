// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class NameValidator {
	public static boolean isValidName(String name) {
		Pattern namePatterm = Pattern.compile("^[A-Z]([a-zA-Z]*?\\’?[a-zA-Z]+?\\,?[ ]?\\-?\\.?){1,3}$");
		Matcher nameMatcher = namePatterm.matcher(name);
		boolean validName = false;
		if (nameMatcher.matches()) {
			System.out.println("true");
			validName = true;
		}
			

		if (!validName) {
			System.err.println("Invalid Name format");
		}

		return validName;
	}
}
