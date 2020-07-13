package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.Dao.UpdateMyInfoDao;
import com.Javabean.Pet_Admin;

//打注解
@MultipartConfig
public class UpdateMyInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMyInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//根据ID更新信息
		String a_id = request.getParameter("id");
		String a_number = request.getParameter("number");
		String a_name = request.getParameter("Aname");
		String a_sex = request.getParameter("sex");
		String a_idcard = request.getParameter("idcard");
		String a_tel = request.getParameter("tel");
		String a_address = request.getParameter("address");
		String a_notes = request.getParameter("notes");
		UpdateMyInfoDao dao = new UpdateMyInfoDao();
		//通过list存取到图片
		List<Part> list = (List<Part>) request.getParts();
		String cd = list.get(8).getHeader("Content-Disposition");
		//截取不同类型的文件需要自行判断
		  String a_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
		  System.out.println(a_filename);
		//判断文件是否为空
		   if(!a_filename.equals("")){{
              	 String url="C:\\liangzhy\\Uplode\\admin\\";
              	 String path=url+a_filename;
              	 File f = new File(path);
              	 //将文件写入本地
              	list.get(8).write(f.getAbsolutePath());
              	 //存到数据库，存文件的名字
          }
		//将数据set到pi
		Pet_Admin pi = new Pet_Admin();
		pi.setA_id(Integer.parseInt(a_id));
		pi.setA_number(a_number);
		pi.setA_name(a_name);
		pi.setA_sex(a_sex);
		pi.setA_idcard(a_idcard);
		pi.setA_tel(a_tel);
		pi.setA_address(a_address);
		pi.setA_notes(a_notes);
		pi.setA_filename(a_filename);
		boolean flag = dao.UpdateMyInfo(pi);
		if(flag){
			String a = URLEncoder.encode("信息更新成功！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryMyInfoServlet'</script>"); 
		}else{
			out.print("<script>alert('更新失败！');" + "window.location.href='updatemyinfo.jsp';</script>");
			}
		}
		 //不更图片的情况:
		   else  if(a_filename.equals("")){
			   System.out.println("本次不更新图片");
			 //将数据set到pi
				Pet_Admin pi = new Pet_Admin();
				pi.setA_id(Integer.parseInt(a_id));
				pi.setA_number(a_number);
				pi.setA_name(a_name);
				pi.setA_sex(a_sex);
				pi.setA_idcard(a_idcard);
				pi.setA_tel(a_tel);
				pi.setA_address(a_address);
				pi.setA_notes(a_notes);
				boolean flag = dao.UpdateMyInfoNOJPG(pi);
				if(flag){
					String a = URLEncoder.encode("信息更新成功！", "UTF-8");  
			        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryMyInfoServlet'</script>"); 
				}else{
					out.print("<script>alert('更新失败！');" + "window.location.href='updatemyinfo.jsp';</script>");
					}
		   }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
