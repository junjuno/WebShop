package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLPatternTest
 */
//@WebServlet("/url/test")  //이름이 일치하는 URL pattern
//@WebServlet("/url/test/*")  //폴더 형태
@WebServlet("*.go")  //확장자 URL pattern인 경우 폴더와 같이 사용안됨

public class URLPatternTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URLPatternTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getContextPath : "+request.getContextPath());
		System.out.println("getRequestURI : "+request.getRequestURI());
		System.out.println("getRequestURL : "+request.getRequestURL());
		System.out.println("getMethod : "+request.getMethod());
		System.out.println("getRemoteAddr : "+request.getRemoteAddr());
		//서버에 접속한 client IP address
		System.out.println("getServletPath : "+request.getServletPath());
		System.out.println("getPathInfo : "+request.getPathInfo());
		//요청한 URL 이름 뒷부분의 url
		System.out.println("getQueryString : "+request.getQueryString());
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
