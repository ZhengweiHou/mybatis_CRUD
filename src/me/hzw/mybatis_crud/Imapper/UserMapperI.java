package me.hzw.mybatis_crud.Imapper;

import java.util.List;

import me.hzw.mybatis_crud.domain.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapperI {
	@Select("select * from users where id=#{id}")
	public User getUser(int id);

	@Insert("insert into users(name,age) value(#{name},#{age})")
	public int addUser(User user);

	@Delete("delete from users where id=#{id}")
	public int delUser(int id);

	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int updateUser(User user);

	@Select("select* from users")
	public List<User> getAll();

}
