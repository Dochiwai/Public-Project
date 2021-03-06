package com.wokrsearch.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
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
		String file2 = (String)files.nextElement();
		
		filename1 = multi.getFilesystemName(file);
		filename2 = multi.getFilesystemName(file2);
		
		if(null == filename1) {
			filename1 = multi.getParameter("imageback_1");
			System.out.println(filename1);
		}
		if(null == filename2) {
			filename2 = multi.getParameter("imageback_2");
		}
		
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
		
		
		WorkDao dao = WorkDao.getInstance();
		result = dao.editworksearch(where_head,where_middle,age,gender,position,money,job_head,job_middle,job_end
				,title,filename1,text,filename2,no,backtitle);
		RequestDispatcher rd = request.getRequestDispatcher("WorkSearchMainViewLogic.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
