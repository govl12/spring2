package com.spring.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

@Repository("userDAO") // @Repository = Sprinframe work에 저장? / BEAN에 자동으로 등록되게 만듬. DAO에 객체를 자동으로 SPringframework에 생성 : Bean 생성
public class UserDAO /* implements UserService*/ {
	
	//JDBC 관련 변수 선언(Connection, PreparedStatement(Statement), ResultSet)
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//SQL 쿼리를 담은 상수를 선언 : (insert, update, delete, getUserList 생략 = Board에서 이미 했기 때문에..코드도 길어지고..)
	private final String USER_GET = "select * from users where id = ? and password = ?";
	
	//아이디와 패스워드 모두 해당 값이 맞아야 함. 틀리면 안됨. 
	
	//회원 정보를 가지고 오는 메소드 : getUser(dto);
	//UserDTO = 생성된 클래스 이름임.
	/*@Override*/
	public UserDTO getUser(UserDTO dto) {
		//객체 선언 : DB에서 select 한 레코드를 user에 담아서 리턴
		UserDTO user = new UserDTO(); // null; 하고 밑에서 선언해도 됨..
		
		System.out.println("DAO - " + dto.getId());
		System.out.println("DAO - " + dto.getPassword());
		try {
			System.out.println("==>JDBC로 getUser() 시작 ");
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			
			//pstmt에 할당된 쿼리에 ? , ? 변수값을 할당 후 실행 : 변수값 = DTO에서 매개변수값으로 할당.
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			
			rs = pstmt.executeQuery(); // select 문이므로 executeQuery()를 실행 후 rs로 리턴 
			
			//rs의 담긴 값을 가져와서 DTO(user)에 저장 후 리턴 돌려줌
			
			if (rs.next()) { //레코드의 값이 존재할 때 커서를 해당 레코드로 이동
				
				System.out.println("DB에서 값이 잘 Select 되었습니다.");
				
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				
				System.out.println("JDBC로 DB를 잘 쿼리해서 DTO로 전송");
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();	//개발이 완료된 후에는 주석 처리
			System.out.println("JDBC로 쿼리 실행 중 오류 발생");
			
		}finally {
			// 모두 사용한 객체를 제거 : conn, pstmt, rs 
			JDBCUtil.close(rs, pstmt, conn);;
			
		}
		
		return user;
		
		
	}

}
