package com.wokrsearch.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkSupportLogic
 */
@WebServlet("/worksearch/WorkSupportLogic.jsp")
public class WorkSupportLogic extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter(); 
		
		

		String str="";
		str = "<script language='javascript'>";
		str += "alert('gd');";
		str += "self.close();";   // 창닫기
	    str += "</script>";
		out.print(str);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
