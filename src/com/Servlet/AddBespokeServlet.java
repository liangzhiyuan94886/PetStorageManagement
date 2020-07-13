package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.AddBespokeDao;

public class AddBespokeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddBespokeServlet() {
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
		Integer id = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("username");
		String type = request.getParameter("pettype");
		String pet = request.getParameter("pets");
		String tel = request.getParameter("tel");
		String date = request.getParameter("comedate");
		System.out.println(id);
		System.out.println(name);
		System.out.println(type);
		System.out.println(pet);
		System.out.println(tel);
		System.out.println(date);
		//添加未处理预存b_sign=1
		Integer b_sign = 1;
		AddBespokeDao Dao = new AddBespokeDao();
		boolean flag = Dao.AddBespoke(id, name, type, pet, tel, date,b_sign);
		if(flag){
			String a = URLEncoder.encode("预约成功！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='userinfo.jsp'</script>");
	       }
		else{
			String a = URLEncoder.encode("预约失败！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='bespoke.jsp'</script>");
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
