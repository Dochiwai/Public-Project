package com.join.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addr.dao.AddrDao;
import com.addr.dto.Detail_Addr_Dto;
@WebServlet("/userjoin/AddrMiddleSearch.do")
public class AddrMiddleSearch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String city_name = request.getParameter("city");
		response.getWriter().write(getJSON(city_name));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public String getJSON(String city_name) {
		if(city_name == null) city_name = "";
		StringBuffer result = new StringBuffer("");
		AddrDao addrdao = AddrDao.getInstance();
		String headnum = addrdao.middle_search(city_name);
		ArrayList<Detail_Addr_Dto> addrlist = addrdao.detailSearch(headnum);
		
		for(int i = 0; i <addrlist.size(); i++){
			result.append("<option value ='" + addrlist.get(i).getDetail_addr() + "'>" + addrlist.get(i).getDetail_addr() + "</option>");
		}
		return result.toString();
	}
}
