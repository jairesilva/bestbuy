package br.com.estanislau.bestbuy.domain.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {

	public static Boolean validaEmail(Object objeto) {
		String digitado = (String) objeto;
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(digitado);
		boolean matchFound = m.matches();

		if (!matchFound) {
			return false;
		}
		return true;
	}
}