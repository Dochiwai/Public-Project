package com.profile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addr.dao.AddrDao;
import com.addr.dto.Detail_Addr_Dto;
import com.addr.dto.Head_Addr_Dto;

@WebServlet("/profile/ProfileEditLogic.jsp")
public class ProfileEditLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String password = request.getParameter("profile_password");
		String realpassword = (String)session.getAttribute("currentpassword");
		String id = (String)session.getAttribute("currentid");
		int result = -1;
		
		
		if(password.equals(realpassword)) {
			result = 1;
			AddrDao dao = AddrDao.getInstance();
			ArrayList<Head_Addr_Dto> dto = dao.head_search();
			System.out.println(dto.get(0).getHead_addr());
			request.setAttribute("headlist", dto);
			AddrDao addrdao = AddrDao.getInstance();
			String headnum = addrdao.middle_search(dto.get(0).getHead_addr());
			ArrayList<Detail_Addr_Dto> middleaddrlist = addrdao.detailSearch(headnum);
			request.setAttribute("middlelist", middleaddrlist);
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/profile/profileEditView.jsp");
		rd.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
