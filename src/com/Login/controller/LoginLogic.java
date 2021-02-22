package com.Login.controller;

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


@WebServlet("/userlogin/LoginLogic.jsp")
public class LoginLogic extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("login_id");
		String password = request.getParameter("login_password");
		UserDao dao = UserDao.getInstance();
		UserDto dto = dao.login(id,password);
		
		request.setAttribute("dto", dto);
		
		if(dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("currentid", dto.getUser_id());
			session.setAttribute("currentpassword", dto.getUser_password());
			session.setAttribute("currentname", dto.getUser_name());
			session.setAttribute("currentage", dto.getUser_age());
			session.setAttribute("currentgender", dto.getUser_gender());
			session.setAttribute("currentaddr", dto.getUser_addr());
			session.setAttribute("currentphone", dto.getUser_phone());
			session.setAttribute("currentemail", dto.getUser_email());		
			System.out.println("ㅎㅇ");
		}				
		
		RequestDispatcher rd = request.getRequestDispatcher("/userlogin/LoginResultView.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
