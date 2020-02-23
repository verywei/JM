package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.User;
import com.ruanko.service.UserService;

public class UserServlet extends HttpServlet {
	UserService userService;
	

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) 
			throws IOException{
		
			String action=req.getParameter("action");
			
			try {
			if("register".equals(action)) {
				//跳转到注册页面
				
				req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req, resp);
				
			}
			else if("login".equals(action)) {
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
			}
			else if("logout".equals(action)) {
				logout(req,resp);
			}
			else {
				resp.sendError(404);
			}
			} catch (ServletException e) {
				e.printStackTrace();
				resp.sendError(500);
			}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException{
		System.out.println("这里是doPost方法");
			String action=req.getParameter("action");
			if("register".equals(action)) {
//			注册逻辑
				register(req,resp);
			}
			else if("login".equals(action)) {
				//具体的登录逻辑
				login(req,resp);
			}
			else {
				resp.sendError(404);
			}
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//具体的登陆功能
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String msg="";
		
		//获取传递过来的值
		//非空判断
		if(username==null||("".equals(username))
				&&(password==null||("").equals(password))) {
			msg="用户名和密码不能为空";
		}
		else {
			User user = userService.login(username, password);
			if(user==null) {
				msg="用户名或者密码错误";
			}else {
				//登陆成功 重定向到主页
				req.getSession().setAttribute("user", user);//将用户对象存到session中			
				resp.sendRedirect("index");		
				return ;
			}
		}
		//登陆失败的错误信息及跳转页面
		req.setAttribute("msg", msg);
		req.setAttribute("username", username);
		
		req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
	
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) {
		//获取传递过来的用户信息
		String username=req.getParameter("username");
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		String password2=req.getParameter("password2");
		String msg="";
		if((username==null)||("").equals(username)&&(password==null)||("").equals(password)) {
			msg="用户名或密码不能为空";
		}
		else if(password.equals(password2)==false) {
			msg="两次密码不一致";
		}
		else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			try {
			if(userService.register(user)) {
				//注册成功
				//跳转准则页面				
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req,resp);
				return;
			}
			else {
				msg="用户已存在";
			}
			//返回注册页面
			req.setAttribute("msg", msg);
			req.setAttribute("username", username);
			req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req,resp);
			} catch (ServletException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(msg);
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		用户退出登录
		HttpSession session=req.getSession();
		if(session.getAttribute("user")!=null) {
			session.removeAttribute("user");
		}
		resp.sendRedirect("index");			
	}

	public UserServlet() {
		this.userService=new UserService();
	}
	

}
