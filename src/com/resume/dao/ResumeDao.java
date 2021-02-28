package com.resume.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.resume.dto.Resume_Head_Dto;
import com.resume.dto.Resume_Middle_Dto;
import com.resume.dto.Resume_User_Dto;
import com.user.dao.UserDao;

public class ResumeDao {
	private static ResumeDao dao;
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
	
	private ResumeDao() {}
	public static ResumeDao getInstance() {
		if(dao==null) {
			dao = new ResumeDao();
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
	public ArrayList<Resume_User_Dto> getuserresume(String id) {
		Resume_User_Dto dto = null;
		ArrayList<Resume_User_Dto> list = new ArrayList<Resume_User_Dto>();
		sql = "SELECT * FROM RESUME_DB WHERE R_ID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Resume_User_Dto();
				dto.setR_title(rs.getString("r_title"));
				list.add(dto);
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Resume_Head_Dto> jog_head_list() {
		Resume_Head_Dto dto = null;
		ArrayList<Resume_Head_Dto> list = new ArrayList<Resume_Head_Dto>();
		sql = "SELECT * FROM JOB_HEAD_DB";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Resume_Head_Dto();
				dto.setJ_id(rs.getString("j_id"));
				dto.setJ_head_job(rs.getString("j_head"));
				list.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty() ? null : list;
	}
	public ArrayList<Resume_Middle_Dto> middleseacrch(String head_job) {
		Resume_Middle_Dto dto = null;
		ArrayList<Resume_Middle_Dto> list = new ArrayList<Resume_Middle_Dto>();
		sql = "SELECT * FROM JOB_MIDDLE_DB WHERE J_KEYID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, head_job);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Resume_Middle_Dto();
				dto.setJ_id(rs.getString("j_id"));
				dto.setJ_middle_job(rs.getString("j_middle"));
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
