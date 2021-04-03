package com.resume.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addr.dao.AddrDao;
import com.addr.dto.Detail_Addr_Dto;
import com.addr.dto.Head_Addr_Dto;
import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_End_Dto;
import com.resume.dto.Resume_Head_Dto;
import com.resume.dto.Resume_Middle_Dto;
import com.resume.dto.Resume_User_Dto;
import com.support.dao.SupportDao;

@WebServlet("/resume/ResumeViewLogic.jsp")
public class ResumeViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String no = request.getParameter("trigger");
		
		System.out.println(no);
		
		request.setAttribute("resume_id", id);
		request.setAttribute("resume_title", title);
		request.setAttribute("resume_num", num);
		
		if(null != no) {
			SupportDao sdao = SupportDao.getInstance();
			int result = sdao.triggeronoff(no);
		}
		
		ResumeDao dao = ResumeDao.getInstance();
		Resume_User_Dto dto = dao.selectinfo(id,num,title);
		request.setAttribute("dto", dto);

		ResumeDao jobdao = ResumeDao.getInstance();
		ArrayList<Resume_Head_Dto> joblist = jobdao.jog_head_list();
		request.setAttribute("joblist", joblist);
		
		ArrayList<Resume_Middle_Dto> job_mid_list = jobdao.middleseacrch(dto.getR_wantjob_head());
		request.setAttribute("job_mid_list", job_mid_list);
		
		ArrayList<Resume_End_Dto> job_end_list = jobdao.endsearch(dto.getR_wantjob_middle());
		request.setAttribute("job_end_list", job_end_list);
		
		AddrDao addrdao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> addrdto = addrdao.head_search();
		request.setAttribute("addrlist", addrdto);
		 
		String head_num = addrdao.head_number_search(dto.getR_where_head());
		ArrayList<Detail_Addr_Dto> addr_detail_dto = addrdao.detailSearch(head_num);
		request.setAttribute("addr_detail_list", addr_detail_dto);
		
		String image = "http://localhost:9090/korea/upload/"+dto.getR_picture();
		request.setAttribute("image", image);
	
		
		if(null == dto.getR_self_head_1()) {
			if(null != dto.getR_self_head_2()) {
				dto.setR_self_head_1(dto.getR_self_head_2());
				dto.setR_self_text_1(dto.getR_self_text_2());
				dto.setR_self_text_2(null);
				dto.setR_self_head_2(null);
			}else if(null != dto.getR_self_head_3()) {
				dto.setR_self_head_1(dto.getR_self_head_3());
				dto.setR_self_text_1(dto.getR_self_text_3());
				dto.setR_self_text_3(null);
				dto.setR_self_head_3(null);
			}else if(null != dto.getR_self_head_4()) {
				dto.setR_self_head_1(dto.getR_self_head_4());
				dto.setR_self_text_1(dto.getR_self_text_4());
				dto.setR_self_text_4(null);
				dto.setR_self_head_4(null);
			}
		}
		if(null == dto.getR_self_head_2()) {
			if(null != dto.getR_self_head_3()) {
				dto.setR_self_head_2(dto.getR_self_head_3());
				dto.setR_self_text_2(dto.getR_self_text_3());
				dto.setR_self_text_3(null);
				dto.setR_self_head_3(null);
			}else if(null != dto.getR_self_head_4()) {
				dto.setR_self_head_2(dto.getR_self_head_4());
				dto.setR_self_text_2(dto.getR_self_text_4());
				dto.setR_self_text_4(null);
				dto.setR_self_head_4(null);
			}
		}
		if(null == dto.getR_self_head_3()) {
			if(null != dto.getR_self_head_4()) {
				dto.setR_self_head_3(dto.getR_self_head_4());
				dto.setR_self_text_3(dto.getR_self_text_4());
				dto.setR_self_text_4(null);
				dto.setR_self_head_4(null);
			}
		}
//		System.out.println("1번 : "+dto.getR_self_head_1());
//		System.out.println("2번 : "+dto.getR_self_head_2());
//		System.out.println("3번 : "+dto.getR_self_head_3());
//		System.out.println("4번 : "+dto.getR_self_head_4());
		

		RequestDispatcher rd = request.getRequestDispatcher("resumeView.jsp");
		rd.forward(request, response);
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
