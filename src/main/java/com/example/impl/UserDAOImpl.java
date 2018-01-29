package com.example.impl;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component("u")//默认为userDAOImpl
public class UserDAOImpl implements UserDAO {

	private int daoId;
	private String daoStatus;
	private Set<String> sets;
	private Map<String,String>map;
	private List<String>list;


	@Override
	public void save(User user) {

	    System.out.println(user.toString());
	    //throw  new RuntimeException("exception");
	}

	public int getDaoId() {
		return daoId;
	}

	public void setDaoId(int daoId) {
		this.daoId = daoId;
	}

	public String getDaoStatus() {
		return daoStatus;
	}

	public void setDaoStatus(String daoStatus) {
		this.daoStatus = daoStatus;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserDAOImpl{" +
				"daoId=" + daoId +
				", daoStatus='" + daoStatus + '\'' +
				", sets=" + sets +
				", map=" + map +
				", list=" + list +
				'}';
	}
}
