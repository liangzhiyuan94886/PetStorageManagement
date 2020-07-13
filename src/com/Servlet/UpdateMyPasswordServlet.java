package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.AdminLoginDao;
import com.Dao.UpdateMyPasswordDao;
import com.Dao.UpdatePasswordDao;
import com.Dao.UserLoginDao;

public class UpdateMyPasswordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMyPasswordServlet() {
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
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//获取用户名和原密码验证，获取新密码
		String adminName = (String)session.getAttribute("an");
		String adminPassword  = request.getParameter("oldpassword");
		String newadminPassword  = request.getParameter("newpassword2");
		System.out.println(adminName+adminPassword+newadminPassword);
		//验证原密码是否一致是否
		boolean flag = AdminLoginDao.MyLoginCheck(adminName, adminPassword);
		if(flag){
			System.out.println("原密码一致");
			UpdateMyPasswordDao dao = new UpdateMyPasswordDao();
			boolean flag1 = dao.UpdateMyPassword(newadminPassword, adminName);
			String a = URLEncoder.encode("修改成功！请重新登录！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='index.jsp'</script>");
		}else{
			String a = URLEncoder.encode("修改失败！请检原密码是否正确！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='updatemypassword.jsp'</script>");
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
