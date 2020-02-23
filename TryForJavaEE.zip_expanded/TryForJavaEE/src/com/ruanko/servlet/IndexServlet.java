package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.service.TagService;
import com.ruanko.service.TopicService;


public class IndexServlet extends HttpServlet {
	private TagService tagService;
	private TopicService topicService;
	

	public IndexServlet() {
		this.tagService = new TagService();
		this.topicService=new TopicService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			//�����ǩ��Ϣ
			req.setAttribute("tags", tagService.allTags());
			//����������Ϣ			
			req.setAttribute("topics", topicService.allTopics());
			req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);			
		}catch(Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
