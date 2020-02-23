package com.ruanko.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruanko.model.Reply;
import com.ruanko.model.ReplyVO;
import com.ruanko.utils.DBUtil;

public class ReplyDao {
	public List<ReplyVO> findAllByTopicId(int topicId){
		List<ReplyVO> replyVOs=new ArrayList<>();
		Connection conn=DBUtil.getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			String sql="select a.id,b.content,c.nickname,b.createtime,c.imgUrl " + 
					"from topic a,reply b,user c " + 
					"where a.id=b.topicId and a.userId=c.id and a.del=0 and a.id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1,topicId);
			rs=ps.executeQuery();
			while(rs.next()) {
				ReplyVO replyVO =new ReplyVO();
				replyVO.setId(rs.getInt(1));
				replyVO.setContent(rs.getString(2));
				replyVO.setNickName(rs.getString(3));
				replyVO.setCreateTime(rs.getString(4));
				replyVO.setImgUrl(rs.getString(5));
				replyVOs.add(replyVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return replyVOs;
	}

	public int reply(Reply reply) {
//		数据库连接对象，预编译对象，结果集对象
		
		Connection conn=DBUtil.getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int replyId=0;
		try {
			String sql="insert into reply(topicId,userId,content,createtime,del) values (?,?,?,?,?)";
			ps=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, reply.getTopicId());
			ps.setInt(2, reply.getUserId());
			ps.setString(3, reply.getContent());
			ps.setString(4, reply.getCreatetime());
			ps.setInt(5, reply.getDel());
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			if(rs.next()) {
				replyId= rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ps, conn);
		}		
		return replyId;
	}
	public static void main(String[]args) {
		ReplyDao replyDao = new ReplyDao();
		Reply reply =new Reply();
		reply.setUserId(1);
		reply.setTopicId(1);
		reply.setContent("11111111111111111111111111");
		reply.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		reply.setDel(0);
		replyDao.reply(reply);
		/*List<ReplyVO> replyVOs=new ArrayList<>();
		replyVOs=replyDao.findAllByTopicId(1);
		for(ReplyVO replyVO:replyVOs) {
			System.out.println(replyVO);
		}*/
	}
}
