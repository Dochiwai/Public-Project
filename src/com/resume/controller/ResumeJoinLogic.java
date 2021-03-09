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
import com.resume.dto.Resume_User_Dto;

@WebServlet("/resume/ResumeJoinLogic.jsp")
public class ResumeJoinLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ResumeDao dao = ResumeDao.getInstance(); 	
		int result = -1;
		String id = (String) session.getAttribute("currentid");
		String main_title = request.getParameter("r_main_title");
		String addr_head = request.getParameter("r_want_head");
		String addr_middle = request.getParameter("r_want_middle");
		String j_head = request.getParameter("j_head");
		String j_middle = request.getParameter("j_middle_name");
		String j_end = request.getParameter("j_end_name");
		String title0 = request.getParameter("title0");
		String text0 = request.getParameter("aear0");
		String title1 = request.getParameter("title1");
		String text1 = request.getParameter("aear1");
		String title2 = request.getParameter("title2");
		String text2 = request.getParameter("aear2");
		String title3 = request.getParameter("title3");
		String text3 = request.getParameter("aear3");
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
			
		} catch (Exception e) {
			e.getStackTrace();
		} // 업로드 종료
		
		System.out.println(id + ": id");
		System.out.println(main_title + ": main_title");
		System.out.println(fileName + ": fileName");
		System.out.println(addr_head + ": addr_head");
		System.out.println(addr_middle + ": addr_middle");
		System.out.println(j_head + ": j_head");
		System.out.println(j_middle + ": j_middle");
		System.out.println(j_end + ": j_end");

		//
		if(null == title0) {
			//자소서 없는 dao실행
			result = dao.insertResume(id,main_title,fileName,addr_head,addr_middle,j_head,j_middle,j_end);
		}
		if(null != title0){
			
			if(null != title1){
				
				if(null != title2){
					
					if (null != title3){
							//3번 자소서
					}else {
						//2번 자소서
					}
				}else {
					//1번자소서
				}
			}else {
				//0번 자소서 dao실행
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
