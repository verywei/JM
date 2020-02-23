package com.ruanko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.service.AdminService;

public class AdminServlet extends HttpServlet {
	AdminService adminService;
	public AdminServlet() {
		this.adminService=new AdminService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			String action = req.getParameter("action");
			if("login".equals(action)) {
				req.getRequestDispatcher("WEB-INF/pages/adminLogin.jsp")
				.forward(req, resp);
				return;
			} else if ("logout".equals(action)) {
				logout(req,resp);
			} else if("index".equals(action)) {
				req.getRequestDispatcher("WEB-INF/pages/AdminIndex.jsp")
				.forward(req, resp);
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String action = req.getParameter("action");
			if ("login".equals(action)) {
				// ����ĵ�¼�߼�
				login(req, resp);
			} else {
				resp.sendError(404);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendError(500);
		}
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//����Ա��¼
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String msg = "";

		// ��ȡ���ݹ�����ֵ
		// �ǿ��ж�
		if (username == null || ("".equals(username)) && (password == null || ("").equals(password))) {
			msg = "�û��������벻��Ϊ��";
		} else {
			Admin admin=adminService.login(username, password);
			if (admin == null) {
				msg = "�û��������������";
			} else {
				// ��½�ɹ� �ض�����ҳ
				req.getSession().setAttribute("admin",admin);// ���û�����浽session��
				resp.sendRedirect("admin?action=index");
				return ;
			}
		}
		// ��½ʧ�ܵĴ�����Ϣ����תҳ��
		req.setAttribute("msg", msg);
		req.setAttribute("username", username);
		req.getRequestDispatcher("WEB-INF/pages/adminLogin.jsp").forward(req, resp);

	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		����Աע��
		 HttpSession session=req.getSession();
		 if(session.getAttribute("admin")!=null) {
			 session.removeAttribute("admin");
		 }
		 resp.sendRedirect("index");
		
	}


}
