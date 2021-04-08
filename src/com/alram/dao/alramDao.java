package com.alram.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.alram.dto.alramDto;

public class alramDao {
	private static alramDao dao;
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
	
	private alramDao() {}
	public static alramDao getInstance() {
		if(dao==null) {
			dao = new alramDao();
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
	public void checkinsert(String work_no, String work_title, String searchid,String id) {
		sql = "INSERT INTO ALRAM_DB(company_no,company_title,userid,company_id) VALUES(?,?,?,?)";
		int result = -1;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, work_no);
			ps.setString(2, work_title);
			ps.setString(3, searchid);
			ps.setString(4, id);
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
	}
	public ArrayList<alramDto> searchalram(String id) {
		ArrayList<alramDto> list = new ArrayList<alramDto>();
		alramDto dto = null;
		sql = "SELECT * FROM ALRAM_DB WHERE USERID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new alramDto();
				dto.setCompany_no(rs.getString("COMPANY_NO"));
				dto.setCompany_title(rs.getString("COMPANY_TITLE"));
				dto.setUser_id(rs.getString("USERID"));
				dto.setId(rs.getString("COMPANY_ID"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	
	public int countalram(String id) {
			int count = 0;
			sql = "SELECT COUNT(*) FROM ALRAM_DB WHERE USERID = ? AND SEECHECK = 'no'";
			try {
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {	
					count = rs.getInt(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(con, ps);
			}
			return count;
		}
	public void checkchange(String user_id ,String no) {
		sql = "UPDATE ALRAM_DB SET SEECHECK = 'YES' WHERE COMPANY_NO = ? AND USERID = ?";
		int result = -1;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.setString(2, user_id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
	}
}