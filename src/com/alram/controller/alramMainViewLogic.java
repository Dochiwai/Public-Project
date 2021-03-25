package com.alram.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.support.dao.SupportDao;
import com.support.dto.SupportDto;

@WebServlet("/alram/alramMainViewLogic.jsp")
public class alramMainViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		SupportDao dao = SupportDao.getInstance();
		ArrayList<SupportDto> list = dao.searchsupport(id);
		request.setAttribute("support_list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("alramMainView.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
