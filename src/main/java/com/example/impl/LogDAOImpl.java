package com.example.impl;

import com.example.dao.LogDAO;
import com.example.model.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

//@Component("logDAO")//默认为logDAOImpl
public class LogDAOImpl implements LogDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Log log) {

//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(log);
//		session.getTransaction().commit();
//		System.out.println(log.toString());

        //用Annotation进行声明式事务管理
        Session session = sessionFactory.getCurrentSession();
        session.save(log);

	}


}
