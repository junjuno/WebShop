package com.shinhan.frontcontrollerpattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shinhan.vo.AdminVO;

public class JSTLController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		// /로 시작하면 절대 /가 없으면 상대경로이다.
		// /webShop생략되어있으므로 현재는 모두 가능하다.
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		application.setAttribute("myName", "김길동application");
		session.setAttribute("myName", "박길동session");
		request.setAttribute("myName", "홍길동request");
		
		List<AdminVO> adminList = new ArrayList<>();
		adminList.add(new AdminVO("abc1@naver.com","김1","1234"));
		adminList.add(new AdminVO("abc2@naver.com","김2","1234"));
		adminList.add(new AdminVO("abc3@naver.com","김3","1234"));
		request.setAttribute("admins", adminList);
		
		request.setAttribute("score", 71);
		request.setAttribute("today", new Date());
		
		
		return "/jsptest/jstlTest3.jsp";
		//int count=0, request.setAttribute("count",0);
		/* for(AdminVO admin: adminList) */
		
		
	}

}
