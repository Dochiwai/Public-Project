package com.resume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_End_Dto;
import com.resume.dto.Resume_Middle_Dto;


@WebServlet("/resume/ResumeEndSearch.jsp")
public class ResumeEndSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String middle_job = request.getParameter("job_middle");
		response.getWriter().write(getJSON(middle_job));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public String getJSON(String middle_job) {
		if(middle_job == null) middle_job = "";
		StringBuffer result = new StringBuffer("");
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_End_Dto> list = dao.endsearch(middle_job);
		
		for(int i = 0; i <list.size(); i++){
			result.append("<input type = 'radio' name = 'j_end_name' id = 'j_end_id' value = " + list.get(i).getJ_id() + ">" + list.get(i).getJ_end_job() + "<br>");
		}
		return result.toString();
	}
}
