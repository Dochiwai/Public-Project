package com.resume.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.resume.dto.Resume_End_Dto;
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
	public ArrayList<Resume_End_Dto> endsearch(String middle_job) {
		Resume_End_Dto dto = null;
		ArrayList<Resume_End_Dto> list = new ArrayList<Resume_End_Dto>();
		sql = "SELECT * FROM JOB_END_DB WHERE J_KEYID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, middle_job);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new Resume_End_Dto();
				dto.setJ_id(rs.getString("j_keyid"));
				dto.setJ_end_job(rs.getString("j_end"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty() ? null : list;
	}
	public int insertResume(String id, String main_title, String fileName, String addr_head, String addr_middle,
			String j_head, String j_middle, String j_end) {
		int result = -1;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		sql = "INSERT INTO RESUME_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, main_title);
			ps.setString(3, fileName);
			ps.setInt(4,year);
			ps.setInt(5,month);
			ps.setInt(6,day);
			ps.setString(7, j_head);
			ps.setString(8, j_middle);
			ps.setString(9, j_end);
			ps.setString(10, addr_head);
			ps.setString(11, addr_middle);
			ps.setString(12, "");
			ps.setString(13, "");
			ps.setString(14, "");
			ps.setString(15, "");
			ps.setString(16, "");
			ps.setString(17, "");
			ps.setString(18, "");
			ps.setString(19, "");
			
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	public int insertResume(String id, String main_title, String fileName, String addr_head, String addr_middle,
			String j_head, String j_middle, String j_end,String title0,String text0) {
		int result = -1;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		sql = "INSERT INTO RESUME_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, main_title);
			ps.setString(3, fileName);
			ps.setInt(4,year);
			ps.setInt(5,month);
			ps.setInt(6,day);
			ps.setString(7, j_head);
			ps.setString(8, j_middle);
			ps.setString(9, j_end);
			ps.setString(10, addr_head);
			ps.setString(11, addr_middle);
			ps.setString(12, title0);
			ps.setString(13, text0);
			ps.setString(14, "");
			ps.setString(15, "");
			ps.setString(16, "");
			ps.setString(17, "");
			ps.setString(18, "");
			ps.setString(19, "");
			
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	public int insertResume(String id, String main_title, String fileName, String addr_head, String addr_middle,
			String j_head, String j_middle, String j_end,String title0,String text0,String title1,String text1) {
		int result = -1;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		sql = "INSERT INTO RESUME_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, main_title);
			ps.setString(3, fileName);
			ps.setInt(4,year);
			ps.setInt(5,month);
			ps.setInt(6,day);
			ps.setString(7, j_head);
			ps.setString(8, j_middle);
			ps.setString(9, j_end);
			ps.setString(10, addr_head);
			ps.setString(11, addr_middle);
			ps.setString(12, title0);
			ps.setString(13, text0);
			ps.setString(14, title1);
			ps.setString(15, text1);
			ps.setString(16, "");
			ps.setString(17, "");
			ps.setString(18, "");
			ps.setString(19, "");
			
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	public int insertResume(String id, String main_title, String fileName, String addr_head, String addr_middle,
			String j_head, String j_middle, String j_end,String title0,String text0,String title1,String text1,String title2,String text2) {
		int result = -1;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		sql = "INSERT INTO RESUME_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, main_title);
			ps.setString(3, fileName);
			ps.setInt(4,year);
			ps.setInt(5,month);
			ps.setInt(6,day);
			ps.setString(7, j_head);
			ps.setString(8, j_middle);
			ps.setString(9, j_end);
			ps.setString(10, addr_head);
			ps.setString(11, addr_middle);
			ps.setString(12, title0);
			ps.setString(13, text0);
			ps.setString(14, title1);
			ps.setString(15, text1);
			ps.setString(16, title2);
			ps.setString(17, text2);
			ps.setString(18, "");
			ps.setString(19, "");
			
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	public int insertResume(String id, String main_title, String fileName, String addr_head, String addr_middle,
			String j_head, String j_middle, String j_end,String title0,String text0,String title1,String text1,String title2,String text2,String title3,String text3) {
		int result = -1;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		sql = "INSERT INTO RESUME_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, main_title);
			ps.setString(3, fileName);
			ps.setInt(4,year);
			ps.setInt(5,month);
			ps.setInt(6,day);
			ps.setString(7, j_head);
			ps.setString(8, j_middle);
			ps.setString(9, j_end);
			ps.setString(10, addr_head);
			ps.setString(11, addr_middle);
			ps.setString(12, title0);
			ps.setString(13, text0);
			ps.setString(14, title1);
			ps.setString(15, text1);
			ps.setString(16, title2);
			ps.setString(17, text2);
			ps.setString(18, title3);
			ps.setString(19, text3);
			
			result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
}
