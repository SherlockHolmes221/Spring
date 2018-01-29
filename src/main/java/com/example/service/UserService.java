package com.example.service;


import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("service")
public class UserService {

	private UserDAO userdao;


//	public UserService(UserDAO userdao) {
//		super();
//		this.userdao = userdao;
//	}

	public UserDAO getUserDAO() {
		return userdao;
	}

	@Resource(name = "userDAO1")
	public void setUserDAO(UserDAO userdao) {
		this.userdao = userdao;
	}

//	@Autowired
//	public void setUserDAO(@Qualifier("userDAO") UserDAO userdao) {
//		this.userdao = userdao;
//	}
	
	public void add(User user) {
		this.userdao.save(user);
	}

	@PostConstruct
	public void initial(){
		System.out.println("initial");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}


}
