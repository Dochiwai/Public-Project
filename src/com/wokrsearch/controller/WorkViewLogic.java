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
import com.alram.dao.alramDao;
import com.resume.dao.ResumeDao;
import com.resume.dto.Resume_End_Dto;
import com.resume.dto.Resume_Head_Dto;
import com.resume.dto.Resume_Middle_Dto;
import com.support.dao.SupportDao;
import com.support.dto.SupportDto;
import com.work.dao.WorkDao;
import com.work.dto.WorkDto;

@WebServlet("/worksearch/WorkViewLogic.jsp")
public class WorkViewLogic extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String no = request.getParameter("no");
		request.setAttribute("get_no", no);
		String id = request.getParameter("id");
		request.setAttribute("get_id", id);
		String title = request.getParameter("title");
		request.setAttribute("get_title", title);
		String user_id = request.getParameter("userid");
		if(null != user_id) {
			alramDao adao = alramDao.getInstance();
			adao.checkchange(user_id,no);
		}
		
//		System.out.println(no);
//		System.out.println(id);
//		System.out.println(title);
		
		WorkDao userdao = WorkDao.getInstance();
		WorkDto userdto = userdao.worksearchview(no,id,title);
		request.setAttribute("userdto", userdto);
		
		ResumeDao dao = ResumeDao.getInstance();
		ArrayList<Resume_Head_Dto> list = dao.jog_head_list();
		request.setAttribute("job_head_list", list);
		
		ArrayList<Resume_Middle_Dto> job_mid_list = dao.middleseacrch(userdto.getWork_job_head());
		request.setAttribute("job_mid_list", job_mid_list);
		
		ArrayList<Resume_End_Dto> job_end_list = dao.endsearch(userdto.getWork_job_middle());
		request.setAttribute("job_end_list", job_end_list);
		
		AddrDao ddao = AddrDao.getInstance();
		ArrayList<Head_Addr_Dto> ddto = ddao.head_search();
		request.setAttribute("addr_head_list", ddto);
		
		String head_num = ddao.head_number_search(userdto.getWork_where_head());
		ArrayList<Detail_Addr_Dto> addr_detail_dto = ddao.detailSearch(head_num);
		request.setAttribute("addr_middle_list", addr_detail_dto);
		
		
		
		String[] age = {"10대","20대","30대","40대","50대","60대","지건딱대"};
		request.setAttribute("agelist", age);
		
		String[] gender = {"남자","여자"};
		request.setAttribute("gender", gender);
		
		String[] position = {"신입","경력","무관"};
		request.setAttribute("position", position);
		
		String[] money = {"연봉선택","2400~2600","2600~3000"};
		request.setAttribute("money", money);
		
		WorkDao wdao = WorkDao.getInstance();
		ArrayList<WorkDto> wdto = wdao.search_list();
		request.setAttribute("worklist", wdto);
		
		String image1 = "http://localhost:9090/korea/company/"+userdto.getWork_file1();
		String imageback_1 = userdto.getWork_file1();
		String image2 = "http://localhost:9090/korea/company/"+userdto.getWork_file2();
		String imageback_2 = userdto.getWork_file2();
		request.setAttribute("image1", image1);
		request.setAttribute("image2", image2);
		request.setAttribute("imageback_1", imageback_1);
		request.setAttribute("imageback_2", imageback_2);
		
		RequestDispatcher rd = request.getRequestDispatcher("WorkSearchDetailView.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
