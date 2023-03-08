package business.abstracts;

import java.util.List;

import entities.User;

public interface UserService {
	public void register(User user) throws Exception ;
	public void login(String userName, String password) throws Exception;
	public void googleWithRegister(User user);
}
