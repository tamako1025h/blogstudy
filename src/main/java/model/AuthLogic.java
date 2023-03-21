package model;

import dao.AuthDAO;

public class AuthLogic {
	
	public User LoginMethod(String username, String password) {
		AuthDAO dao = new AuthDAO();
		User user = dao.Login(username, password);
		
		return user;
	}
}
