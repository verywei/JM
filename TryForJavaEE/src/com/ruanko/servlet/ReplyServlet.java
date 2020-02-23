package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.model.Reply;
import com.ruanko.model.User;
import com.ruanko.service.ReplyService;

public class ReplyServlet extends HttpServlet {
	private ReplyService replyService;

	public ReplyServlet() {
		this.replyService=new ReplyService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		try {
			if("reply".equals(action)) {
				reply(req,resp);
			}else {
				resp.sendError(404);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	private void reply(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//		检测用户是否登陆
		User user = null;
		Object obj =req.getSession().getAttribute("user");
		if(obj==null) {
			resp.sendRedirect("user?action=login");
		}
		else {
			//已登录
			user=(User)obj;
		}
		String content=req.getParameter("content");
		String idStr=req.getParameter("topicId");
		int topicId=0;
		if(idStr!=null||!idStr.equals("")) {
			topicId=Integer.parseInt(idStr);
		}
		
		Reply reply=new Reply();
		reply.setTopicId(topicId);
		reply.setUserId(user.getId());
		reply.setContent(content);
		if(replyService.reply(reply)!=0) {
			//回复成功
			resp.sendRedirect("topic?id="+topicId);
			
		}
		else {
//			回复失败
			req.setAttribute("msg", "回复失败");
			req.getRequestDispatcher("topic?id="+topicId).forward(req, resp);
		}
		
	}

}
