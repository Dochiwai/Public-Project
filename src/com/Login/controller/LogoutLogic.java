package com.Login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userlogin/LogoutLogic.jsp")
public class LogoutLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("currentid");
		session.removeAttribute("currentpassword");
		session.removeAttribute("currentname");
		session.removeAttribute("currentage");
		session.removeAttribute("currentgender");
		session.removeAttribute("currentaddr");
		session.removeAttribute("currentphone");
		session.removeAttribute("currentemail");
		session.invalidate();
		request.getRequestDispatcher("logoutResultView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
