package com.spring.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;


public class Client_test1 {	//DB Connection 테스트

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Connection conn = null;
		
		//객체 생성 후 객체 이름으로 호출
		JDBCUtil db = new JDBCUtil();
		conn = db.getConnection();
		
		//객체 생성 없이 클래스 이름으로 바로 호출.
		conn = JDBCUtil.getConnection();
	
		
		System.out.println("===============================");
		
		//스프링 컨테이너로부터 Bean을 호출 : BoardService : 인터페이스 
		BoardService boardService = (BoardService) factory.getBean("boardService");	
	
		//DTO 객체를 생성 후에 DTO Setter를 통해 주입하여 각 필드에 값을 넣음. 
		BoardDTO boardDTO = new BoardDTO();
		
		//DTO 의 Setter를 사용해서 각 필드의 값을 할당 . : title, write, content
		boardDTO.setTitle("임시제목 - 4");
		boardDTO.setWriter("홍길동");
		boardDTO.setContent("임시 내용입니다...");
		
		
		//insert 기능 테스트 완료
		boardService.insertBoard(boardDTO);
		
		//Update 기능 테스트
		boardDTO.setTitle("수정된 제목");
		boardDTO.setContent("수정된내용");
		boardDTO.setSeq(3); // 주의 : DB에서 반드시 존재해야함(SEQ)
		
		//Update Board 기능 테스트 완료
		boardService.updateBoard(boardDTO);
	}

}
