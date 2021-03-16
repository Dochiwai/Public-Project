package com.resume.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.resume.dao.ResumeDao;

/**
 * Servlet implementation class ResumeUpdateLogic
 */
@WebServlet("/resume/ResumeUpdateLogic.jsp")
public class ResumeUpdateLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int result = -1;
		ResumeDao dao = ResumeDao.getInstance(); 	
		String id = (String) session.getAttribute("currentid");
		String number = "";
		String main_title = null;
		String addr_head = null;
		String addr_middle = null;
		String j_head = null;
		String j_middle = null;
		String j_end = null;
		String title0 = ""; 
		String text0 = ""; 
		String title1 = ""; 
		String text1 = ""; 
		String title2 = ""; 
		String text2 = ""; 
		String title3 = ""; 
		String text3 = ""; 
		String fileName = null;
		String orgfileName = null;
		String uploadPath = request.getRealPath("upload");

		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",new DefaultFileRenamePolicy());
		
		fileName = multi.getFilesystemName("r_ficture"); // name=file의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
		orgfileName = multi.getOriginalFileName("r_ficture"); // name=file의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
		main_title = multi.getParameter("r_main_title");
		addr_head = multi.getParameter("r_want_head");
		addr_middle = multi.getParameter("r_want_middle");
		j_head =  multi.getParameter("j_head");
		j_middle =  multi.getParameter("j_middle_name");
		j_end =  multi.getParameter("j_end_name");
		title0 =  multi.getParameter("title0");
		text0 =  multi.getParameter("area0");
		title1 =  multi.getParameter("title1");
		text1 =  multi.getParameter("area1");
		title2 =  multi.getParameter("title2");
		text2 =  multi.getParameter("area2");
		title3 =  multi.getParameter("title3");
		text3 =  multi.getParameter("area3");
		number = multi.getParameter("resume_number");
		
		if(j_head.equals("1")) {
			if(j_middle.equals("1")) {
				if(j_end.equals("1")) {
					j_end = "1";
				}else {
					j_end = "2";
				}
			}else if (j_middle.equals("2")) {
				if(j_end.equals("1")) {
					j_end = "3";
				}else {
					j_end = "4";
				}
			}
		}else if(j_head.equals("2")){
			if(j_middle.equals("1")) {
				if(j_end.equals("1")) {
					j_end = "5";
				}else {
					j_end = "6";
				}
			}else{
				if(j_end.equals("1")) {
					j_end = "7";
				}else {
					j_end = "8";
				}
			}
		}
		
		result = dao.updateResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end,title0,text0,title1,text1,title2,text2,title3,text3,number);

		RequestDispatcher rd = request.getRequestDispatcher("/resume/ResumeMainViewLogic.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
