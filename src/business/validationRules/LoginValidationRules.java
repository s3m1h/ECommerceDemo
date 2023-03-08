package business.validationRules;

public class LoginValidationRules {
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
}
