package com.shinhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class TimeCheckFilter
 */
//@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter implements Filter {
       
    
    public TimeCheckFilter() {
        System.out.println("TimeCheckFilter의 생성자");
    }

	
	public void destroy() {
		System.out.println("TimeCheckFilter의 소멸자");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//

		// 요청filter
		long startTime = System.nanoTime();
		chain.doFilter(request, response);
		// 응답 filter
		long endTime = System.nanoTime();
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println(uri+"를 처리하는데 걸린시간은 "+(endTime-startTime)+"ns");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("TimeCheckFilter의 init");
	}

}
