package br.com.eits.meusprojetos.service;

import java.util.List;

import br.com.eits.meusprojetos.model.Authority;
import br.com.eits.meusprojetos.model.User;

public interface UserService {

	public abstract User addUser(User user);
	
	public User findByUsername(String username);
	
	public List<Authority> findRolesByUsername(String username);
	
	public abstract User addUserAndRole(User user, List<Authority> roles);

	public abstract void removeUser(String userName);

	public abstract User updateUser(User user,List<Authority> roles);

	public abstract List<User> findaAll();

}