package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.CompleteOrderDao;

public class CompleteOrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CompleteOrderServlet() {
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
		Integer id = Integer.parseInt(request.getParameter("id"));
		String operator = request.getParameter("operator");
		String nowtime = request.getParameter("nowtime");
		Integer day = Integer.parseInt(request.getParameter("day"));
		Integer hour = Integer.parseInt(request.getParameter("hour"));
		Double spend = Double.parseDouble(request.getParameter("spend"));
		Integer sign = 2;
		CompleteOrderDao Dao = new CompleteOrderDao();
		boolean flag = Dao.CompleteOrder(id, operator, nowtime, day, hour, spend,sign);
		if(flag){
			String a = URLEncoder.encode("本次寄存已完成！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryPetInfoServlet'</script>");
	       }
		else{
			String a = URLEncoder.encode("Error！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='petdetailinfo.jsp'</script>");
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
