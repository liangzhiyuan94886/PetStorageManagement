package com.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.Dao.AddPetInfoDao;
//打注解
@MultipartConfig
public class AddPetInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddPetInfoServlet() {
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
		//获得数据
		String p_operator = request.getParameter("operator");
		String p_user = request.getParameter("user");
		String p_tel = request.getParameter("tel");
		String p_type = request.getParameter("pettype");
		String p_pet = request.getParameter("pets");
		String p_combo = request.getParameter("combo");
		Double p_price1 = Double.parseDouble(request.getParameter("price1"));
		String p_other = request.getParameter("other");
		Double p_price2 = Double.parseDouble(request.getParameter("price2"));
		String p_notes = request.getParameter("notes");
		String p_time = request.getParameter("time");
		//价格
		System.out.println(p_combo+p_price1+"元");
		System.out.println(p_other+p_price2+"元");
		List<Part> list = (List<Part>) request.getParts();
		//上传
		String cd = list.get(13).getHeader("Content-Disposition");
		//截取不同类型的文件需要自行判断
		  String p_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
		  System.out.println(p_filename);
		   if(!p_filename.equals("")){
              	 String url="C:\\liangzhy\\Uplode\\pet\\";
              	 String path=url+p_filename;
              	 File f = new File(path);
              	 //将文件写入本地
              	list.get(13).write(f.getAbsolutePath());
              	 //存到数具库中，存文件的名字
          }
		AddPetInfoDao Dao = new  AddPetInfoDao();
		//没完成订单是1
		Integer p_sign = 1;
		boolean flag = Dao.insertPetInfoNoUserid(p_operator,p_user, p_tel, p_type, p_pet, p_combo, p_price1, p_other, p_price2, p_notes, p_time, p_sign,p_filename);
		if(flag){
				String a = URLEncoder.encode("添加成功！", "UTF-8");  
		        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryPetInfoServlet'</script>");
			}
		else{
			String a = URLEncoder.encode("添加失败！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='addpetinfo.jsp'</script>");
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
