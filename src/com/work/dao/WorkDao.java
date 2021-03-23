package com.work.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.resume.dto.Resume_End_Dto;
import com.work.dao.WorkDao;
import com.work.dto.WorkDto;

public class WorkDao {
	private static WorkDao dao;
	private Connection con;
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
	
	private WorkDao() {}
	public static WorkDao getInstance() {
		if(dao==null) {
			dao = new WorkDao();
		}
		return dao;
	}
	
	private static void close(Connection con2 , PreparedStatement ps,ResultSet rs) {
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
	private static void close(Connection con2, PreparedStatement ps) {
		close(con2,ps,null);
	}
	
	public int workjoin(String where_head, String where_middle, String age, String gender, String position,
			String money, String job_head, String job_middle, String job_end, String title, String filename1,
			String text, String filename2,String id) {
		
		int result = -1;
		sql = "INSERT INTO COMPANY_DB VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,W_NUM_SQC.nextval,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, where_head);
			ps.setString(2, where_middle);
			ps.setString(3, age);
			ps.setString(4, gender);
			ps.setString(5, position);
			ps.setString(6, money);
			ps.setString(7, job_head);
			ps.setString(8, job_middle);
			ps.setString(9, job_end);
			ps.setString(10, title);
			ps.setString(11, filename1);
			ps.setString(12, text);
			ps.setString(13, filename2);
			ps.setString(14, id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	public ArrayList<WorkDto> search_list() {
		WorkDto dto = null;
		ArrayList<WorkDto> list = new ArrayList<WorkDto>();
		
		sql = "SELECT * FROM COMPANY_DB";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new WorkDto();
				dto.setWork_where_head(rs.getString("WORK_WHERE_HEAD"));
				dto.setWork_where_middle(rs.getString("WORK_WHERE_MIDDLE"));
				dto.setWork_age(rs.getString("WORK_AGE"));
				dto.setWork_gender(rs.getString("WORK_GENDER"));
				dto.setWork_position(rs.getString("WORK_POSITION"));
				dto.setWork_money(rs.getString("WORK_MONEY"));
				dto.setWork_job_head(rs.getString("WORK_JOB_HEAD"));
				dto.setWork_job_middle(rs.getString("WORK_JOB_MIDDLE"));
				dto.setWork_job_end(rs.getString("WORK_JOB_END"));
				dto.setWork_title(rs.getString("WORK_TITLE"));
				dto.setWork_text(rs.getString("WORK_TEXT"));
				dto.setWork_file1(rs.getString("WORK_FILE1"));
				dto.setWork_file2(rs.getString("WORK_FILE2"));
				dto.setNo(rs.getString("NO"));
				dto.setId(rs.getString("ID"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty() ? null : list;
	}
	
	public WorkDto worksearchview(String no, String id, String title) {
		WorkDto dto = null;
		sql = "SELECT * FROM COMPANY_DB WHERE NO = ? AND ID = ? AND WORK_TITLE = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.setString(2, id);
			ps.setString(3, title);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new WorkDto();
				dto.setId(rs.getString("id"));
				dto.setNo(rs.getString("no"));
				dto.setWork_where_head(rs.getString("work_where_head"));
				dto.setWork_where_middle(rs.getString("work_where_middle"));
				dto.setWork_age(rs.getString("work_age"));
				dto.setWork_gender(rs.getString("work_gender"));
				dto.setWork_position(rs.getString("work_position"));
				dto.setWork_money(rs.getString("work_money"));
				dto.setWork_job_head(rs.getString("work_job_head"));
				dto.setWork_job_middle(rs.getString("work_job_middle"));
				dto.setWork_job_end(rs.getString("work_job_end"));
				dto.setWork_title(rs.getString("work_title"));
				dto.setWork_text(rs.getString("work_text"));
				dto.setWork_file1(rs.getString("work_file1"));
				dto.setWork_file2(rs.getString("work_file2"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return dto;
	}
	public int editworksearch(String where_head, String where_middle, String age, String gender, String position,
			String money, String job_head, String job_middle, String job_end, String title, String filename1,
			String text, String filename2, String no, String backtitle) {
		int result = -1;
		sql = "UPDATE COMPANY_DB SET WORK_WHERE_HEAD = ? , WORK_WHERE_MIDDLE = ? , WORK_AGE = ?, WORK_GENDER = ?, WORK_POSITION = ?,WORK_MONEY = ? , WORK_JOB_HEAD = ? ,WORK_JOB_MIDDLE = ? , WORK_JOB_END = ? , WORK_TITLE = ?,WORK_FILE1 = ? , WORK_TEXT = ? , WORK_FILE2 = ? WHERE NO = ? AND WORK_TITLE = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, where_head);
			ps.setString(2, where_middle);
			ps.setString(3, age);
			ps.setString(4, gender);
			ps.setString(5, position);
			ps.setString(6, money);
			ps.setString(7, job_head);
			ps.setString(8, job_middle);
			ps.setString(9, job_end);
			ps.setString(10, title);
			ps.setString(11, filename1);
			ps.setString(12, text);
			ps.setString(13, filename2);
			ps.setString(14, no);
			ps.setString(15, backtitle);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	public int deletework(String no, String id, String title) {
		int result = -1;
		sql = "DELETE FROM COMPANY_DB WHERE NO = ? AND ID = ? AND WORK_TITLE = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, no);
			ps.setString(2, id);
			ps.setString(3, title);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}

	
}
	
