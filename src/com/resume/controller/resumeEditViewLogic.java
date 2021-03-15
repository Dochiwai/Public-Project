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

@WebServlet("/resume/resumeEditViewLogic.jsp")
public class resumeEditViewLogic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("currentid");
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		
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
		
		String sex = "http://localhost:9090/gygus/upload/"+dto.getR_picture();
		request.setAttribute("sex", sex);
		

		RequestDispatcher rd = request.getRequestDispatcher("resumeEditView.jsp");
		rd.forward(request, response);
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
