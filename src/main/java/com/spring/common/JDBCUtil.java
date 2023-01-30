package com.spring.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
		//DB�� ���� �����ϴ� Ŭ���� 
	
	//1.DB�� �����ϴ� �޼ҵ� 
		//static Ű���� : ��ü ���� ���� Ŭ�����̸��� �ٷ� ȣ�� �� �� ����.
	public static Connection getConnection() {
		String driver ="oracle.jdbc.driver.OracleDriver";
		//String driver = "org.h2.Driver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		//String url = "jdbc:h2:tcp://localhost/~/test";
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn =  DriverManager.getConnection(url,"C##HR","1234"); // Ŀ�ؼ��� �ߵǸ�..
												//URL, ������, ��ȣ 
			//conn = DriverManager.getConnection(url,"sa","");
	
			//Ȯ�� �� �ּ� ó�� 
			System.out.println("DB�� �� ���� �Ǿ����ϴ�.");

			return conn;
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB���ῡ �����߽��ϴ�.");
		}
		return null;//Ŀ�ؼ��� �ȵǸ�.. ��ü ����
		
		
	}	//�޼ҵ� ȣ���ϸ� Connection ��ü�� �����ϰ� ��! 
	
	
	
	//2. DB������ �����ϴ� �޼ҵ� : Connection, PreparedStatement ��ü�� ���� 
		//Insert, Update, Delete 
	public static void close(PreparedStatement pstmt, Connection conn) {	
		if (pstmt!=null) {
			try {
				if(!pstmt.isClosed()) {	// pstmt��ü�� close���� ���� ����(���ŵ��� ���� ����)
					pstmt.close();
					System.out.println("pstmt ��ü close");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				pstmt = null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
					System.out.println("conn ��ü close()");
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
							
			}	
		}		
		
			//3. DB������ �����ϴ� �޼ҵ� : Connection, PreparedStatment , ResultSet��ü�� ����
		//Select 
		public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {	
			if (rs!=null) {
				//try catch ����ϴ� ���� : ������ �߻��Ǵ��� ������ �����..
				try {
					if(!rs.isClosed()) {	// pstmt��ü�� close���� ���� ����(���ŵ��� ���� ����)
						rs.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					rs = null;
				}
			}
			
			
			if (pstmt!=null) {
				try {
					if(!pstmt.isClosed()) {	// pstmt��ü�� close���� ���� ����(���ŵ��� ���� ����)
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
			}
			
			
			if(conn!=null) {
				try {
					if(!conn.isClosed()) {
						pstmt.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					conn = null;
				}
								
				}	
			}		
		}

