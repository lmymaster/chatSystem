package com.limingyi.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
//邮箱和授权码
public class Email_Authenticator extends Authenticator{
	String userName = null;
	String password = null;
	public Email_Authenticator() {}
	public Email_Authenticator(String username,String password) {
		this.userName = username;
		this.password = password;
	}
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userName,password);
	}
}
