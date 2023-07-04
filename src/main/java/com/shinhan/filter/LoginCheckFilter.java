package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("*.do")//css, js, jsp, servlet, image
public class LoginCheckFilter extends HttpFilter implements Filter {
       
    
    public LoginCheckFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		System.out.println("req.getServletPath() : "+req.getServletPath());
		if(req.getRequestURI().equals(req.getContextPath()+"/auth/loginCheck.do")||
				req.getServletPath().equals("/auth/signup.do")||
				req.getServletPath().equals("/auth/emailDupCheck.do")||
				req.getServletPath().equals("/jstl.do")||
				req.getServletPath().equals("/site-result/layout.do")||
				req.getServletPath().equals("/site-result/jobsAjax.do")) {
			//
			
		}else {
			HttpSession session = req.getSession();
			AdminVO user = (AdminVO) session.getAttribute("loginUser");
			if(user == null) {
				rep.sendRedirect("../auth/loginCheck.do");
				return;
			}
			System.out.println("user: " + user);
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
