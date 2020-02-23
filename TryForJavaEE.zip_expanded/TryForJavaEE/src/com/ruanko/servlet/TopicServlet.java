package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.model.Topic;
import com.ruanko.model.User;
import com.ruanko.service.ReplyService;
import com.ruanko.service.TopicService;

public class TopicServlet extends HttpServlet {
	private TopicService topicService ;
	private ReplyService replyService;

	public TopicServlet() {
		this.topicService=new TopicService();
		this.replyService=new ReplyService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr=req.getParameter("id");
		int id=0;
		if(idStr!=null&&!("".equals(idStr))){
			id=Integer.parseInt(idStr);			
		}
//		根据id获取帖子信息
		System.out.println("id"+id);
		req.setAttribute("topic", topicService.view(id));
		req.setAttribute("replys", replyService.findAllByTopicId(id));
//		转发到topic.jsp页面
		req.getRequestDispatcher("WEB-INF/pages/topic.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("utf-8");
			String action = req.getParameter("action");
			if ("publish".equals(action)) {
				// 处理发布帖子的请求
				publish(req,resp);

			} else {
				resp.sendError(404);//没有匹配
			}

		} catch (Exception e) {
			resp.sendError(500);
			e.printStackTrace();
		}
	}

	private void publish(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取传递过来的数据
		//判断session
		
		Object obj=req.getSession().getAttribute("user");
		String title=req.getParameter("title");
		String  tagIdStr = req.getParameter("tagId");
		String  content = req.getParameter("content");
		
		
		
		if(obj==null) {
			resp.sendRedirect("user?action=login");
			return ;
		}else {
			//用户已登录
			System.out.println("用户已登录");
			User user =(User)obj;
			int tagId=0;
			if(tagIdStr!=null && !("").equals(tagIdStr)) {
				tagId = Integer.parseInt(tagIdStr);
			}
			Topic topic = new Topic();
			topic.setTitle(title);
			topic.setUserId(user.getId());	
			System.out.println(user.getId());
			topic.setTagId(tagId);
			topic.setContent(content);
			
			if(topicService.publish(topic)) {
				//发布成功
				resp.sendRedirect("index");
			}
			else {
				//发布失败
				req.setAttribute("msg", "发布失败");
				req.getRequestDispatcher("index").forward(req, resp);
			}
		}
		
	}

}
