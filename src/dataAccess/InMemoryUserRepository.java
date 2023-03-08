package dataAccess;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.User;

public class InMemoryUserRepository implements UserRepository {

	List<User> users;
	
	public InMemoryUserRepository(){
		this.users = new ArrayList<>();
		users.add(new User(1,"smhacar","12345","semih","acar","semih@hotmail.com"));
		users.add(new User(2,"kurtbar","111111","barış","kurt","barışkurt@hotmail.com"));
	}
	
	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getById(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByUserName(String userName){
		for (User user : users) {
			if(user.getUserName() == userName) {
				return user;
			}
		}
		return null;
	}

}
