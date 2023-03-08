package business.rules;

import dataAccess.UserRepository;
import entities.User;

public class UserBusinessRules {
	private UserRepository userRepository;
	
	public UserBusinessRules(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public void checkIfExistsEmail(String email) throws Exception {
		var users = userRepository.getAll();
		for (User user : users) {
			if(user.getEmail() == email) {
				throw new Exception("Bu email başka biri tarafından kullanılıyor.");
			}
		}
	}
}
