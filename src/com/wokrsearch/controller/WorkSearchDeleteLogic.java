package com.wokrsearch.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.dao.WorkDao;

/**
 * Servlet implementation class WorkSearchDeleteLogic
 */
@WebServlet("/worksearch/WorkSearchDeleteLogic.jsp")
public class WorkSearchDeleteLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		
		WorkDao dao = WorkDao.getInstance();
		int result = dao.deletework(no,id,title);
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSearchMainViewLogic.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
