package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.service.TagService;
import com.ruanko.service.TopicService;

public class SearchServlet extends HttpServlet {
	TagService tagService;
	TopicService topicService;

	public SearchServlet() {
		tagService=new TagService();
		topicService = new TopicService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String tagIdStr=req.getParameter("tagId");
		String word=req.getParameter("word");
		int tagId=0;
		if(tagIdStr!=null&&!"".equals(tagIdStr)) {
			tagId=Integer.parseInt(tagIdStr);
		}
		if(word==null) {
			word="";
		}
		req.setAttribute("tags", tagService.allTags());
		req.setAttribute("topics", topicService.search(tagId,word));
//		×ª·¢
		req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);
		
		
	}

}
