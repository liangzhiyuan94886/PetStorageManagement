package com.Servlet;

import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.QueryPetDetailInfoDao;
import com.Javabean.Pet_Info;

public class QueryPetDetailInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryPetDetailInfoServlet() {
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
		//取ID
		String p_id = request.getParameter("id");
		QueryPetDetailInfoDao dao =  new QueryPetDetailInfoDao();
		Pet_Info petinfo = dao.QueryPetDetailInfo(Integer.parseInt(p_id));
		//获取当前时间
		Date currentTime = new Date();
		System.out.println("现在时间="+currentTime);
		//文件名
		String file = petinfo.getP_filename();
		System.out.println("文件"+file);
		//获取寄存时间
		String S = petinfo.getP_time();
		System.out.println("寄存时间="+S);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 ParsePosition pos = new ParsePosition(0);
		//寄存时间转格式
		 Date strtodate = formatter.parse(S, pos);
		 System.out.println("寄存时间转格式="+strtodate);
		 long time1 = currentTime.getTime();
		 long time2 = strtodate.getTime();
		 //获得寄存时长
		 long alltime=time1-time2;
		 System.out.println(alltime);
		 //转换时间
		 long day = alltime/(24 * 60 * 60 * 1000);
		 long hour=(alltime/(60*60*1000)-day*24);
		 long min=((alltime/(60*1000))-day*24*60-hour*60);
		 long s=(alltime/1000-day*24*60*60-hour*60*60-min*60);
		 System.out.println(day+"天"+hour+"小时"+min+"分"+s+"秒");
		 /*//判断套餐
		 System.out.println(petinfo.getP_combo());
		 if(petinfo.getP_combo().equals("套餐三150/天")){
			 int taocan3 = 150; 
			 System.out.println(taocan3);
			 if(petinfo.getP_other().equals("洗澡+剪毛50/次")){
				 int jianmao = 50;*/
				 //计算总共花费
		 		double price1 = petinfo.getP_price1();
		 		double price2 = petinfo.getP_price2();
		 		if(day!=0 && hour>=12){
		 			double totalmoney = price1*(day+1)+price2;
		 			System.out.println("总共花费"+totalmoney);
		 			session.setAttribute("totalmoney", totalmoney);
		 		}else if(day!=0 && hour<12){
		 			double totalmoney = price1*day+hour*5+price2;
		 			System.out.println("总共花费"+totalmoney);
		 			session.setAttribute("totalmoney", totalmoney);
		 		}else if(day==0 && hour>=12){
		 			double totalmoney = price1+price2;
		 			System.out.println("总共花费"+totalmoney);
		 			session.setAttribute("totalmoney", totalmoney);
		 		}else{
		 			double totalmoney =6*hour+price2;
		 			System.out.println("总共花费"+totalmoney);
		 			session.setAttribute("totalmoney", totalmoney);
		 		}
		 		
		 		
		 		
		 		
		 		
		 session.setAttribute("day", day);
		 session.setAttribute("hour", hour);
		 session.setAttribute("petinfo", petinfo);
		 response.sendRedirect("petdetailinfo.jsp");
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
