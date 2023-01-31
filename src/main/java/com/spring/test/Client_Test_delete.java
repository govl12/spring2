package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_delete {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		//������ �����̳ʷκ��� Bean�� ȣ�� : BoardService : �������̽� 
				BoardService boardService = (BoardService) factory.getBean("boardService");	
			
				//DTO ��ü�� ���� �Ŀ� DTO Setter�� ���� �����Ͽ� �� �ʵ忡 ���� ����. 
				BoardDTO boardDTO = new BoardDTO();
				
				//deleteBoard() �޼ҵ� �׽�Ʈ 
				
				//DTO�� seq���� �Ҵ� ��, deleteBoard() �Ҵ�
				boardDTO.setSeq(7);	// seq �� 5��
				
				//deleteBoard(boardDTO)
				boardService.deleteBoard(boardDTO);
	
	}

}
