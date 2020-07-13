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
import com.Dao.AddFeederInfoDao;
//打注解
@MultipartConfig
public class AddFeederInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddFeederInfoServlet() {
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
		String f_number = request.getParameter("number");
		String f_name = request.getParameter("fname");
		String f_sex = request.getParameter("sex");
		String f_idcard = request.getParameter("idcard");
		String f_tel = request.getParameter("tel");
		String f_address = request.getParameter("address");
		String f_notes = request.getParameter("notes");
		System.out.println("用户输入的用户名为："+f_name);
		
		List<Part> list = (List<Part>) request.getParts();
		/*for (Part p : list) {
            // 获取上传的文件名称
			String cd = p.getHeader("Content-Disposition");
			//截取不同类型的文件需要自行判断
			  String f_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
            //String filename = p.getSubmittedFileName();
            System.out.println(f_filename);
            // 创建要保存的文件对象
            if(!f_filename.equals("")){
              	 String url="H:\\Uplode\\";
              	 String path=url+f_filename;
              	 File f = new File(path);
              	 //将文件写入本地
              	 p.write(f.getAbsolutePath());
              	 //存到数具库中，存文件的名字
              
          }
            
	}*/
		
			String cd = list.get(7).getHeader("Content-Disposition");
			//截取不同类型的文件需要自行判断
			  String f_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
			  System.out.println(f_filename);
			   if(!f_filename.equals("")){
	              	 String url="C:\\liangzhy\\Uplode\\feeder\\";
	              	 String path=url+f_filename;
	              	 File f = new File(path);
	              	 //将文件写入本地
	              	list.get(7).write(f.getAbsolutePath());
	              	 //存到数具库中，存文件的名字
	              
	          }
			  
		
		
	
	AddFeederInfoDao Dao = new  AddFeederInfoDao();
	boolean flag = Dao.addfeederinfo(f_number, f_name, f_sex, f_idcard, f_tel, f_address, f_notes, f_filename);
	if(flag){
		String a = URLEncoder.encode("添加成功！", "UTF-8");  
       out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryFeederInfoServlet'</script>");
      }
	else{
		String a = URLEncoder.encode("添加失败！", "UTF-8");  
       out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href=''</script>");
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
