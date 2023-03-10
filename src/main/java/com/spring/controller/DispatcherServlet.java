package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.board.BoardDAO;
import com.spring.board.BoardDTO;
import com.spring.users.UserDAO;
import com.spring.users.UserDTO;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet { //HttpServlet을 상속해서 만들어짐. 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();

    }
    
    
    //클라이언트 *.do 요청 => web.xml=> DispatcherServlet 호출 => request() => process() response, request 매개변수 =>  

    //doGet으로 넘어오는 요청을 process() 메소드에서 처리 하도록 넘김.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post 방식일때는 몇가지의 설정을 해주어야 함.
		//Post 방식으로 변수의값을 넘길 때 한글 깨어짐 방지 처리
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	
	// doGet(request, response);
	}

	//doGet, doPost로 넘어오는 모든 요청을 처리하는 메소드 
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do (전체 주소) 
		// URI : 서버 포트 뒤에 나오는 주소 boardweb/getBoardList.do
		
		// 1. 클라이언트의 요청 path정보를 추출한다.
		
		String url = request.getRequestURL().toString();// URL 정보를 게더링 .toString()
		System.out.println("url : "+ url);
		
		
		
				
		String uri = request.getRequestURI();		//boardweb/getBoardList.do
			System.out.println("uri : " + uri);
			
		
		
		String path = uri.substring(uri.lastIndexOf("/"));	// getBoardList.do
			System.out.println("path : " + path);
		
		
		
		//2. 클라이언트의 요청 정보에 따라서 적절하게 분기 처리함.
			
		if(path.equals("/login.do")) {
			
			// 클라이언트 요청에 대해서 : /login.do 요청
			//1. Model : Service( 비즈니스 로직을 처리), DTO, DAO 
			//2. View 페이지로 전달 : *.jsp 파일 
			
			System.out.println("사용자 정보 처리");
			System.out.println("/login.do 요청을 보냈습니다.");
			
			
			//1. 클라이언트에서 보내는 변수 값을 받아서 변수에 저장
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			System.out.println("폼에서 넘긴 변수 id 값 출력 : " + id);
			System.out.println("폼에서 넘긴 변수 password 값 출력 : " + password);
			
			//2. 클라이언트에서 넘긴 변수 값을 받아서 저장된 변수를 DTO에 Setter 주입
			UserDTO dto = new UserDTO();
			dto.setId(id);
			dto.setPassword(password);
			
			//3. 비즈니스 로직을 처리하는 인터페이스에 dto를 주입해서 비즈니스 로직 처리 
			//UserService user = new UserServiceImpl();
			UserDAO user = new UserDAO ();
			UserDTO userD = user.getUser(dto);
			
			// DB의 클라이언트에서 넘긴 id와 password 를 select 해서 그 값을 DTO에 담아서 리턴 
			System.out.println(userD);
			
			
			//4. 백엔드의 로직을 모두 처리 후 View 페이지로 이동
			//아이디, 비번이 일치하여 DB rs의 값이 존재
			if(userD.getId() != null) { // 클라이언트에게 전송한 ID와 Pass가 DB의 값과 일치할 때
				response.sendRedirect("getBoardList.do"); 
				// response.sendRedirect("getBoardList.do") : 컨트롤러에게 다시 호출하도록 설정하는 것 
				System.out.println("아이디와 패스워드가 일치");
			}else { //Client에게 전송한 id와 pass 중 일치하지 않을 때
				response.sendRedirect("login.jsp");
				System.out.println("아이디와 패스워드가 불일치");
			}
			
			
		}else if(path.equals("/getBoardList.do")){
			System.out.println("게시판 정보 출력");
			
			//1. Client 로부터 /getBoardList.do 요청을 받음. (게시판 정보를 출력해 달라고 요청)
			
			//2. 비즈니스 로직 처리
			BoardDTO dto = new BoardDTO();
			BoardDAO dao = new BoardDAO(); //임포트 해오는게 맞나..?
			
			//boardList 에는 DB에서 쿼리한 레코드를 담은 DTO 객체가 내장되어 있다.
			List<BoardDTO> boardList = dao.getBoardList(dto);
			
			//3. 클라이언트에게 boardList를 전달해야 한다.
			//(세션 객체에 boardList 객체를 담아서 클라이언트에게 전송 시킴)
			// 세션은 서버의 RAM에 저장됨
			// 쿠키 : 클라이언트 시스템의 HDD에 정보를 저장함.
			HttpSession session = request.getSession();
			//session 객체에 값을 저장, setAttribute("변수명", 객체 );
			//session 객체에 값을 가지고 올 때 getAttribute("변수명", 객체);
			session.setAttribute("boardList", boardList);
			
			
			//4. 뷰페이지로 이동
			response.sendRedirect("getBoardList.jsp");
			
			
			}else if (path.equals("/insertBoard.do")) {
			
				System.out.println("board 테이블에 값을 저장");
				//1. 클라이언트에서 넘어오는 변수 값을 받아서 새로운 변수에 저장
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				
				//2. 비즈니스 로직 처리( 클라이언트 변수를 dto에 저장 후 dao의 insertBoard(dto) - (insertBoard호출하면서 dto를 매개변수로..)
				BoardDTO dto = new BoardDTO();// 메소드 내부이므로 객체 계속 생성해주어야함.
				BoardDAO dao = new BoardDAO();
				
					//dto의 setter메소드 호출 시 클라이언트에서 넘어온 변수값을 매개변수로 할당.
				dto.setTitle(title);
				dto.setWriter(writer);
				dto.setContent(content);
				
				dao.insertBoard(dto);	//DB에 Insert/Update/delete가 완료됨. ㅑ백엔드 비즈니스 로직 처 리 완 료!
				
				//3. View 페이지를 전송
				response.sendRedirect("getBoardList.do");
				
				
				
			}else if (path.equals("/getBoard.do")) {
				
				System.out.println("게시판 상세 내용 보기- /getBoard.do요청");
			
				//1. 클라이언트에서 넘긴 변수값 받기 ("seq")
				String seq = request.getParameter("seq"); // request.getParameter로 넘어오는 값은 String. 
				System.out.println("seq변수값 : " + seq );
				
				
				//2. 비즈니스 로직 처리 : 파라미터로 받은 값을 DTO에 저장 후 getBoard(dto) 메소드 호출
				BoardDTO dto = new BoardDTO();
				BoardDAO dao = new BoardDAO();
				//클라이언트에게 받은 값을 dto에 setter 주입 
				dto.setSeq(Integer.parseInt(seq));
				
				
				//리턴을 받아온다
			BoardDTO board = dao.getBoard(dto);
			
			//DB의 값이 저장된 DTO(board)를 session 변수에 할당해서 뷰페이지로 전달
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//3. 뷰 페이지로 전달
			response.sendRedirect("getBoard.jsp");
				
			}else if (path.equals("/updateBoard.do")) {
							
				System.out.println("글 수정 처리");
				
				
				//1. 클라이언트에서 넘어오는 변수를 받음.
				
				String title  = request.getParameter("title");
				String content = request.getParameter("content");
				String seq = request.getParameter("seq");

//				System.out.println(title);
//				System.out.println(content);
//				System.out.println(seq);
				
				//2. DTO , DAO 객체를 사용해서 비즈니스 로직 처리
				BoardDTO dto = new BoardDTO();
				BoardDAO dao = new BoardDAO();
				
				dto.setSeq(Integer.parseInt(seq));
				dto.setTitle(title);
				dto.setContent(content);
				
				dao.updateBoard(dto);
				
				
				//3. 백엔드의 로직을 모두 처리 후 client에게 view 페이지로 이동
				response.sendRedirect("getBoardList.do");// .jsp, .do 구분 하기 

				
			}else if (path.equals("/deleteBoard.do")) {
				
				System.out.println("글 삭제 처리");// 오 된다.오 근데 삭제하면 목록페이지롱 ㅣ동 안하는뎅
				
				//1. 클라이언트에서 넘긴 seq 를 받아서 변수에 저장함.
				String seq = request.getParameter("seq");
				
				//2. DTO, DAO에 로직 처리(백엔드에 비즈니스 로직 처리)
				BoardDTO dto = new BoardDTO();
				BoardDAO dao = new BoardDAO();
				
				dto.setSeq(Integer.parseInt(seq));
				
				System.out.println("dto에 저장됨");
				dao.deleteBoard(dto); 
				
				//3. 비즈니스 로직 처리 완료 후 View 페이지로 이동 
				response.sendRedirect("getBoardList.do");
				
			}else if (path.equals("/logout.do")) {
			
				System.out.println("사용자 로그 아웃 처리");
				
			
		
			
			}
		
			
			
		}
		
		
}