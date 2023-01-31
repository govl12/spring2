package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

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
			if(userD.getId() != null) { // 클라이언트에게 전송한 ID와 Pass가 DB의 값과 일치할 때
				response.sendRedirect("getBoardList.do");
				System.out.println("아이디와 패스워드가 일치");
			}else { //Client에게 전송한 id와 pass 중 일치하지 않을 때
				response.sendRedirect("login.jsp");
				System.out.println("아이디와 패스워드가 불일치");
			}
			
			
		}else if(path.equals("/getboardList.do")){
			
			System.out.println("게시판 정보 출력");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("사용자 로그아웃 처리");
		}
		
		
		
		
		
		
	}
	
	
	
	
}
