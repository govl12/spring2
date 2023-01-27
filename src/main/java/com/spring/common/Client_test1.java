package com.spring.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Client_test1 {	//DB Connection 테스트

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Connection conn = null;
		
		//객체 생성 후 객체 이름으로 호출
		JDBCUtil db = new JDBCUtil();
//		conn = db.getConnection();
		
		//객체 생성 없이 클래스 이름으로 바로 호출.
		conn = JDBCUtil.getConnection();
		
	}

}
