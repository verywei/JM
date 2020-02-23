package com.ruanko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Try extends HttpServlet {

	public Try() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("HelloWorld");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
