package com.user.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.user.dto.UserDto;

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
	
	
	//회원가입
	
	public int join(String id, String password, String name, int age, String gender, String addr_head,String addr_middle,String addr_end, String phone,String email) {
		int result = -1;
		sql = "INSERT INTO USER_DB VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,password);
			ps.setString(3, name);
			ps.setInt(4, age);
			ps.setString(5, gender);
			ps.setString(6,addr_head);
			ps.setString(7,addr_middle);
			ps.setString(8,addr_end);
			ps.setString(9, phone);
			ps.setString(10, email);
			result = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}	
		return result;
	}

//	아이디체크
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
	
//	로그인
	public UserDto login(String id, String password) {
		UserDto dto = null;
		sql = "SELECT * FROM USER_DB WHERE M_USERID = ? AND M_USERPASSWORD = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new UserDto();
				dto.setUser_id(rs.getString("m_userid"));
				dto.setUser_password(rs.getString("m_userpassword"));
				dto.setUser_name(rs.getString("M_NAME"));
				dto.setUser_age(rs.getString("M_AGE"));
				dto.setUser_gender(rs.getString("M_GENDER"));
				dto.setUser_addr_head(rs.getString("M_ADDR_HEAD"));
				dto.setUser_addr_middle(rs.getString("M_ADDR_MIDDLE"));
				dto.setUser_addr_end(rs.getString("M_ADDR_END"));
				dto.setUser_phone(rs.getString("M_PHONE"));
				dto.setUser_email(rs.getString("M_EMAIL"));
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con,ps);
		}
		return dto;
	}
	
	
	public UserDto profileEdit(String id, String password) {
		UserDto dto = new UserDto();
		sql = "SELECT * FROM USER_DB WHERE M_USERID = ? AND M_USERPASSWORD = ?";
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new UserDto();
				dto.setUser_id(rs.getString("m_userid"));
				dto.setUser_password(rs.getString("m_userpassword"));
				dto.setUser_name(rs.getString("M_NAME"));
				dto.setUser_age(rs.getString("M_AGE"));
				dto.setUser_gender(rs.getString("M_GENDER"));
				dto.setUser_addr_head(rs.getString("M_ADDR_HEAD"));
				dto.setUser_addr_middle(rs.getString("M_ADDR_MIDDLE"));
				dto.setUser_addr_end(rs.getString("M_ADDR_END"));
				dto.setUser_phone(rs.getString("M_PHONE"));
				dto.setUser_email(rs.getString("M_EMAIL"));
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con,ps);
		}
		return dto;
	}
	
//	업데이트
	
	public int profile_edit(String password, String name, int age, String gender, String addr_head,String addr_middle,String addr_end, String phone,String email, String id) {
		int result = -1;
		sql = "UPDATE USER_DB SET m_userpassword = ?, m_name = ?, m_age = ?, m_gender = ?, m_addr_head = ?, m_addr_middle = ?, m_addr_end = ?, m_phone = ?, m_email = ? WHERE m_userid = ?";
		try {
//			System.out.println(password);
//			System.out.println(name);
//			System.out.println(gender);
//			System.out.println(age);
//			System.out.println(addr_head);
//			System.out.println(addr_middle);
//			System.out.println(addr_end);++
//			System.out.println(phone);
//			System.out.println(email);
//			System.out.println(id);
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5,addr_head);
			ps.setString(6,addr_middle);
			ps.setString(7,addr_end);
			ps.setString(8, phone);
			ps.setString(9, email);
			ps.setString(10, id);
			result = ps.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}	
		return result;
	}
	
}
