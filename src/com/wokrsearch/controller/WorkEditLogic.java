package com.wokrsearch.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.work.dao.WorkDao;

/**
 * Servlet implementation class WorkEditLogic
 */
@WebServlet("/worksearch/WorkEditLogic.jsp")
public class WorkEditLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int result = -1;
		String id = (String) session.getAttribute("currentid");
		String backtitle = "";
		String no = "";
		String title = "";
		String text = "";
		String gender = "";
		String age = "";
		String position = "";
		String money = "";
		String where_head = "";
		String where_middle = "";
		String job_head = "";
		String job_middle = "";
		String job_end = "";
		String filename1 = null;
		String filename2 = null;
		String orgfileName1 = null;
		String orgfileName2 = null;
		String uploadPath = request.getRealPath("company");

		MultipartRequest multi = new MultipartRequest(request, uploadPath, 10 * 1024 * 1024, "utf-8",new DefaultFileRenamePolicy());

		Enumeration files = multi.getFileNames();

		String file = (String)files.nextElement();
		filename1 = multi.getFilesystemName(file);
		String file2 = (String)files.nextElement();
		filename2 = multi.getFilesystemName(file2);
		
		no = multi.getParameter("get_no");
		backtitle = multi.getParameter("get_title");
		title = multi.getParameter("title");
		text = multi.getParameter("divval");        
		gender = multi.getParameter("sex_gogo");      
		age = multi.getParameter("age_gogo");           
		position = multi.getParameter("work_day");    
		money = multi.getParameter("want_money");         
		where_head = multi.getParameter("r_want_head");  
		where_middle = multi.getParameter("r_want_middle");  
		job_head = multi.getParameter("j_head");     
		job_middle = multi.getParameter("j_middle_name");   
		job_end = multi.getParameter("j_end_name");    
		
		if(job_head.equals("1")) {
			if(job_middle.equals("1")) {
				if(job_end.equals("1")) {
					job_end = "1";
				}else {
					job_end = "2";
				}
			}else if (job_middle.equals("2")) {
				if(job_end.equals("1")) {
					job_end = "3";
				}else {
					job_end = "4";
				}
			}
		}else if(job_head.equals("2")){
			if(job_middle.equals("1")) {
				if(job_end.equals("1")) {
					job_end = "5";
				}else {
					job_end = "6";
				}
			}else if(job_middle.equals("2")){
				if(job_end.equals("1")) {
					job_end = "7";
				}else {
					job_end = "8";
				}
			}
		}
		
		WorkDao dao = WorkDao.getInstance();
		result = dao.editworksearch(where_head,where_middle,age,gender,position,money,job_head,job_middle,job_end
				,title,filename1,text,filename2,no,backtitle);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
