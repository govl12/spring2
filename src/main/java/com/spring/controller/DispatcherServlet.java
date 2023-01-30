package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	private void process(HttpServletRequest request, HttpServletResponse repsonse) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do (전체 주소) 
		// URI : 서버 포트 뒤에 나오는 주소 boardweb/getBoardList.do
		
		// 1. 클라이언트의 요청 path정보를 추출한다.
		
		String uri = request.getRequestURI();		//boardweb/getBoardList.do
			System.out.println("uri : " + uri);
			
		
		
		String path = uri.substring(uri.lastIndexOf("/"));	// getBoardList.do
			System.out.println("path : " + path);
		
		
		
		//2. 클라이언트의 요청 정보에 따라서 적절하게 분기 처리함.
		
		if(path.equals("/login.do")) {
			
			System.out.println("사용자 정보 처리");
			
		}else if(path.equals("/getboardList.do")){
			
			System.out.println("게시판 정보 출력");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("사용자 로그아웃 처리");
		}
		
		
		
		
		
		
	}
	
	
	
	
}
