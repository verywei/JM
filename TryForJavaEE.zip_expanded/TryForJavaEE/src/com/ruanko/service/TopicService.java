package com.ruanko.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruanko.dao.TopicDao;
import com.ruanko.model.Topic;
import com.ruanko.model.TopicVO;

public class TopicService {

	TopicDao topicDao;
	public TopicService() {
		this.topicDao=new TopicDao();
	}
	public boolean publish(Topic topic) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		topic.setCreatetime(sdf.format(new Date()));
//		topic.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return topicDao.add(topic);
	}

	public List<TopicVO> allTopics(){
//		����ȫ��
		return topicDao.allTopics();
	}
	
	public List<TopicVO> search(int tagId,String word){
//		����tagId���߹ؼ�������
		return topicDao.search(tagId, word);
	}
	
	public TopicVO view(int topicId) {
//		����topicId��ѯ������Ϣ
		return topicDao.view(topicId);
	}
}
