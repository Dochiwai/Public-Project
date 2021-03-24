package com.wokrsearch.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/worksearch/WorkSupportLogic.jsp")
public class WorkSupportLogic extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		response.setContentType("text/html; charset=UTF-8"); 
		String work_id = request.getParameter("work_id");
		String work_no = request.getParameter("work_no");
		String work_title = request.getParameter("work_title");
		String user_id = request.getParameter("user_id");
		String user_resume_num = request.getParameter("user_resume_num");
		String user_resume_title = request.getParameter("user_resume_title");
		
//		System.out.println("워크아이디"+work_id);
//		System.out.println("워크넘버"+work_no);
//		System.out.println("워크타이틀"+work_title);
//		System.out.println("유저아이디"+user_id);
//		System.out.println("우저넘버"+user_resume_num);
//		System.out.println("유저타이틀:"+user_resume_title);

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
