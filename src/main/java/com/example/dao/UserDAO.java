//UserDAO�������ݿ�����Լ���User��Ĳ���
//�������ı��

package com.example.dao;


import com.example.model.User;

public interface UserDAO {
	
	public default void save(User user) {
	}
	
	

}
