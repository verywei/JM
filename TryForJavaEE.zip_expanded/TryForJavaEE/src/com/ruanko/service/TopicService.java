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
//		搜索全部
		return topicDao.allTopics();
	}
	
	public List<TopicVO> search(int tagId,String word){
//		根据tagId或者关键字搜索
		return topicDao.search(tagId, word);
	}
	
	public TopicVO view(int topicId) {
//		根据topicId查询帖子信息
		return topicDao.view(topicId);
	}
}
