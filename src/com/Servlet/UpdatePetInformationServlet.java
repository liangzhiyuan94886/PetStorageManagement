package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UpdatePetInformationDao;

public class UpdatePetInformationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePetInformationServlet() {
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
		//获取数据
		Double id = Double.parseDouble(request.getParameter("id"));
		String name = request.getParameter("petname");
		String type = request.getParameter("pettype");
		String pets = request.getParameter("pets");
		String color = request.getParameter("petcolor");
		Double weight = Double.parseDouble(request.getParameter("petweight"));
		Double age = Double.parseDouble(request.getParameter("petage"));
		String owner = request.getParameter("petowner");
		UpdatePetInformationDao dao = new UpdatePetInformationDao();
		boolean flag = dao.UpdatePetInformation(id, name, type, pets, color, weight, age, owner);
		if(flag){
			String a = URLEncoder.encode("修改成功！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryPetInformationServlet'</script>"); 
		}else{
			out.print("<script>alert('修改失败！');" + "window.location.href='updatepetinformation.jsp';</script>");
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
