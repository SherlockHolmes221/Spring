package com.example.impl;

import org.hibernate.SessionFactory;
import org.hibernate.validator.constraints.EAN;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;

public class SuperDAO extends HibernateDaoSupport {

//    @Resource(name = "hibernateTemplate")
//    public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate){
//        super.setHibernateTemplate(hibernateTemplate);
//    }

    @Resource(name = "sessionFactory")
    public void setSuperSessionFactory(SessionFactory superSessionFactory){
        super.setSessionFactory(superSessionFactory);
    }

}
