package com.profile.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.dao.UserDao;


@WebServlet("/profile/UserDelLogic.jsp")
public class UserDelLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("currentid");
		
		UserDao dao = UserDao.getInstance();
		int result = dao.deleteUser(id);
		request.setAttribute("result", result);
		
		session.removeAttribute("currentid");
		session.removeAttribute("currentpassword");
		session.removeAttribute("currentname");
		session.removeAttribute("currentage");
		session.removeAttribute("currentgender");
		session.removeAttribute("currentaddr");
		session.removeAttribute("currentphone");
		session.removeAttribute("currentemail");
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("profileDelOk.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
