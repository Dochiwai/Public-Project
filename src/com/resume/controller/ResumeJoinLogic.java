package com.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import com.resume.dto.Resume_User_Dto;

@WebServlet("/resume/ResumeJoinLogic.jsp")
public class ResumeJoinLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ResumeDao dao = ResumeDao.getInstance(); 	
		int result = -1;
		String id = (String) session.getAttribute("currentid");
		String main_title = "";
		String addr_head = "";
		String addr_middle = "";
		String j_head = "";
		String j_middle = "";
		String j_end = "";
		String title0 = ""; 
		String text0 = "";
		String title1 = "";
		String text1 = "";
		String title2 = "";
		String text2 = "";
		String title3 = "";
		String text3 = "";
		String fileName = "";
		String orgfileName = "";
		String uploadPath = request.getRealPath("upload");
		
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, 
					uploadPath, // 파일을 저장할 디렉토리 지정
					10 * 1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			fileName = multi.getFilesystemName("r_ficture"); // name=file의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			orgfileName = multi.getOriginalFileName("r_ficture"); // name=file의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
			main_title = multi.getParameter("r_main_title");
			addr_head = multi.getParameter("r_want_head");
			addr_middle =  multi.getParameter("r_want_middle");
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
		} catch (Exception e) {
			e.getStackTrace();
		} // 업로드 종료
		
//		System.out.println(id + ": id");
//		System.out.println(main_title + ": main_title");
//		System.out.println(fileName + ": fileName");
//		System.out.println(addr_head + ": addr_head");
//		System.out.println(addr_middle + ": addr_middle");
//		System.out.println(j_head + ": j_head");
//		System.out.println(j_middle + ": j_middle");
//		System.out.println(j_end + ": j_end");

		//
		if(null == title0) {
			//자소서 없는 dao실행
			result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end);
		}
		if(null != title0){
			if(null != title1){
				if(null != title2){	
					if (null != title3){
							result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end,title0,text0,title1,text1,title2,text2,title3,text3);
					}else {
						result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end,title0,text0,title1,text1,title2,text2);
					}
				}else {
					result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end,title0,text0,title1,text1);
				}
			}else {
				result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end,title0,text0);
			}
		}
		
		
//		if(result != -1) {
//			PrintWriter writer = response.getWriter(); writer.println("<script>alert('Good');</script>"); writer.close();
//		}else {
//			PrintWriter writer = response.getWriter(); writer.println("<script>alert('Fail');</script>"); writer.close();
//		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/resume/ResumeMainViewLogic.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
