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

import com.Dao.AddAccountDao;
import com.Javabean.Pet_Admin;
//打注解
@MultipartConfig
public class AddAccountServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddAccountServlet() {
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
		//获取值
		String admin = request.getParameter("admin");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		String name = request.getParameter("fname");
		String sex = request.getParameter("sex");
		String idcard = request.getParameter("idcard");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String notes = request.getParameter("notes");
		//存到list
		List<Part> list = (List<Part>) request.getParts();
		String cd = list.get(9).getHeader("Content-Disposition");
		//截取不同类型的文件需要自行判断
		  String a_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
		  System.out.println(a_filename);
		  //判断文件不为空！
		  if(!a_filename.equals("")){
           	 String url="C:\\liangzhy\\Uplode\\admin\\";
           	 String path=url+a_filename;
           	 File f = new File(path);
           	 //将文件写入本地
           	list.get(9).write(f.getAbsolutePath());
           	 //存到数具库中，存文件的名字
       }
		  Pet_Admin pi = new Pet_Admin();
			pi.setA_admin(admin);
			pi.setA_password(password);
			pi.setA_number(number);
			pi.setA_name(name);
			pi.setA_sex(sex);
			pi.setA_idcard(idcard);
			pi.setA_tel(tel);
			pi.setA_address(address);
			pi.setA_notes(notes);
			pi.setA_filename(a_filename);
			AddAccountDao Dao = new AddAccountDao();
			boolean flag = Dao.AddAccount(pi);
			if(flag){
				String a = URLEncoder.encode("设置账号成功！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryAccountInfoServlet'</script>"); 
			}else{
				out.print("<script>alert('设置失败！');" + "window.location.href='addaccount.jsp';</script>");
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
