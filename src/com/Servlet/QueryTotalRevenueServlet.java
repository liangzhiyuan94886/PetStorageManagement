package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.QueryTotalRevenueDao;
import com.Javabean.Pet_Revenue;
import com.alibaba.fastjson.JSONArray;

public class QueryTotalRevenueServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryTotalRevenueServlet() {
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
		/*if(revenue !=null){
		double d1 = revenue.getP_price1();
		double d2 = revenue.getP_price2();
		double spend = revenue.getP_spend();
		Pet_Info p1 = new Pet_Info();
		p1.setP_price1(d1);
		p1.setP_price2(d2);
		p1.setP_spend(spend);
		System.out.println(revenue.getP_price1());
		System.out.println(revenue.getP_price2());
		System.out.println(revenue.getP_spend());
		session.setAttribute("d1", d1);
		session.setAttribute("revenuelist", p1);
		/response.sendRedirect("totalrevenue.jsp");
	}*/
	
	/*for(int i =0 ;i<list.size();i++){
		System.out.println(list.get(i));
	}
	String json=JSONArray.toJSONString(list);
	System.out.println(json.toString());
	//返回给前段页面
    PrintWriter out = response.getWriter();  
    out.println(json);  
    out.flush();  
    out.close(); */
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @param cost 
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		System.out.println(date1+"和"+date2);*/
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
