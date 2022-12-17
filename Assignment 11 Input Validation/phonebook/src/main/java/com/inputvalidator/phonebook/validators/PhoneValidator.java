// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class PhoneValidator {
	public static boolean isValidPhone(String phone) {
		boolean validPh = false;
		Pattern check2 = Pattern.compile("^([1-9]{1}[0-9]{2}[- .]?){2}\\d{4}$");
		Pattern check3 = Pattern.compile("^((\\([1-9]{1}[0-9]{2}\\))|[1-9]{1}[0-9]{2})[- .]?\\d{3}[- .]?\\d{4}$");
		Pattern check4 = Pattern.compile("^\\d{1}((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
		Pattern check5 = Pattern.compile("^(\\+[1-9]{1}[0-9]?[0-9]?( )?){1}((\\(\\d{2,3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
		Pattern check6 = Pattern.compile("^(\\d{5}[.]?)\\d{5}$");
		Pattern check7 = Pattern.compile("^\\d{5}$");
		Pattern check8 = Pattern.compile("^([0][1][1])[- .][1]?[- .]?(\\d{3}[- .]?){2}\\d{4}$");
		Pattern check9 = Pattern.compile("^([0][0])[- .][1]?[- .]?(\\d{3}[- .]?){2}\\d{4}$");
		Pattern check10 = Pattern.compile("^(\\d{3}[-]?)\\d{4}$");

		Matcher val1 = check2.matcher(phone);
		Matcher val2 = check3.matcher(phone);
		Matcher val3 = check4.matcher(phone);
		Matcher val4 = check5.matcher(phone);
		Matcher val5 = check6.matcher(phone);
		Matcher val6 = check7.matcher(phone);
		Matcher val7 = check8.matcher(phone);
		Matcher val8 = check9.matcher(phone);
		Matcher val9 = check10.matcher(phone);
		if (val1.matches()) {
			System.out.println("val1");
			validPh = true;
		} else if (val2.matches()) {
			System.out.println("val2");
			validPh = true;
		} else if (val3.matches()) {
			System.out.println("val3");
			validPh = true;
		} else if (val4.matches()) {
			System.out.println("val4");
			validPh = true;
		} else if (val5.matches()) {
			System.out.println("val5");
			validPh = true;
		} else if (val6.matches()) {
			System.out.println("val6");
			validPh = true;
		} else if (val7.matches()) {
			System.out.println("val7");
			validPh = true;
		} else if (val8.matches()) {
			System.out.println("val8");
			validPh = true;
		} else if (val9.matches()) {
			System.out.println("val9");
			validPh = true;
		}

		if (!validPh) {
			System.err.println("Invalid Phone number format");
		}

		return validPh;
	}
}
