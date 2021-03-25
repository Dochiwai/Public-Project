package com.support.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
		sql = "INSERT INTO SUPPORT_DB VALUES(?,?,?,?,?,?,?)";
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
}
