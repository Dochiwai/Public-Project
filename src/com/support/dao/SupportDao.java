package com.support.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.support.dto.SupportDto;

public class SupportDao {
	private static SupportDao dao;
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
	
	private SupportDao() {}
	public static SupportDao getInstance() {
		if(dao==null) {
			dao = new SupportDao();
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
	public int resumeSupport(String work_id, String work_no, String work_title, String user_id, String user_resume_num,
			String user_resume_title) {
		int result = -1;
		sql = "INSERT INTO SUPPORT_DB VALUES(?,?,?,?,?,?,?,S_NUM_SQC.nextval)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, work_id);
			ps.setString(2, work_no);
			ps.setString(3, work_title);
			ps.setString(4, user_id);
			ps.setString(5, user_resume_num);
			ps.setString(6, user_resume_title);
			ps.setString(7, "1");
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}		
		return result;
	}
	public int countalram(String id) {
		int count = 0;
		sql = "SELECT COUNT(*) FROM SUPPORT_DB WHERE WORK_ID = ? AND HIT_TRIGGER = 1";
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
	public ArrayList<SupportDto> searchsupport(String id) {
		ArrayList<SupportDto> list = new ArrayList<SupportDto>();
		SupportDto dto = null;
		sql = "SELECT * FROM SUPPORT_DB WHERE WORK_ID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {	
				dto = new SupportDto();
				dto.setNo(rs.getString("no"));
				dto.setWork_id(rs.getString("work_id"));
				dto.setWork_no(rs.getString("work_no"));
				dto.setWork_title(rs.getString("work_title"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_resume(rs.getString("user_resume"));
				dto.setUser_resume_title(rs.getString("user_resume_title"));
				dto.setHit_trigger(rs.getString("HIT_TRIGGER"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps ,rs);
		}
		return list.isEmpty() ? null : list;
	}
	public ArrayList<SupportDto> searchsupportlist(String no, String id, String title) {
		ArrayList<SupportDto> list = new ArrayList<SupportDto>();
		SupportDto dto = null;
		sql = "SELECT * FROM SUPPORT_DB WHERE WORK_ID = ? AND WORK_NO = ? AND WORK_TITLE = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, no);
			ps.setString(3, title);
			rs = ps.executeQuery();
			while(rs.next()) {	
				dto = new SupportDto();
				dto.setNo(rs.getString("no"));
				dto.setWork_id(rs.getString("work_id"));
				dto.setWork_no(rs.getString("work_no"));
				dto.setWork_title(rs.getString("work_title"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_resume(rs.getString("user_resume"));
				dto.setUser_resume_title(rs.getString("user_resume_title"));
				dto.setHit_trigger(rs.getString("HIT_TRIGGER"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps ,rs);
		}	
		return list.isEmpty() ? null : list;
	}
}
