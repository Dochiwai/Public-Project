package com.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.dao.UserDao;


@WebServlet("/userjoin/JoinLogic.jsp")
public class UserJoinLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = UserDao.getInstance();
		int result = -1;
		String id = request.getParameter("join_user_id");
		String password = request.getParameter("join_user_password");
		String name = request.getParameter("join_user_name");
		int age = Integer.parseInt(request.getParameter("join_user_age"));
		String gender = request.getParameter("join_user_gender");
		String addr_head = request.getParameter("join_addr_head");
		String addr_middle = request.getParameter("join_addr_middle");
		String addr_end = request.getParameter("join_addr_end");
		String addr = (addr_head + addr_middle + addr_end);
		String phone = request.getParameter("join_user_phone");
		String email = request.getParameter("join_user_email");
		
		result = dao.join(id, password, name, age, gender, addr, phone, email);
		request.setAttribute("result", result);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("JoinresultView.jsp");
		rd.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
