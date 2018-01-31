package com.example.impl;

import com.example.dao.LogDAO;
import com.example.model.Log;
import org.springframework.stereotype.Component;

@Component("logDAO")
public class LogDAOTemplateImpl extends AbstractDAO implements LogDAO {

	@Override
	public void save(Log log){
		this.getHibernateTemplate().save(log);

	}
}
