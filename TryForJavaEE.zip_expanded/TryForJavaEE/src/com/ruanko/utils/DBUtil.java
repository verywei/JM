package com.ruanko.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/tryforjavaee";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() {

		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rs=null;
			ps=null;
			conn=null;			
		}

	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn=DBUtil.getConn();
		PreparedStatement ps= conn.prepareStatement("insert into tag(name,description) values(?,?)");			
		ps.setString(1, "java");
		ps.setString(2, "javaÑ§Ï°½»Á÷");
		ps.execute();
		DBUtil.close(null,ps,conn);		
	}
}
