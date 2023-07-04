package com.shinhan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BindingTestServlet1
 */
@WebServlet("/bind1")
public class BindingTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application영역(ServletContext)에 저장 (WAS가 살아있는 동안 유효)
		//session 영역(Browser가 살아있는 동안 유효)
		//request영역(request가 살아있는 동안 유효)
		ServletContext application = request.getServletContext();
		HttpSession broswer = request.getSession();
		
		
		application.setAttribute("mydata1", "application에 저장함");
		broswer.setAttribute("mydata2", "session에 저장함");
		request.setAttribute("mydata3", "request에 저장함");
		
		application.setAttribute("myname", "채히");
		broswer.setAttribute("myname", "짜히");
		request.setAttribute("myname", "채힝");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("bind2");
		rd.forward(request, response);
		
		/*
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append((String)application.getAttribute("mydata1")+"<br>")
		.append((String)broswer.getAttribute("mydata2")+"<br>")
		.append((String)request.getAttribute("mydata3")+"<br>");
		*/
	}

	

}
