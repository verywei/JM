package com.ruanko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ruanko.model.Topic;
import com.ruanko.model.TopicVO;
import com.ruanko.utils.DBUtil;

public class TopicDao {

	public boolean add(Topic topic) {
		
//		声明数据库连接对象，预编译对象
		Connection conn=DBUtil.getConn();
		PreparedStatement ps = null;
		try {
		
			//声明操作语句
			String sql="insert into topic(userId,tagId,title,createtime,content,del) values(?,?,?,?,?,?)";					
			ps=conn.prepareStatement(sql);
			ps.setInt(1, topic.getUserId());			
			ps.setInt(2, topic.getTagId());			
			ps.setString(3, topic.getTitle());			
			ps.setString(4, topic.getCreatetime());
			ps.setString(5,topic.getContent());
			ps.setInt(6,topic.getDel());
			
			
			if(ps.executeUpdate()==1) {
				//添加成功
				System.out.println("true");
				return true;
			}
			else {
				System.out.println("false");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭连接
			DBUtil.close(null, ps, conn);
		}
		return false; 
		
	}
	public List<TopicVO> allTopics(){
		List<TopicVO> topicVOs=new ArrayList<TopicVO>();
		Connection conn=DBUtil.getConn();
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			String sql="select a.id,a.userId,c.nickname,a.tagId,b.name,a.title,a.createtime,a.content,c.imgUrl," + 
					"(select count(*) from reply where topicId=a.id) as replyCount "+
					"from topic a,tag b,user c " + 				
					"where a.userId=c.id and a.tagId=b.id and a.del=0";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				TopicVO topicVO =new TopicVO();
				topicVO.setId(rs.getInt(1));
				topicVO.setUserId(rs.getInt(2));
				topicVO.setNickname(rs.getString(3));
				topicVO.setTagId(rs.getInt(4));
				topicVO.setTagName(rs.getString(5));
				topicVO.setTitle(rs.getString(6));				
				topicVO.setCreateTime(rs.getString(7));
				topicVO.setContent(rs.getString(8));
				topicVO.setImgUrl(rs.getString(9));
				topicVO.setReplyCount(rs.getInt(10));
				
				topicVOs.add(topicVO);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);			
		}
		return topicVOs;
	}
	
	public List<TopicVO> search(int tagId,String word){
		List<TopicVO>topicVOs=new ArrayList<TopicVO>();
		Connection conn=DBUtil.getConn();
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			String sql="select a.id,a.userId,c.nickname,a.tagId,b.name,a.title,a.createtime,a.content,c.imgUrl," + 
					"(select count(*) from reply where topicId=a.id) as replyCount "+
					"from topic a,tag b,user c " + 				
					"where a.userId=c.id and a.tagId=b.id and a.del=0 "+
					"and (a.title like ? or b.name like ? or c.nickname like ?) "+
					(tagId==0 ? "":" and a.tagId=?");
			word = "%"+word+"%";
			ps=conn.prepareStatement(sql);
			ps.setString(1, word);
			ps.setString(2, word);
			ps.setString(3, word);
			if(tagId!=0) {
				ps.setInt(4, tagId);
			}
			rs=ps.executeQuery();
			while(rs.next()) {
				TopicVO topicVO =new TopicVO();
				topicVO.setId(rs.getInt(1));
				topicVO.setUserId(rs.getInt(2));
				topicVO.setNickname(rs.getString(3));
				topicVO.setTagId(rs.getInt(4));
				topicVO.setTagName(rs.getString(5));
				topicVO.setTitle(rs.getString(6));				
				topicVO.setCreateTime(rs.getString(7));
				topicVO.setContent(rs.getString(8));
				topicVO.setImgUrl(rs.getString(9));
				topicVO.setReplyCount(rs.getInt(10));
				
				topicVOs.add(topicVO);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,ps,conn);
		}
		return topicVOs;
		
	}
	
	public TopicVO view(int topicId) {
		Connection conn=DBUtil.getConn();
		PreparedStatement ps= null;
		ResultSet rs=null;
		TopicVO topicVO=null;
		String sql="select a.id,a.userId,c.nickname,a.tagId,b.name,a.title,a.createtime,a.content,c.imgUrl," + 
				"(select count(*) from reply where topicId=a.id) as replyCount "+
				"from topic a,tag b,user c " + 				
				"where a.userId=c.id and a.tagId=b.id and a.del=0 "+
				"and a.id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, topicId);
			rs=ps.executeQuery();
			if(rs.next()) {
				topicVO =new TopicVO();
				topicVO.setId(rs.getInt(1));
				topicVO.setUserId(rs.getInt(2));
				topicVO.setNickname(rs.getString(3));
				topicVO.setTagId(rs.getInt(4));
				topicVO.setTagName(rs.getString(5));
				topicVO.setTitle(rs.getString(6));				
				topicVO.setCreateTime(rs.getString(7));
				topicVO.setContent(rs.getString(8));
				topicVO.setImgUrl(rs.getString(9));
				topicVO.setReplyCount(rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs,ps,conn);
		}
		return topicVO;
	}

	public static void main(String[]args) {
		TopicDao dao = new TopicDao();
//		List<TopicVO> topicVOs=new ArrayList<TopicVO>();
//		//topicVOs=dao.allTopics();
//		topicVOs=dao.search(1, ""); 
//		for(TopicVO topicVO:topicVOs) {
//			System.out.println(topicVO);
//		}
		System.out.println(dao.view(1));
	}

}
