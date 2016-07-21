package me.hzw.mybatis_crud.test;

import static org.junit.Assert.fail;

import java.util.List;

import me.hzw.mybatis_crud.domain.User;
import me.hzw.mybatis_crud.util.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUDByXMLMapper {

	@Test
	public void getUser() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.getUser";
		User user = session.selectOne(statement, 1);
		System.out.println("getUser:"+user);
	}

	@Test
	public void addUser() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.addUser";
		User user = new User();
		user.setAge(14);
		user.setName("lingling");
		int state = session.insert(statement, user);
		System.out.println("addUser:"+state);
	}
	
	@Test
	public void addUserNew(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.addUserNew";
		User user = new User();
		user.setAge(14);
		user.setName("lingling");
		int state = session.insert(statement, user);
		System.out.println("addUser:"+state);
	}
	
	@Test
	public void delUser(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.delUser";
		int state = session.delete(statement, 1);
		System.out.println("delUser:"+state);
	}
	
	@Test
	public void updateUser(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.updateUser";
		User user = session.selectOne("me.hzw.mybatis_crud.mapping.userMapper.getUser",2);
		StringBuilder show = new StringBuilder("oldUser:"+user);
		user.setName("newºîÕýÎ°");
		user.setAge(25);
		int state = session.update(statement, user);
		show.insert(0, "update:"+state+"    "); 
		show.append("    newuser:"+user);
		System.out.println(show);
	}
	
	@Test
	public void getAll(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		String statement = "me.hzw.mybatis_crud.mapping.userMapper.getAll";
		List<User> userList = session.selectList(statement);
		System.out.println("getAll:"+userList);
		
		
	}
	
}
