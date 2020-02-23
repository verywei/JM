package com.ruanko;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private String folder;
	private static final long serialVersionUID = 1L;
	File file;

	@Override
	public void init() throws ServletException {
		// 获取web。xml中的文件名参数,并判断改文件的文件名是否存在
		String folder = getServletConfig().getInitParameter("folder");
		// 判断文件夹是否存在，创建文件夹
		if (folder != null && folder.trim().length() > 0) {
			this.folder = folder;
		}
		// 创建文件夹
		 file = new File(folder);
		// 判断文件夹是否存在
		if (!file.exists()) {
			file.mkdirs();		
		}
		super.init();
	}

	private static String getRandomFileName() {
		// 时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		// 随机数  
		Random rand = new Random();

		String filename = String.format("%s%05d", sdf.format(new Date()), rand.nextInt(10000));
		return filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = null;
		// 判断本次请求是否是一个有上传文件的复杂性请求
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {	// 判断本次请求是否是一个有上传文件的复杂性请求
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*2);// 设置最大缓存
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			
			upload.setFileSizeMax(1024*1024*2);//设置上传的当文件大小
			upload.setSizeMax(1024*1024*6);//设置上传文件的总大小
			
			//获取参数
			try {
//				out=response.getWriter();
				List<FileItem> items = upload.parseRequest(request);
				if(items!=null) {
					for (FileItem item : items) {//遍历
						if (item.isFormField()) {
							// “一般”数据，字符串
							String name=item.getFieldName();
							String value=item.getString("utf-8");
							System.out.println(name+":"+value);
						} else {
							// 复杂数据，文件
							String orignName=item.getName();//文件原名
							
							//获取后缀名
							int index = orignName.lastIndexOf("."); //文件原名

							String suffix = orignName.substring(index);
							
							String path = String.format("%s/%s%s",folder, getRandomFileName(),suffix);							
							
							item.write(new File(path));
							System.out.printf("文件[%s]已保存到[%s]\n",orignName,path);
							response.getWriter().print("success");
													
						}
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

//	 public static void main(String[]args) {
////	 用于测试文件名
//	 System.out.println(getRandomFileName());
//	 }

}
