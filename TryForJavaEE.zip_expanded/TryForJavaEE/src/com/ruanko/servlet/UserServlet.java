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
				//��ת��ע��ҳ��
				
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
		System.out.println("������doPost����");
			String action=req.getParameter("action");
			if("register".equals(action)) {
//			ע���߼�
				register(req,resp);
			}
			else if("login".equals(action)) {
				//����ĵ�¼�߼�
				login(req,resp);
			}
			else {
				resp.sendError(404);
			}
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//����ĵ�½����
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String msg="";
		
		//��ȡ���ݹ�����ֵ
		//�ǿ��ж�
		if(username==null||("".equals(username))
				&&(password==null||("").equals(password))) {
			msg="�û��������벻��Ϊ��";
		}
		else {
			User user = userService.login(username, password);
			if(user==null) {
				msg="�û��������������";
			}else {
				//��½�ɹ� �ض�����ҳ
				req.getSession().setAttribute("user", user);//���û�����浽session��			
				resp.sendRedirect("index");		
				return ;
			}
		}
		//��½ʧ�ܵĴ�����Ϣ����תҳ��
		req.setAttribute("msg", msg);
		req.setAttribute("username", username);
		
		req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req, resp);
	
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡ���ݹ������û���Ϣ
		String username=req.getParameter("username");
		String nickname=req.getParameter("nickname");
		String password=req.getParameter("password");
		String password2=req.getParameter("password2");
		String msg="";
		if((username==null)||("").equals(username)&&(password==null)||("").equals(password)) {
			msg="�û��������벻��Ϊ��";
		}
		else if(password.equals(password2)==false) {
			msg="�������벻һ��";
		}
		else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			try {
			if(userService.register(user)) {
				//ע��ɹ�
				//��ת׼��ҳ��				
				req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req,resp);
				return;
			}
			else {
				msg="�û��Ѵ���";
			}
			//����ע��ҳ��
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
//		�û��˳���¼
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
