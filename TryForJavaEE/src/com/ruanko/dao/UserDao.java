package com.ruanko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.model.User;
import com.ruanko.utils.DBUtil;

public class UserDao {

	public boolean check(String username) {
//		�������ݿ����Ӷ���Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		// ��ȡ����
		try {
			conn = DBUtil.getConn();
			String sql = "select*from user where username=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs=ps.executeQuery();//��ȡ���ӣ�ִ�����
			
			if(rs.next()) {
				return false;
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ps,conn);
		}
		return true;
	}
	
	public boolean register(User user){
//		�������ݿ����Ӷ���Ԥ�������ͽ��������
		Connection conn = null;
		PreparedStatement ps = null;
		int rs=0;
		// ��ȡ����
		try {
			conn = DBUtil.getConn();
			String sql = "insert into user(username,password,nickname,imgUrl,del) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getNickname());
			ps.setString(4, user.getImgUrl());
			ps.setInt(5, user.getDel());
			rs=ps.executeUpdate();//��ȡ���ӣ�ִ�����
			if(rs==1) {
				return true;		
			}					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ps,conn);
		}
		return false;	
	}
	
	public User login(String username,String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		User user=null;
		// ��ȡ����
		try {
			conn = DBUtil.getConn();
			String sql = "select * from user where username=? and password=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();//��ȡ���ӣ�ִ�����
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setNickname(rs.getString(4));
				user.setImgUrl(rs.getString(5));
				user.setDel(rs.getInt(6));	
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ps,conn);
		}
		return user;	
	}
}
