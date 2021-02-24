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

@WebServlet("/profile/ProfileEditDoLogic.jsp")
public class ProfileEditDoLogic extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session = request.getSession();
	   request.setCharacterEncoding("UTF-8");
	   String id = (String) session.getAttribute("currentid");
	   String password = request.getParameter("re_edit_password");
	   String password_onemore = request.getParameter("re_edit_password_onemore");   
	   String name = request.getParameter("re_edit_name"); 
	   int age = Integer.parseInt(request.getParameter("re_edit_age"));  
	   String gender = request.getParameter("re_edit_gender");
	   String addr_head = request.getParameter("re_edit_addr_head");
	   String addr_middle = request.getParameter("re_edit_addr_middle");
	   String addr_end = request.getParameter("re_edit_addr_end");
	   String phone = request.getParameter("re_edit_phone");
	   String email = request.getParameter("re_edit_email");
	   
	   if(password.equals("") || password.equals("")) {
		   password = (String) session.getAttribute("currentpassword");
	   }
	 
		System.out.println("________DAO_______");
	   
	   UserDao dao = UserDao.getInstance();
	   int result = dao.profile_edit(password,name,age,gender,addr_head,addr_middle,addr_end,phone,email,id);
	   request.setAttribute("result", result);
	   
	   RequestDispatcher rd = request.getRequestDispatcher("/profile/profileResultView.jsp");
	   rd.forward(request, response);
	   
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
