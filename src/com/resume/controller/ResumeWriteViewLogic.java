package com.resume.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.dao.AddrDao;
import com.addr.dto.Head_Addr_Dto;
import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_Head_Dto;

@WebServlet("/resume/ResumeWriteViewLogic.jsp")
public class ResumeWriteViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_Head_Dto> list = dao.jog_head_list();
		request.setAttribute("list", list);
		
		AddrDao ddao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> ddto = ddao.head_search();
		request.setAttribute("headlist", ddto);
		
		RequestDispatcher rd = request.getRequestDispatcher("resumeWriteView.jsp");
		rd.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
