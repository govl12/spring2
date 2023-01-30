package com.spring.common;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;


public class Client_test1 {	//DB Connection �׽�Ʈ

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Connection conn = null;
		
		//��ü ���� �� ��ü �̸����� ȣ��
		JDBCUtil db = new JDBCUtil();
		conn = db.getConnection();
		
		//��ü ���� ���� Ŭ���� �̸����� �ٷ� ȣ��.
		conn = JDBCUtil.getConnection();
	
		
		System.out.println("===============================");
		
		//������ �����̳ʷκ��� Bean�� ȣ�� : BoardService : �������̽� 
		BoardService boardService = (BoardService) factory.getBean("boardService");	
	
		//DTO ��ü�� ���� �Ŀ� DTO Setter�� ���� �����Ͽ� �� �ʵ忡 ���� ����. 
		BoardDTO boardDTO = new BoardDTO();
		
		//DTO �� Setter�� ����ؼ� �� �ʵ��� ���� �Ҵ� . : title, write, content
		boardDTO.setTitle("�ӽ����� - 4");
		boardDTO.setWriter("ȫ�浿");
		boardDTO.setContent("�ӽ� �����Դϴ�...");
		
		
		//insert ��� �׽�Ʈ �Ϸ�
		boardService.insertBoard(boardDTO);
		
		//Update ��� �׽�Ʈ
		boardDTO.setTitle("������ ����");
		boardDTO.setContent("�����ȳ���");
		boardDTO.setSeq(3); // ���� : DB���� �ݵ�� �����ؾ���(SEQ)
		
		//Update Board ��� �׽�Ʈ �Ϸ�
		boardService.updateBoard(boardDTO);
	}

}
