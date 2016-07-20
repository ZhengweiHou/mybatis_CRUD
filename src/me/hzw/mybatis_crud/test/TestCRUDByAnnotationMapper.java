package me.hzw.mybatis_crud.test;

import java.util.List;

import me.hzw.mybatis_crud.Imapper.UserMapperI;
import me.hzw.mybatis_crud.domain.User;
import me.hzw.mybatis_crud.util.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCRUDByAnnotationMapper {

	@Test
	public void getUser() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		User user = mapper.getUser(2);
		System.out.println("getUser:"+user);
	}

	@Test
	public void addUser() {
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		User user = new User();
		user.setAge(120);
		user.setName("houzhengwei");
		int state = mapper.addUser(user);
		System.out.println("addUser:"+state);
	}
	
	@Test
	public void delUser(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		int state = mapper.delUser(1);
		System.out.println("delUser:"+state);
	}
	
	@Test
	public void updateUser(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		User user = mapper.getUser(2);
		StringBuilder show = new StringBuilder("oldUser:"+user);
		user.setName("newºîÕýÎ°");
		user.setAge(25);
		int state = mapper.updateUser(user);
		show.insert(0, "update:"+state+"    "); 
		show.append("    newuser:"+user);
		System.out.println(show);

	}
	
	@Test
	public void getAll(){
		SqlSession session = MybatisUtil.getSqlSession(true);
		UserMapperI mapper = session.getMapper(UserMapperI.class);
		List<User> userList = mapper.getAll();
		System.out.println("getAll:"+userList);
		
		
	}

}
