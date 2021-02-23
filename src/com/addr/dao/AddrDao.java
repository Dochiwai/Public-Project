package com.addr.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.addr.dto.Detail_Addr_Dto;
import com.addr.dto.Head_Addr_Dto;

public class AddrDao {
	private static AddrDao dao;
	private java.sql.Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private static DataSource ds;
	
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	private AddrDao() {}
	public static AddrDao getInstance() {
		if(dao==null) {
			dao = new AddrDao();
		}
		return dao;
	}
	
	private static void close(java.sql.Connection con2 , PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}if(con2 != null) {
				con2.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static void close(java.sql.Connection con2, PreparedStatement ps) {
		close(con2,ps,null);
	}
	
	public ArrayList<Head_Addr_Dto> head_search(){
		Head_Addr_Dto dto = null;
		ArrayList<Head_Addr_Dto> list = new ArrayList<>();
		sql = "SELECT * FROM ADDR_DB";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Head_Addr_Dto();
				dto.setHead_no(rs.getInt("no"));
				dto.setHead_addr(rs.getString("addr"));
				dto.setHead_addr_number(rs.getString("addr_number"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	public String middle_search(String headname){
		sql = "SELECT * FROM ADDR_DB WHERE ADDR = ?";
		String number = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, headname);
			rs = ps.executeQuery();
			while(rs.next()) {
				number = rs.getString("addr_number");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return number;
	}
	
	public ArrayList<Detail_Addr_Dto> detailSearch(String middle_num) {
		Detail_Addr_Dto dto = null;
		ArrayList<Detail_Addr_Dto> list = new ArrayList<>();
		sql = "SELECT * FROM ADDR_DETAIL WHERE ADDR_NUMBER = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, middle_num);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Detail_Addr_Dto();
				dto.setDetail_no(rs.getInt("no"));
				dto.setDetail_addr(rs.getString("addr_details"));
				dto.setDetail_addr_number(rs.getString("addr_number"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty() ? null : list;
	}
}
