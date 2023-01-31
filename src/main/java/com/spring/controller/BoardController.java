package com.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
//@WebServlet("/BoardController") //jsp에서 설치하면 오류 안남. 일단 안쓰니까 주석처리함
//생성자 
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
