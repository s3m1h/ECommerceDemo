package dataAccess;

import java.util.List;

import entities.User;

public interface UserRepository {
	public void add(User user);
	public List<User> getAll();
	public User getById(int id);
	public User getByUserName(String userName);
}
