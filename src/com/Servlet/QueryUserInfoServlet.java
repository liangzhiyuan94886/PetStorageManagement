package com.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.QueryUserInfoDao;
import com.Javabean.Pet_Info;
import com.Javabean.Pet_User;

public class QueryUserInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryUserInfoServlet() {
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
		//通过唯用户名查询用户信息
		String userName = (String)session.getAttribute("un");
		Pet_User id = (Pet_User)session.getAttribute("ID");
		Integer u_id = id.getU_id();
		System.out.println(userName+u_id);
		QueryUserInfoDao dao = new QueryUserInfoDao();
		Pet_User user = dao.queryUserByName(userName);
		session.setAttribute("userinfo", user);
		//通过用户ID查询订单信息
		List<Pet_Info> lst= dao.QueryUserOrederInfoByDateAndID(userName,u_id);
		session.setAttribute("order", lst);
		response.sendRedirect("userinfo.jsp");
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
