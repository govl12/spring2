package com.spring.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

@Repository("boardDAO")	//Spring Framework 에서 자동으로 객체가 생성되어서 RAM(메모리)에 로드.
public class BoardDAO /* implements BoardService */{
		//DAO : Date Access Object 
		//DataBase에 CRUD 하는 객체 : Select, Insert ,Update, Delete
	
	//1. JDBC 관련 변수를 선언 : Connection, Statement / PreparedStatement, ResultSet
		private Connection conn = null;
		private Statement stmt = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null; 
		
	//2. SQL 쿼리를 담는 상수에 담아서 처리 변수 생성 후 할당 : 상수명 : 전체 대문자로 사용
		private final String BOARD_INSERT="insert into board(seq,title,writer,content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
		private final String BOARD_UPDATE="update board set title=?,content = ? where seq =?";
		private final String BOARD_DELETE="delete board where seq =?";
		private final String BOARD_GET="select * from board where seq=?";		//Database의 테이블에서 1개의 레코드만 출력 (상세보기(
		private final String BOARD_LIST="select * from board order by seq desc";		//DataBase의 테이블의 여러개의 레코드를 LIST (ArrayList))
	
		
	
	//3. 메소드 : 
			//insertBoard(), updateBoard(), deleteBoard() < == 리턴값이 없다. void
			// getBoard() :select 한 결과를 BoardDTO에 담아서 전송, 가져온 레코드가 1개
			// getBoardList() : 각각의 레코드를 DTO(1개), ArrayList에 DTO 객체를 담아서 리턴.
	
		//3-1 . 글 등록 처리 메소드 : insertBoard()

		public void insertBoard(BoardDTO dto) {	 
			System.out.println("==>jdbc로 insertBoard() 기능 처리 - 시작");
			
			try {	
				//오류가 발생시 프로그램이 종료되지 않도록 try catch 블락으로 처리 
				
					//Connection 객체를 사용해서 PreparedStatement 객체 활성화 
					conn = JDBCUtil.getConnection();
					// BOARD_INSERT="insert into board(seq,title,writer,content) "
							//+ "values((select nvl(max(seq), 0)+1 from board),?,?,?)";
					pstmt = conn.prepareStatement(BOARD_INSERT);
					
					//pstmt에 ?에 변수값을 할당.
					pstmt.setString(1, dto.getTitle());
					pstmt.setString(2, dto.getWriter());
					pstmt.setString(3, dto.getContent());
				
					pstmt.executeUpdate();
			
					System.out.println("==>jdbc로 insertBoard() 기능 처리 - 완료");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("==>jdbc로 insertBoard() 기능 처리 - 실패");
			}finally {
				JDBCUtil.close(pstmt, conn);
				System.out.println("모든 객체가 잘 close()되었습니다.");
			}
			
		}
		
		//3-2 . 글 수정 처리 메소드 : updateBoard()
		
				public void updateBoard(BoardDTO dto) {	
					System.out.println("==>jdbc로 updatetBoard() 기능 처리");
					
					try {
						conn=JDBCUtil.getConnection();
//						BOARD_UPDATE="update board set title=?,content = ? where seq =?";
						pstmt = conn.prepareStatement(BOARD_UPDATE);
							
						//pstmt?의 ?에 dto에서 넘어오는 변수 값 할당.
						pstmt.setString(1, dto.getTitle());
						pstmt.setString(2, dto.getContent());
						pstmt.setInt(3, dto.getSeq());
						
						pstmt.executeUpdate();
						
						System.out.println("==>jdbc로 updatetBoard() 기능 처리 - 완료");
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("==>jdbc로 updatetBoard() 기능 처리 - 실패");
						
					}finally {
						JDBCUtil.close(pstmt, conn);
					
					}
					
				}
		//3-3 . 글 삭제 처리 메소드 : deleteBoard()

				public void deleteBoard(BoardDTO dto) {	 
					System.out.println("==>jdbc로  deleteBoard() 기능 처리");
					
					try {
						conn = JDBCUtil.getConnection();
//						 BOARD_DELETE="delete board where seq =?";
						pstmt = conn.prepareStatement(BOARD_DELETE);
						//pstmt 의 ? 에 dto 에서 넘어오는 변수 값 할당.
						pstmt.setInt(1, dto.getSeq());
						
						pstmt.executeUpdate();
						
						System.out.println("==>jdbc로  deleteBoard() 기능 처리 - 완료");						
					}catch(Exception e){
						e.printStackTrace();
						System.out.println("==>jdbc로  deleteBoard() 기능 처리 - 실패");
					}finally{
						JDBCUtil.close(pstmt, conn);
					}
				}		
		//3-4 . 글 상세조회 처리 메소드 : getBoard() : 레코드 1개를 DB에서 Select 해서 DTO 객체에 담아서 리턴.
	
				public BoardDTO getBoard(BoardDTO dto) {	 
					System.out.println("==>JDBC로 getBoard() 기능처리 - 시작");
					
					//리턴으로 돌려줄 변수(board) 선언 : try ~ catch 블록 밖에서 선언하여야 함.
					BoardDTO board = new BoardDTO();
					//System.out.println("dto seq ; " + dto.getSeq());
					
					
					try {
						//객체 생성 : Connection, PreparedStatement
						conn = JDBCUtil.getConnection();
						pstmt = conn.prepareStatement(BOARD_GET);
						pstmt.setInt(1,dto.getSeq());
						
						//DB를 SELECT한 결과를 rs에 저장함.
						rs = pstmt.executeQuery();
						
						//rs에 담긴 값을 DTO에 저장해서 리턴으로 돌려줌.
						
						if(rs.next()) {	//rs의 값이 존재한다면, rs의 값을 DTO에 담아서 리턴
							board.setSeq(rs.getInt("SEQ"));
							board.setTitle(rs.getString("TITLE"));
							board.setWriter(rs.getString("WRITER"));
							board.setContent(rs.getString("CONTENT"));
							board.setRegDate(rs.getDate("REGDATE"));
							board.setCnt(rs.getInt("CNT"));
							
							
						}else {
							System.out.println("레코드의 결과가 없습니다.");
						}
						
						System.out.println("==>jdbc로  getBoard() 기능 처리 - 완료");
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("==>jdbc로 getBoard() 기능 처리 - 실패");
					}finally {
						JDBCUtil.close(rs, pstmt, conn);					
					}
					return board;
				}
				
		//3-5. 글 목록 처리 메소드 : getBoardList() : 많은 레코드
				// dto -> list에 담는다..
				public List<BoardDTO> getBoardList(BoardDTO dto){
					System.out.println("==> JDBC로 getBoardList() 기능처리 - 시작");
					
					//리턴 돌려줄 변수 선언 : List = 인터페이스, 
						//ArrayList, Vector ,LinkedList <== List 인터페이스를 구현한 클래스
							//ArrayList : 싱글 쓰레드 환경
							//Vector : 멀티쓰레드 환경
							//LinkedList : 자주 수정, 삭제 시 성능이 빠르게 처리됨.
					
					List<BoardDTO> boardList = new ArrayList<BoardDTO>();
					BoardDTO board;
					//BoardDTO board = new BoardDTO();
					// 모든 객체가 동일한 주소값을 가지게 되어 한개만 계속 출력됨. 그래서 선언만 하고 밑에서 값 넣기 
					
					try {
						conn = JDBCUtil.getConnection();
						//BOARD_LIST = "select * from board order by seq desc";
						pstmt = conn.prepareStatement(BOARD_LIST);
						// 모든 컬럼을 가져오므로 ?에 변수값 할당할 필요 없음.
						
						rs = pstmt.executeQuery();
						
						if(rs.next()) {	//rs.next가 존재하는 경우
							do {
								
								//DTO 객체는 여기서 만들어야함. (별도의 객체에 담기도록)
								board = new BoardDTO();
								
								//rs에서 가져온 1개의 레코드를 board(DTO)
								board.setSeq(rs.getInt("SEQ"));
								board.setTitle(rs.getString("TITLE"));
								board.setWriter(rs.getString("WRITER"));
								board.setContent(rs.getString("CONTENT"));
								board.setRegDate(rs.getDate("REGDATE"));
								board.setCnt(rs.getInt("CNT"));
								
								//boardList : ArrayList 에 add () 메소드를 사용해서 board(DTO)를 저장.
								boardList.add(board);
								
							}while(rs.next());
							
							
						}else { //rs.next가 존재하지 않는 경우
							System.out.println("테이블에 레코드가 비어있습니다.");
						}
						
						System.out.println("==> JDBC로 getBoardList() 기능처리 - 완료");
						
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println("==> JDBC로 getBoardList() 기능처리 - 실패");
						
					}finally {
						JDBCUtil.close(rs, pstmt, conn);
					}
					
					return boardList;
				}
		
	
}
