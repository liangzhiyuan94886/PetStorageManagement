package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.AddMessageDao;

public class AddMessageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddMessageServlet() {
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
		//通过唯用户名查
		String username = (String)session.getAttribute("un");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		String sign = request.getParameter("sign");
		System.out.println(username);
		System.out.println(date);
		System.out.println(content);
		System.out.println(sign);
		AddMessageDao Dao = new AddMessageDao();
		//只能管理员看见存1
		if(!"".equals(sign) && "1".equals(sign)){
			System.out.println("存1");
			boolean flag = Dao.AddMessageByone(username, content, date, sign);
			if(flag){
				String a = URLEncoder.encode("留言已发表！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='userinfo.jsp'</script>");
		       }
			else{
				String a = URLEncoder.encode("发表失败！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='leavemessage.jsp.jsp'</script>");
		       }
		}
		//qita 人可看见  存2
		else{
			System.out.println("存2");
			Integer sign2 =2;
			boolean flag = Dao.AddMessageBytwo(username, content, date, sign2);
			if(flag){
				String a = URLEncoder.encode("留言已发表！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='userinfo.jsp'</script>");
		       }
			else{
				String a = URLEncoder.encode("发表失败！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='leavemessage.jsp.jsp'</script>");
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
