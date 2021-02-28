package com.resume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_Middle_Dto;

@WebServlet("/resume/ResumeMiddleSearch.jsp")
public class ResumeMiddleSearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String head_job = request.getParameter("job_head");
		response.getWriter().write(getJSON(head_job));
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public String getJSON(String head_job) {
		if(head_job == null) head_job = "";
		StringBuffer result = new StringBuffer("");
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_Middle_Dto> list = dao.middleseacrch(head_job);
		
		for(int i = 0; i <list.size(); i++){
			result.append("<input type = 'radio' name = 'j_middle_name' id = 'j_middle_id' value = " + list.get(i).getJ_id() + ">" + list.get(i).getJ_middle_job() + "<br>");
		}
		return result.toString();
	}
}

