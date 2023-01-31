package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_delete {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		//스프링 컨테이너로부터 Bean을 호출 : BoardService : 인터페이스 
				BoardService boardService = (BoardService) factory.getBean("boardService");	
			
				//DTO 객체를 생성 후에 DTO Setter를 통해 주입하여 각 필드에 값을 넣음. 
				BoardDTO boardDTO = new BoardDTO();
				
				//deleteBoard() 메소드 테스트 
				
				//DTO에 seq값을 할당 후, deleteBoard() 할당
				boardDTO.setSeq(7);	// seq 값 5번
				
				//deleteBoard(boardDTO)
				boardService.deleteBoard(boardDTO);
	
	}

}
