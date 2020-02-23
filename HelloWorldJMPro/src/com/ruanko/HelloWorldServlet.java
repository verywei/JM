package com.ruanko;

import java.io.*;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
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
