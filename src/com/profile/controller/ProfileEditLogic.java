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
import com.user.dto.UserDto;

@WebServlet("/profile/ProfileEditLogic.jsp")
public class ProfileEditLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String password = request.getParameter("profile_password");
		String realpassword = (String)session.getAttribute("currentpassword");
		int result = -1;
		
		if(password.equals(realpassword)) {
			result = 1;
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/profile/profileEditView.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
