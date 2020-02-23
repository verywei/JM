package com.ruanko;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JsonServlet
 */

public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置返回的结果编码格式
		response.setContentType("text/html;charset=utf-8");
		List<Person>list=JsonUtils.newPersonList();
		String json= JsonUtils.makeJson(list);
		System.out.println(json);
		
		response.getWriter().print(json);
	}
}
