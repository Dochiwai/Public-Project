package com.join.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.dao.AddrDao;
import com.addr.dto.Head_Addr_Dto;


@WebServlet("/userjoin/UserJoinViewLogic.jsp")
public class UserJoinViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddrDao dao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> dto = dao.head_search();
		request.setAttribute("headlist", dto);
		RequestDispatcher rd = request.getRequestDispatcher("UserJoinView.jsp");
		rd.forward(request, response);
		
//		ArrayList<String> headlist = new ArrayList<String>();
//		ArrayList<String> headnumberlist = new ArrayList<String>();
		
//		for(int i = 0; i < dto.size(); i++) {
//			headlist.add(dto.get(i));
////			headnumberlist.add(dto.get(i).getHead_addr_number());
//		}
//	
//		request.setAttribute("headnumberlist", headnumberlist);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
