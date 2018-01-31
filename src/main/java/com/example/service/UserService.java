package com.example.service;


import com.example.dao.LogDAO;
import com.example.dao.UserDAO;
import com.example.model.Log;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.beans.Transient;

@Component("service")
public class UserService {

	private UserDAO userdao;
	private LogDAO logDAO;


//	public UserService(UserDAO userdao) {
//		super();
//		this.userdao = userdao;
//	}

	public UserDAO getUserDAO() {
		return userdao;
	}

	@Resource(name = "userDAO")
	public void setUserDAO(UserDAO userdao) {
		this.userdao = userdao;
	}

    public LogDAO getLogDAO() {
        return logDAO;
    }

    @Resource(name = "logDAO")
    public void setLogDAO(LogDAO logDAO) {
        this.logDAO = logDAO;
    }


    //	@Autowired
//	public void setUserDAO(@Qualifier("userDAO") UserDAO userdao) {
//		this.userdao = userdao;
//	}

    @Transactional
	public void add(User user) {
		this.userdao.save(user);
		Log log = new Log();
		log.setMsg("a user saved");
		logDAO.save(log);
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
