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

import com.Dao.UpdateFeederInfoDao;
import com.Javabean.Pet_Feeder;
//打注解
@MultipartConfig
public class UpdateFeederInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateFeederInfoServlet() {
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
		String f_id = request.getParameter("id");
		String f_number = request.getParameter("number");
		String f_name = request.getParameter("fname");
		String f_sex = request.getParameter("sex");
		String f_idcard = request.getParameter("idcard");
		String f_tel = request.getParameter("tel");
		String f_address = request.getParameter("address");
		String f_notes = request.getParameter("notes");
		//通过list拿到图片
				List<Part> list = (List<Part>) request.getParts();
				String cd = list.get(8).getHeader("Content-Disposition");
				//截取不同类型的文件需要自行判断
				  String f_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
				  System.out.println(f_filename);
				//判断文件是否为空
				   if(!f_filename.equals("")){{
		              	 String url="C:\\liangzhy\\Uplode\\feeder\\";
		              	 String path=url+f_filename;
		              	 File f = new File(path);
		              	 //将文件写入本地
		              	list.get(8).write(f.getAbsolutePath());
		              	 //存到数据库，存文件的名字
		          }
				//将数据set到pi
				Pet_Feeder pi = new Pet_Feeder();
				pi.setF_id(Integer.parseInt(f_id));
				pi.setF_number(f_number);
				pi.setF_name(f_name);
				pi.setF_sex(f_sex);
				pi.setF_idcard(f_idcard);
				pi.setF_tel(f_tel);
				pi.setF_address(f_address);
				pi.setF_notes(f_notes);
				pi.setF_filename(f_filename);
				UpdateFeederInfoDao dao = new UpdateFeederInfoDao();
				boolean flag = dao.UpdateFeederInfo(pi);
				if(flag){
					String a = URLEncoder.encode("修改成功！", "UTF-8");  
			        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryFeederInfoServlet'</script>"); 
				}else{
					out.print("<script>alert('修改失败！');" + "window.location.href='updatefeederinfo.jsp';</script>");
					}
				}
			//不更图片的情况
				   else  if(f_filename.equals("")){
					   System.out.println("本次不更新图片");
				//将数据set到pi
				Pet_Feeder pi = new Pet_Feeder();
				pi.setF_id(Integer.parseInt(f_id));
				pi.setF_number(f_number);
				pi.setF_name(f_name);
				pi.setF_sex(f_sex);
				pi.setF_idcard(f_idcard);
				pi.setF_tel(f_tel);
				pi.setF_address(f_address);
				pi.setF_notes(f_notes);
				UpdateFeederInfoDao dao = new UpdateFeederInfoDao();
				boolean flag = dao.UpdateFeederInfoNOJPG(pi);
				if(flag){
					String a = URLEncoder.encode("修改成功！", "UTF-8");  
			        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryFeederInfoServlet'</script>"); 
				}else{
					out.print("<script>alert('修改失败！');" + "window.location.href='updatefeederinfo.jsp';</script>");
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
