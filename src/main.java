
import business.adapters.GoogleServiceAdapter;
import business.concrete.UserManager;
import business.rules.UserBusinessRules;
import business.validationRules.LoginValidationRules;
import business.validationRules.RegisterValidationRules;
import dataAccess.InMemoryUserRepository;
import entities.User;

public class main {

	public static void main(String[] args) throws Exception {
		UserManager userManager = new UserManager(
							new InMemoryUserRepository(),
							new RegisterValidationRules(), 
							new LoginValidationRules(),
							new UserBusinessRules(new InMemoryUserRepository()),
							new GoogleServiceAdapter()
						);
		
	userManager.login("kurtbar", "111111");
	userManager.register(new User(3,"public","123456","erkan","taş","semih@hotmail.com"));
	
	}
}
