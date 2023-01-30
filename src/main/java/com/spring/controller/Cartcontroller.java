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

	
	protected void doGet(HttpServletRequest request/* Ŭ���̾�Ʈ�� ��û �޴¸Ű����� */, HttpServletResponse response /* Ŭ���̾�Ʈ���� ���� ���� �Ű����� */) throws ServletException, IOException {
		
		process(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //�ѱ� �������� ����.
		
		//post ������� �Ѿ���� ��û�� request�� �� �޾Ƽ�. do get �޼ҵ带 ȣ���ϸ鼭 ó��.
		process(request, response);
	}

	//doGet, doPost�� �Ѿ� ���� Ŭ���̾�Ʈ ��û�� process() �޼ҵ��ؼ� �Ѳ����� ó�� 
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Ŭ���̾�Ʈ ��û������ �����ؾ���. path ������ �Ҵ�.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
			System.out.println(uri);
			System.out.println(path);
			
		if (path.equals("/cart.ca")) {
			System.out.println("cart.ca�� ��û �߽��ϴ�.");
			
		}else if(path.equals("/cart_add.ca")) {
			System.out.println("cart_add.ca�� ��û�߽��ϴ�.");
		}
		
		
		
		
	}
	

}
