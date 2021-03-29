package com.wokrsearch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.support.dao.SupportDao;
import com.support.dto.SupportDto;

@WebServlet("/worksearch/WorkSupportListLogic.jsp")
public class WorkSupportListLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		
		SupportDao sdao = SupportDao.getInstance();
		ArrayList<SupportDto> slist = sdao.searchsupportlist(no,id,title);
		request.setAttribute("support_list", slist);
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSupportListMainView.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
