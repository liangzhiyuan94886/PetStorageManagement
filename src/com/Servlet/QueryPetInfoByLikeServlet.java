package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.QueryPetInfoByLikeDao;
import com.Javabean.Pet_Info;

public class QueryPetInfoByLikeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryPetInfoByLikeServlet() {
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
		//得到content
		String content1 = request.getParameter("content1");
		String content2 = request.getParameter("content2");
		String date1 =  request.getParameter("date1");
		String date2 = request.getParameter("date2");
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date strtodate1=new java.util.Date();
		 java.util.Date strtodate2=new java.util.Date();
		try {
			strtodate1 = formatter.parse(date1);
			strtodate2 = formatter.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 long d1 = strtodate1.getTime();
		 long d2 = strtodate2.getTime();
		Date date1=new Date(d1);
		Date date2=new Date(d2);*/
		System.out.println("content1="+content1);
		System.out.println("content2="+content2);
		System.out.println(date1);
		System.out.println(date2);
		//调用
		QueryPetInfoByLikeDao Dao = new QueryPetInfoByLikeDao();
		ArrayList<Pet_Info> querylist = null;
		
		//都为空
		if((content1.equals(null)||content1.trim().equals(""))&&(content2.equals(null)||content2.trim().equals(""))&&(date1.equals(null)||date1.equals(""))&&(date2.equals(null)||date2.equals("")) ){
			System.out.println("都为空!");
			querylist = Dao.QueryPetInfoByNull();
		}
		//都不为空
		else if(content1!="" && content2!="" && date1!="" && date2!=""){
			querylist = Dao.QueryPetInfoByAll(content1, content2, date1, date2);
			System.out.println("都不为空!");
		}
		//content1不为空 && content2和日期为空
		else if(content1!="" && content2=="" && date1=="" && date2==""){
			querylist = Dao.QueryPetInfoByContent1(content1);
			System.out.println("content1不为空!");
		}
		//content1和content2不为空，时期为空 
		else if(content1!="" && content2!="" && date1=="" && date2==""){
			System.out.println("日期为空！");
			querylist = Dao.QueryPetInfoBycontent1Andcontent2(content1, content2);
		}
		//content1和时间不为空，content2为空
		else if(content1!="" && content2=="" && date1!="" && date2!=""){
			System.out.println("content2为空！");
			querylist = Dao.QueryPetInfoByDayAndContent1(content1, date1, date2);
		}
		//content2不为空，content1和时间为空
		else if(content1=="" && content2!="" && date1=="" && date2==""){
			System.out.println("content2不为空！");
			querylist = Dao.QueryPetInfoByContent2(content2);
		}
		//content2和时间不为空，content1为空
		else if(content1=="" && content2!="" && date1!="" && date2!=""){
			System.out.println("content1为空！");
			querylist = Dao.QueryPetInfoByContent2AndDay(content2, date1, date2);
		}
		//时间不为空，content1和content2为空
		else if((content1.equals(null)||content1.trim().equals(""))&&(content2.equals(null)||content2.trim().equals("")) && !date1.equals(null) && !date2.equals(null) ){
			System.out.println("时间不为空！");
			querylist = Dao.QueryPetInfoByDay(date1, date2);
		}
		//返回集合
		session.setAttribute("petlist", querylist);
		response.sendRedirect("mainadmin.jsp");
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
