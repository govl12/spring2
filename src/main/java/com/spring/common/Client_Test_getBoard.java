package com.spring.common;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_getBoard {

	public static void main(String[] args) {

		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		//스프링 컨테이너로부터 Bean을 호출 : BoardService : 인터페이스 
				BoardService boardService = (BoardService) factory.getBean("boardService");	
				
		//DTO 객체를 생성 후에 DTO Setter를 통해 주입하여 각 필드에 값을 넣음. 
				BoardDTO boardDTO = new BoardDTO();
				
				// 글 상세보기 : 1개의 레코드만 출력,
				boardDTO.setSeq(1);
				
				//getBoard(boardDTO)==> 리턴으로 DTO
				
				BoardDTO dbDTO = boardService.getBoard(boardDTO);
				
				//toString() 재정의 되어 있음. : DB에서 SELECT 한 레코드 값을 출력
				System.out.println(dbDTO);
	}

}
