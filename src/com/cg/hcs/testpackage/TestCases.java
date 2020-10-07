package com.cg.hcs.testpackage;

import com.cg.hcs.dao.IUserDAO;
import com.cg.hcs.dao.UserDAOImpl;
import com.cg.hcs.entity.Users;

public class TestCases {
	
	public static void main(String[] args) {
		IUserDAO userDAO = new UserDAOImpl();
		/*Users user = new Users("101", "@Pankaj1234", "Pankaj", 9876543211, "pankaj@gmail.com", "user", null);
		userDAO.register(user);*/
	}

}