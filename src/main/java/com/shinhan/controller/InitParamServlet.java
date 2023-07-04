package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
/*
 * @WebServlet(urlPatterns = {"/initparam"}, initParams =
 * {@WebInitParam(name="address", value="서울시"),
 * 
 * @WebInitParam(name="phone", value="1234")} )
 */
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public InitParamServlet() {
		System.out.println("InitParamServlet생성자");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet----초기화");
	}
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String address = getInitParameter("address");
		String phone = getInitParameter("phone");
		
		System.out.println(address);
		System.out.println(phone);
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
