package com.shinhan.frontcontrollerpattern;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import com.shinhan.model.CompanyService;
import com.shinhan.vo.JobVO;

public class jobsAjaxController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> data) throws Exception {
		//모든 job조회하기
		CompanyService service = new CompanyService();
		HttpServletRequest request = (HttpServletRequest)data.get("request");
		List<JobVO> joblist = service.jobSelectAll();
		request.setAttribute("jobList", joblist);
		
		//1)JavaScript로 작성된 ajax부분에 전달하는 방법1 --JSP만들어서 보낸다.(HTML로 디자인)
		//return "jobView.jsp";
		
		//2)Javascript로 작성된 ajax부분에 전달하는 방법2 --JSON만들어서 보낸다.(JS로 디자인)
		JSONObject obj = new JSONObject();
		obj.put("job_id", "IT");
		obj.put("job_title", "IT programmer");
		
		return "responseBody:"+obj.toJSONString();
	}

}
