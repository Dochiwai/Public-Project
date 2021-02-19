package com.join.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.dao.AddrDao;
import com.addr.dto.Detail_Addr_Dto;
import com.user.dao.UserDao;


@WebServlet("/userjoin/IdoverlapcheckLogic.do")
public class IdoverlapcheckLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String user_id = request.getParameter("userid");
		response.getWriter().write(getJSON(user_id));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);	
		
	}
	
	private String getJSON(String user_id) {
		int daoresult = -1;
		StringBuffer result = new StringBuffer("");
		if(user_id.equals("")) {
			result.append("아이디를 입력해주세요");
		}else {
			UserDao dao = UserDao.getInstance();
			daoresult =	 dao.idoverlapcheck(user_id);
			if(daoresult == 0) {
				result.append("사용 가능한 아이디입니다.");
			}
			if(daoresult == 1) {
				result.append("이미 사용중인 아이디입니다.");
			}
		}
		
		return result.toString();
	}
}
