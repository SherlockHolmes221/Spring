package com.example.service;

import com.example.aop.LogInterceptor;
import com.example.dao.UserDAO;
import com.example.impl.UserDAOImpl;
import com.example.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

public class UserServiceTest {
    @Test
    public void add() throws Exception {
        //从配置文件中读取信息,applicationContext中有多个UserDAO
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        System.out.println(userDAO.toString());

        //获取指定的UserService
        UserService userservice  = (UserService) applicationContext.getBean("userService");

        //获取指定的UserDAO
        //UserDAO userdao = (UserDAO) factory.getBean("u");

        //userservice.setUserDAO(userdao);

        User user = new User();
        user.setName("me");
        user.setPassword("12245");

        userservice.add(user);

    }


    @Test
    public void testProxy(){
        //被代理的对象
       UserDAO userDAO = new UserDAOImpl();

        LogInterceptor logInterceptor = new LogInterceptor();
        logInterceptor.setTarget(userDAO);

        //产生userDAO的代理，接口有哪些方法，代理就实现了哪些方法
        UserDAO userDAOProxy = (UserDAO) Proxy.newProxyInstance(userDAO.getClass().getClassLoader(),
                new Class[]{UserDAO.class},logInterceptor);

        //通过代理实现接口的方法
        //save(User u)
        //Method m = UserDAO.class.getMethod()
        // -->InvocationHandler
        // -->invoke(this, m, u)
        //-->加要组合的业务逻辑
        // -->接口自身的业务逻辑
        userDAOProxy.save(new User());
    }

}