package com.ruanko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruanko.model.Tag;
import com.ruanko.utils.DBUtil;

public class TagDao {
	public List<Tag> allTags(){
		List<Tag> tags = new ArrayList<>();
		//创建数据库连接对象
		//预编译对象
		//结果集对象
		Connection conn=DBUtil.getConn();
		PreparedStatement ps=null ;
		ResultSet rs=null;
		
		
		try {
			String sql="select * from tag where del = 0";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Tag tag = new Tag();
				tag.setId(rs.getInt(1));
				tag.setName(rs.getString(2));
				tag.setDescription(rs.getString(3));
				tag.setDel(rs.getInt(4));
				
				tags.add(tag);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//关闭
			DBUtil.close(rs, ps, conn);
		}
		return tags;
	}
	
	public TagDao() {
		
	}

}
