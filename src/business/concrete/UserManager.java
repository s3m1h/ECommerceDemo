package business.concrete;

import business.abstracts.GoogleService;
import business.abstracts.UserService;
import business.rules.UserBusinessRules;
import business.validationRules.LoginValidationRules;
import business.validationRules.RegisterValidationRules;
import dataAccess.UserRepository;
import entities.User;

public class UserManager implements UserService{
	private RegisterValidationRules registerValidationRules;
	private LoginValidationRules loginValidationRules;
	private UserRepository userRepository;
	private UserBusinessRules userBusinessRules;
	private GoogleService googleService;
	
	public UserManager(
			UserRepository userRepository,
			RegisterValidationRules registerValidationRules,
			LoginValidationRules loginValidationRules,
			UserBusinessRules userBusinessRules,
			GoogleService googleService
			) {
		super();
		this.registerValidationRules = registerValidationRules;
		this.userRepository = userRepository;
		this.loginValidationRules = loginValidationRules;
		this.userBusinessRules = userBusinessRules;
		this.googleService = googleService;

	}

	@Override
	public void register(User user) throws Exception {
		registerValidationRules.checkIfPassLength(user.getUserName());
		registerValidationRules.checkIfPassIsEmpty(user.getPassword());
		
		registerValidationRules.checkIfUserNameIsEmpty(user.getUserName());
		
		registerValidationRules.checkIfFirstNameIsEmpty(user.getFirstName());
		registerValidationRules.checkIfLastNameIsEmpty(user.getLastName());
		registerValidationRules.checkIfFirstnameMinLength(user.getFirstName());
		registerValidationRules.checkIfLastnameMinLength(user.getLastName());
		
		registerValidationRules.checkIfEmailIsEmpty(user.getEmail());
		registerValidationRules.checkIfEmailFormat(user.getEmail());
		
		userBusinessRules.checkIfExistsEmail(user.getEmail());
		
		userRepository.add(user);
		System.out.println(user.getUserName()+"kullanıcı ismi ile sisteme kayıt oldunuz...Eposta adresinize doğrulama linki gönderildi.");
		
	}

	@Override
	public void login(String userName, String password) throws Exception {
		loginValidationRules.checkIfPassIsEmpty(password);
		loginValidationRules.checkIfUserNameIsEmpty(userName);
		
		User user = userRepository.getByUserName(userName);
		if(user.getUserName() == userName && user.getPassword() == password) {
			System.out.println("giriş başarılı");
		}
		else {
			System.out.println("şifre veya kullanıcı adı yanlış");
		}
		
	}

	@Override
	public void googleWithRegister(User user) {
		googleService.withGoogle(user);
		
	}


}
