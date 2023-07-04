package com.shinhan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.vo.EmpVO;

//@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); AdminVO user = (AdminVO)
		 * session.getAttribute("loginUser"); if(user == null) {
		 * response.sendRedirect("../auth/loginCheck.do"); return; }
		 * System.out.println("user: " + user);
		 */
		
		EmpService service = new EmpService();
		List<EmpVO> empList = service.selectAll();
		
		// request가 유지되는 동안 저장한다.
		request.setAttribute("empAll", empList);
		
		// 위임 (내가 요청을 받고 응답은 다른 페이지가 한다.)
		RequestDispatcher rd = request.getRequestDispatcher("empSelect.jsp");
		rd.forward(request, response);
		
	}

}