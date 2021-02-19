package com.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDao {
	private static UserDao dao;
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
	
	private UserDao() {}
	public static UserDao getInstance() {
		if(dao==null) {
			dao = new UserDao();
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
	
	
	public int join(String id, String password, String name, int age, String gender, String addr, String phone,String email) {
		int result = -1;
		sql = "INSERT INTO USER_DB VALUES(?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,password);
			ps.setString(3, name);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6,addr);
			ps.setString(7, phone);
			ps.setString(8, email);
			result = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}	
		return result;
	}

	public int idoverlapcheck(String user_id) {
		int result = -1;
		sql = "SELECT * FROM USER_DB WHERE M_USERID = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	
}
