package com.spring.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Client_test1 {	//DB Connection �׽�Ʈ

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Connection conn = null;
		
		//��ü ���� �� ��ü �̸����� ȣ��
		JDBCUtil db = new JDBCUtil();
//		conn = db.getConnection();
		
		//��ü ���� ���� Ŭ���� �̸����� �ٷ� ȣ��.
		conn = JDBCUtil.getConnection();
		
	}

}
