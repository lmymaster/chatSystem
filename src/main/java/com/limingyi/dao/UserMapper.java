package com.limingyi.dao;

import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	 int deleteByPrimaryKey(Integer id);

	    //用户注册
	    int addUser(User user);

	    int insertSelective(User record);

	    User selectByPrimaryKey(Integer id);


	    User selectByUsername(String username);

	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);

	    //多参数注解
	    int addCredit(@Param("points") Integer points,@Param("id")Integer id);

	    //查询username是否存在
	    int existUsername(String username);
	    //查询用户数
	    int getUserCount();

		int countToday();

		List<User> getUsersAll();
		List<User> getAdmin();

		List<User> selectAllForAdmin(@Param("username") String username, @Param("email") String email);
	  
}