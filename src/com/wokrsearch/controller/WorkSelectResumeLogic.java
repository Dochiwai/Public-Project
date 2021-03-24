package com.wokrsearch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_User_Dto;

@WebServlet("/worksearch/WorkSelectResumeLogic.jsp")
public class WorkSelectResumeLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String worknum = request.getParameter("workid");
		request.setAttribute("work_num", worknum);
		System.out.println(worknum);
		
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_User_Dto> list = dao.getuserresume(id);
		request.setAttribute("resumelist", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSelectResume.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
