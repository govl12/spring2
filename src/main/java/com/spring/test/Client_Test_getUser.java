package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.users.UserDTO;
import com.spring.users.UserService;

public class Client_Test_getUser {

	public static void main(String[] args) {
		
		
			AbstractApplicationContext factory = 
	new GenericXmlApplicationContext("applicationContext.xml");

	//������ �����̳ʷκ��� Bean�� ȣ�� : UserService : �������̽� 
			UserService userService = (UserService) factory.getBean("userService");	

			UserDTO userDTO = new UserDTO();
			userDTO.setId("admin");
			userDTO.setPassword("1234");
			
			//UserService �� �������̽� �޼ҵ� getUSER() ȣ���ϸ�, ���ϰ����� userDTO �޾ƿ�.
			
			UserDTO USER = userService.getUser(userDTO);
			
			
					
	}

}
