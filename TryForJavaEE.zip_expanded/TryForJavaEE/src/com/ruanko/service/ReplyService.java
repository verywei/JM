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
	
//	����topicId��ѯ���л�����Ϣ
	public List<ReplyVO> findAllByTopicId(int topicId){
		return replyDao.findAllByTopicId(topicId);
	}
	
	public int reply(Reply reply) {
//		����ҳ���л�ȡ�����Ķ���
		reply.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		reply.setDel(0);
		return replyDao.reply(reply);
		
	}

}
