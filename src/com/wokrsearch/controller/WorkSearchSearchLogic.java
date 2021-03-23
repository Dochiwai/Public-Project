package com.wokrsearch.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.dao.AddrDao;
import com.addr.dto.Detail_Addr_Dto;
import com.addr.dto.Head_Addr_Dto;
import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_End_Dto;
import com.resume.dto.Resume_Head_Dto;
import com.resume.dto.Resume_Middle_Dto;
import com.work.dao.WorkDao;
import com.work.dto.WorkDto;

@WebServlet("/worksearch/WorkSearchSearchLogic.jsp")
public class WorkSearchSearchLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		WorkDao dao = WorkDao.getInstance();
		String title = request.getParameter("title_name");
		String addr = request.getParameter("where_name");
		String age = request.getParameter("age_gogo");
		String gender = request.getParameter("sex_gogo");
		String position = request.getParameter("work_day");
		String money = request.getParameter("want_money");
		String job_head = request.getParameter("j_head");
		String job_middle = request.getParameter("j_middle_name");
		String job_end = request.getParameter("j_end_name");
		
		if(null != job_head) {
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
				if(job_middle.equals("3")) {
					if(job_end.equals("1")) {
						job_end = "5";
					}else {
						job_end = "6";
					}
				}else if(job_middle.equals("4")){
					if(job_end.equals("1")) {
						job_end = "7";
					}else {
						job_end = "8";
					}
				}
			}
		}
		
		ArrayList<WorkDto> nontitlelist = new ArrayList<WorkDto>();
		ArrayList<WorkDto> yestitlelist = new ArrayList<WorkDto>();
		
		ResumeDao addr_dao = ResumeDao.getInstance();
		ArrayList<Resume_Head_Dto> list = addr_dao.jog_head_list();
		request.setAttribute("job_head_list", list);
		
		AddrDao ddao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> ddto = ddao.head_search();
		request.setAttribute("addr_head_list", ddto);
		
		String[] agelist = {"10대","20대","30대","40대","50대","60대","지건딱대"};
		request.setAttribute("agelist", agelist);
		
		String[] genderlist = {"남자","여자"};
		request.setAttribute("gender", genderlist);
		
		String[] positionlist = {"신입","경력","무관"};
		request.setAttribute("position", positionlist);
		
		String[] moneylist = {"연봉선택","2400~2600","2600~3000"};
		request.setAttribute("money", moneylist);
		
		if(null == title) {
			//타이틀이 널일떄
			nontitlelist = dao.nontitlesearch(addr,age,gender,position,money,job_head,job_middle,job_end);
			request.setAttribute("resultlist", nontitlelist);
		}else {
			yestitlelist = dao.yestitlesearch(title);
			request.setAttribute("resultlist", yestitlelist);
		}		
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSearchResultView.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
