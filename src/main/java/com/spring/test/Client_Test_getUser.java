package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.users.UserDTO;
import com.spring.users.UserService;

public class Client_Test_getUser {

	public static void main(String[] args) {
		
		
			AbstractApplicationContext factory = 
	new GenericXmlApplicationContext("applicationContext.xml");

	//스프링 컨테이너로부터 Bean을 호출 : UserService : 인터페이스 
			UserService userService = (UserService) factory.getBean("userService");	

			UserDTO userDTO = new UserDTO();
			userDTO.setId("admin");
			userDTO.setPassword("1234");
			
			//UserService 에 인터페이스 메소드 getUSER() 호출하면, 리턴값으로 userDTO 받아옴.
			
			UserDTO USER = userService.getUser(userDTO);
			
			
					
	}

}
