package com.wokrsearch.controller;

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
import com.work.dao.WorkDao;
import com.work.dto.WorkDto;

@WebServlet("/worksearch/WorkSearchMainViewLogic.jsp")
public class WorkSearchMainViewLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_Head_Dto> list = dao.jog_head_list();
		request.setAttribute("joblist", list);
		
		AddrDao ddao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> ddto = ddao.head_search();
		request.setAttribute("addrlist", ddto);
		
		String[] age = {"10대","20대","30대","40대","50대","60대","지건딱대"};
		request.setAttribute("age_list", age);
		
		String[] sex = {"남자","여자"};
		request.setAttribute("sex", sex);
		
		WorkDao wdao = WorkDao.getInstance();
		ArrayList<WorkDto> wdto = wdao.search_list();
		request.setAttribute("worklist", wdto);
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSearchMainView.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
