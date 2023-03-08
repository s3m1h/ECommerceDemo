package business.validationRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidationRules {
	public void checkIfFirstnameMinLength(String firstName) throws Exception {
		if(firstName.length() < 3) {
			throw new Exception("isim en az 2 karakter olmalı ");
		}
	}
	public void checkIfLastnameMinLength(String lastName) throws Exception {
		if(lastName.length() < 3) {
			throw new Exception("soyisim en az 2 karakter olmalı");
		}
	}
	public void checkIfEmailFormat(String email) throws Exception{
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if(!matcher.matches()) {
			throw new Exception("e-mail formatını yanlış girdiniz..");
		}
		
	}
	public void checkIfEmailIsEmpty(String email) throws Exception{
		if(email.isEmpty()) {
			throw new Exception("e-mail alanı boş geçilemez..");
		}
	}
	public void checkIfFirstNameIsEmpty(String firstName) throws Exception{
		if(firstName.isEmpty()) {
			throw new Exception("isim alanı boş geçilemez..");
		}
	}
	public void checkIfLastNameIsEmpty(String lastName) throws Exception{
		if(lastName.isEmpty()) {
			throw new Exception("soyisim alanı boş geçilemez..");
		}
	}
	public void checkIfUserNameIsEmpty(String userName) throws Exception{
		if(userName.isEmpty()) {
			throw new Exception("Kullanıcı adı boş geçilemez..");
		}
	}
	public void checkIfPassIsEmpty(String password) throws Exception{
		if(password.isEmpty()) {
			throw new Exception("Şifre alanı boş geçilemez..");
		}
	}
	public void checkIfPassLength(String password) throws Exception {
		if(password.length() < 6) {
			throw new Exception("Şifre uzunluğu en az 6 karakter olmalıdır.");
		}
	}
}
