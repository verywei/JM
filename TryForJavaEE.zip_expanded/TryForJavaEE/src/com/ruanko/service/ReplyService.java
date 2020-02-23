package com.ruanko.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruanko.dao.ReplyDao;
import com.ruanko.model.Reply;
import com.ruanko.model.ReplyVO;

public class ReplyService {
	private ReplyDao replyDao;

	public ReplyService() {
		this.replyDao=new ReplyDao();
	}
	
//	根据topicId查询所有回帖信息
	public List<ReplyVO> findAllByTopicId(int topicId){
		return replyDao.findAllByTopicId(topicId);
	}
	
	public int reply(Reply reply) {
//		设置页面中获取不到的东西
		reply.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		reply.setDel(0);
		return replyDao.reply(reply);
		
	}

}
