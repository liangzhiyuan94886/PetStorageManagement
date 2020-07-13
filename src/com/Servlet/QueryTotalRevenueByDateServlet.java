package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.QueryTotalRevenueByDateDao;
import com.Dao.QueryTotalRevenueDao;
import com.Javabean.Pet_Revenue;
import com.alibaba.fastjson.JSONArray;

public class QueryTotalRevenueByDateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryTotalRevenueByDateServlet() {
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
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		System.out.println(date1+"和"+date2);
		//有日期去查
		if(!date1.equals("") && !date2.equals("")){
			System.out.println("有日期！");
			QueryTotalRevenueByDateDao dao =  new QueryTotalRevenueByDateDao();
			Integer n0 =  dao.querytotalrevenueByAllAndDate(date1,date2);
			Integer n1 =  dao.querytotalrevenueByDogAndDate(date1,date2);
			Integer n2 =  dao.querytotalrevenueByCatAndDate(date1, date2);
			Integer n3 =  dao.querytotalrevenueByOtherAndDate(date1, date2);
			System.out.println("按日期查"+"n1是"+n1+"n2是"+n2+"n3是"+n3);
			//
			List<Pet_Revenue> list= new ArrayList<Pet_Revenue>();
			Pet_Revenue pr= new Pet_Revenue();
			pr.setN0(n0);
			pr.setN1(n1);
			pr.setN2(n2);
			pr.setN3(n3);
			list.add(pr);
			String json=JSONArray.toJSONString(list);
			System.out.println("list是"+list);
			PrintWriter out = response.getWriter();  
	        out.println(json);  
	        out.flush();  
	        out.close();
		}
		//没有日期，查询全部收入！
		else{
			QueryTotalRevenueDao dao =  new QueryTotalRevenueDao();
			//取得各个收入封装JavaBean
			Integer n0 =  dao.querytotalrevenueByAll();
			Integer n1 =  dao.querytotalrevenueByDog();
			Integer n2 =  dao.querytotalrevenueByCat();
			Integer n3 =  dao.querytotalrevenueByOther();
			System.out.println("n1是"+n1+"n2是"+n2+"n3是"+n3);
			List<Pet_Revenue> list= new ArrayList<Pet_Revenue>();
			Pet_Revenue pr= new Pet_Revenue();
			pr.setN0(n0);
			pr.setN1(n1);
			pr.setN2(n2);
			pr.setN3(n3);
			list.add(pr);
			String json=JSONArray.toJSONString(list);
			PrintWriter out = response.getWriter();  
	        out.println(json);  
	        out.flush();  
	        out.close();
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
