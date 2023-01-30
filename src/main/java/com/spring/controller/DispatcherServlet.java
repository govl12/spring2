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
public class DispatcherServlet extends HttpServlet { //HttpServlet�� ����ؼ� �������. 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();

    }
    
    
    //Ŭ���̾�Ʈ *.do ��û => web.xml=> DispatcherServlet ȣ�� => request() => process() response, request �Ű����� =>  

    //doGet���� �Ѿ���� ��û�� process() �޼ҵ忡�� ó�� �ϵ��� �ѱ�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post ����϶��� ����� ������ ���־�� ��.
		//Post ������� �����ǰ��� �ѱ� �� �ѱ� ������ ���� ó��
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	
	// doGet(request, response);
	}

	//doGet, doPost�� �Ѿ���� ��� ��û�� ó���ϴ� �޼ҵ� 
	private void process(HttpServletRequest request, HttpServletResponse repsonse) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do (��ü �ּ�) 
		// URI : ���� ��Ʈ �ڿ� ������ �ּ� boardweb/getBoardList.do
		
		// 1. Ŭ���̾�Ʈ�� ��û path������ �����Ѵ�.
		
		String uri = request.getRequestURI();		//boardweb/getBoardList.do
			System.out.println("uri : " + uri);
			
		
		
		String path = uri.substring(uri.lastIndexOf("/"));	// getBoardList.do
			System.out.println("path : " + path);
		
		
		
		//2. Ŭ���̾�Ʈ�� ��û ������ ���� �����ϰ� �б� ó����.
		
		if(path.equals("/login.do")) {
			
			System.out.println("����� ���� ó��");
			
		}else if(path.equals("/getboardList.do")){
			
			System.out.println("�Խ��� ���� ���");
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("����� �α׾ƿ� ó��");
		}
		
		
		
		
		
		
	}
	
	
	
	
}
