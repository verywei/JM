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
		// ��ȡweb��xml�е��ļ�������,���жϸ��ļ����ļ����Ƿ����
		String folder = getServletConfig().getInitParameter("folder");
		// �ж��ļ����Ƿ���ڣ������ļ���
		if (folder != null && folder.trim().length() > 0) {
			this.folder = folder;
		}
		// �����ļ���
		 file = new File(folder);
		// �ж��ļ����Ƿ����
		if (!file.exists()) {
			file.mkdirs();		
		}
		super.init();
	}

	private static String getRandomFileName() {
		// ʱ���
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		// �����  
		Random rand = new Random();

		String filename = String.format("%s%05d", sdf.format(new Date()), rand.nextInt(10000));
		return filename;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = null;
		// �жϱ��������Ƿ���һ�����ϴ��ļ��ĸ���������
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {	// �жϱ��������Ƿ���һ�����ϴ��ļ��ĸ���������
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024*2);// ������󻺴�
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("UTF-8");
			
			upload.setFileSizeMax(1024*1024*2);//�����ϴ��ĵ��ļ���С
			upload.setSizeMax(1024*1024*6);//�����ϴ��ļ����ܴ�С
			
			//��ȡ����
			try {
//				out=response.getWriter();
				List<FileItem> items = upload.parseRequest(request);
				if(items!=null) {
					for (FileItem item : items) {//����
						if (item.isFormField()) {
							// ��һ�㡱���ݣ��ַ���
							String name=item.getFieldName();
							String value=item.getString("utf-8");
							System.out.println(name+":"+value);
						} else {
							// �������ݣ��ļ�
							String orignName=item.getName();//�ļ�ԭ��
							
							//��ȡ��׺��
							int index = orignName.lastIndexOf("."); //�ļ�ԭ��

							String suffix = orignName.substring(index);
							
							String path = String.format("%s/%s%s",folder, getRandomFileName(),suffix);							
							
							item.write(new File(path));
							System.out.printf("�ļ�[%s]�ѱ��浽[%s]\n",orignName,path);
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
////	 ���ڲ����ļ���
//	 System.out.println(getRandomFileName());
//	 }

}
