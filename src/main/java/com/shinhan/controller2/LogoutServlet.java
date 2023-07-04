package com.shinhan.controller2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

/**
 * Servlet implementation class LogoutServlet
 */
//@WebServlet("/auth/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout.do.....");
		request.getSession(false).invalidate();
		//invalidate() : 서버쪽 세션이 지워짐, Browser 접속을 해제하기
		
		ServletContext app = getServletContext();
		HttpSession session = request.getSession();
		
		Object obj = app.getAttribute("userList");
		AdminVO admin = (AdminVO)session.getAttribute("loginUser");
		List<AdminVO> userList = null;
		if(obj!=null) {
			userList = new ArrayList<>();
			userList.remove(admin);
			app.setAttribute("userList", userList);
		}
			
		
	}

	

}
