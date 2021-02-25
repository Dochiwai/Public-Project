package com.resume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_User_Dto;

@WebServlet("/resume/ResumeMainViewLogic.jsp")
public class ResumeMainViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id =  (String)session.getAttribute("currentid");
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_User_Dto> list = dao.getuserresume(id);
		request.setAttribute("list",list);
		
				
		RequestDispatcher rd = request.getRequestDispatcher("resumeMainView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
