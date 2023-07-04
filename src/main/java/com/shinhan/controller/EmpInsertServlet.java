package com.shinhan.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.model.EmpService;
import com.shinhan.util.DateUtil;
import com.shinhan.vo.EmpVO;

/**
 * Servlet implementation class EmpInsertServlet
 */
//@WebServlet("/emp/empinsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//직원 등록 페이지 보여주기
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력된 파라메터 읽어서 DB에 저장하기 위해 옴
		EmpVO emp = makeEmp(request);
		EmpService service = new EmpService();
		String result = service.empInsert(emp);
		
		//재요청하기:Browser로 내려가서 새로운 요청으로 가기 
		response.sendRedirect("emplist.do");
		
	}

	private EmpVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		//필터에서 수행하고 옴request.setCharacterEncoding("utf-8");
		//int empid = Integer.parseInt(request.getParameter("employee_id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		Date hire_date = DateUtil.convertToDate(request.getParameter("hire_date"));
		String job_id = request.getParameter("job_id");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		Double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		//emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		
		System.out.println(emp);
		return emp;
		
	}
	
	

}
