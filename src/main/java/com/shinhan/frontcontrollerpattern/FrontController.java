package com.shinhan.frontcontrollerpattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * doGet, doPost 합친것 = service
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		CommonControllerInterface controller = null;
		Map<String, Object> data = new HashMap<>();
		data.put("method", request.getMethod());  //get인지 post인지 모르니까 받아옴
		data.put("request", request);
		switch (path) {
		case "/site-result/layout.do":
			controller = new layoutTestController();
			break;
		case "/site-result/jobsAjax.do":
			controller = new jobsAjaxController();
			break;
		case "/download.do":
			data.put("response", response);
			controller = new DownloadController();
			break;
		case "/upload.do":
			controller = new UploadController();
			break;
		case "/jstl.do":
			controller = new JSTLController();
			break;
		case "/auth/loginCheck.do":
			controller = new LoginController();
			break;
		case "/auth/logout.do":
			controller = new LogoutController();
			break;
		case "/auth/signup.do":
			controller = new SignUpController();
			break;
		case "/auth/emailDupCheck.do":
			controller = new EmailDupCheckController();
			break;
		case "/emp/emplist.do":
			controller = new EmpListController();
			break;
		case "/emp/empDetail.do":
			controller = new EmpDetailController();
			break;
		case "/emp/empinsert.do":
			controller = new EmpInsertController();
			break;
		case "/emp/empDelete.do":
			controller = new EmpDeleteController();
			break;
			
			
			
		default:
			break;
		}
		
		String page = null;
		try {
			page = controller.execute(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//auth/login.jsp
		//redirect:auth/loginCheck.do
		if(page.indexOf("redirect:")>=0) {
			response.sendRedirect(page.substring(9));
		}else if(page.indexOf("responseBody:")>=0){
			response.getWriter().append(page.substring(13));
		}else {
			RequestDispatcher rd;
			rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
		
		
		/*
		 * System.out.println(request.getMethod() + "요청");
		 * System.out.println(request.getRequestURI() + " uri");
		 * System.out.println(request.getServletPath() + " ServletPath");
		 */
	}

}
