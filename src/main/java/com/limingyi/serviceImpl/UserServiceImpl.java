package com.limingyi.serviceImpl;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.UserMapper;
import com.limingyi.entity.User;
import com.limingyi.service.UserService;
import com.limingyi.util.CodeUtil;
import com.limingyi.util.SendEmailUtil;


@Service("UserService")
public  class UserServiceImpl implements UserService{
	@Autowired
	public UserMapper userDao;
	  
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user)>0;
	}


	@Override
	////登录验证 0:用户名不存在 1:密码错误 2:验证成功
	public int login(String username, String password) {
		 //判断username是否存在
        boolean existUsername=existUsername(username);
        //若username存在，验证密码和邮箱验证状态
        if (existUsername){
            User resUser=userDao.selectByUsername(username);
            if (resUser.getPassword().equals(password)){
            	if(resUser.getState()==0) {
                	return 3;     //邮箱未验证
                }else if(resUser.getType()==0) {
            	return 2;
            	}
            	 return 4;       //管理员登录
            	
            }
            return 1;
        }
        return 0;
	}
	  //登陆后获取用户信息
    public User getUserByUsername(String username){
    	
        User resUser=userDao.selectByUsername(username);
        return resUser;
        
    }
    //增加积分
    public boolean addCredit(Integer points,Integer id) {
        return userDao.addCredit(points,id)>0;
    }
    //username是否存在
    public boolean existUsername(String username) {
        return userDao.existUsername(username)==1;
    }

    public int getUserCount() {
        return userDao.getUserCount();
    }

    public User getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    public boolean updateUser(User user) {
        return userDao.updateByPrimaryKeySelective(user)>0;
    }


	public void sendEmail(String toEmail) {
		SendEmailUtil sendEmailUtil = new SendEmailUtil();
		String code = null;
		System.out.println(toEmail);
		CodeUtil codeUtil = new CodeUtil();
		code = codeUtil.generateUniqueCode(6);
		System.out.println(code);
	   
		try {
			sendEmailUtil.send_email(toEmail,code);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(MessagingException e) {
			e.printStackTrace();
		}
	}


	@Override
	public int countToday() {
		
		return userDao.countToday();
	}


	@Override
	public List<User> getUsersAll() {
		// TODO Auto-generated method stub
		return userDao.getUsersAll();
	}


	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteByPrimaryKey(id)>0;
	}


	@Override
	public List<User> selectAllForAdmin(String username, String email) {
		// TODO Auto-generated method stub
		return userDao.selectAllForAdmin(username,email);
	}


	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return  userDao.selectByPrimaryKey(id);
	}


	@Override
	public List<User> getAdmin() {
		// TODO Auto-generated method stub
		return userDao.getAdmin();
	}


	@Override
	public boolean addAdmin(User user) {
		// TODO Auto-generated method stub
		return userDao.insertSelective(user)>0;
	}


}