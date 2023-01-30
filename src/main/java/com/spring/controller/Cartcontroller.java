package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/Cartcontroller")
public class Cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Cartcontroller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request/* 클라이언트의 요청 받는매개변수 */, HttpServletResponse response /* 클라이언트에게 정보 전달 매개변수 */) throws ServletException, IOException {
		
		process(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //한글 깨짐현상 방지.
		
		//post 방식으로 넘어오는 요청은 request로 다 받아서. do get 메소드를 호출하면서 처리.
		process(request, response);
	}

	//doGet, doPost로 넘어 오는 클라이언트 요청을 process() 메소드해서 한꺼번에 처리 
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 요청정보를 추출해야함. path 변수에 할당.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
			System.out.println(uri);
			System.out.println(path);
			
		if (path.equals("/cart.ca")) {
			System.out.println("cart.ca를 요청 했습니다.");
			
		}else if(path.equals("/cart_add.ca")) {
			System.out.println("cart_add.ca를 요청했습니다.");
		}
		
		
		
		
	}
	

}
