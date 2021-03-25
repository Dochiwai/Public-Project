package com.alram.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_End_Dto;
import com.support.dao.SupportDao;
import com.support.dto.SupportDto;

/**
 * Servlet implementation class checkalramLogic
 */
@WebServlet("/checkalramLogic.jsp")
public class checkalramLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		SupportDao dao = SupportDao.getInstance();
		int count = dao.countalram(id);
		response.getWriter().write(getJSON(count));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public String getJSON(int count) {
		StringBuffer result = new StringBuffer("");
		if(count >= 1) {
			result.append(count + "개\n알람");
		}else {
			result.append("알람");
		}
		return result.toString();
	}
}
