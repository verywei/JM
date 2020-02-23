package com.ruanko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.utils.DBUtil;

public class AdminDao {

	public Admin login(String username,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		Admin admin=null;
		// 获取连接
		try {
			conn = DBUtil.getConn();
			String sql = "select * from admin where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();//获取连接，执行语句
			
			if(rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setUsername(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setNickname(rs.getString(4));
				admin.setDel(rs.getInt(5));	
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ps,conn);
		}
		return admin;	
	}
}
