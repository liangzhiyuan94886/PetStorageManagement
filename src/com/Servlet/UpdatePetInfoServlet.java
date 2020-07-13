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

import com.Dao.UpdatePetInfoDao;
import com.Javabean.Pet_Info;
//打注解
@MultipartConfig
public class UpdatePetInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePetInfoServlet() {
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
	//	HttpSession session = request.getSession();
		//获取前端数据
		String p_operator = request.getParameter("operator");
		String p_id = request.getParameter("id");
		String p_user = request.getParameter("user");
		String p_tel  = request.getParameter("tel");
		String p_type  = request.getParameter("pettype");
		String p_pet  = request.getParameter("pets");
		String p_combo = request.getParameter("combo");
		Double p_price1 = Double.parseDouble(request.getParameter("price1"));
		String p_other = request.getParameter("other");
		Double p_price2 = Double.parseDouble(request.getParameter("price2"));
		String p_notes  = request.getParameter("notes");
		String p_time  = request.getParameter("time");
		System.out.println(p_combo+p_price1+p_other+p_price2);
		//上传图片文件
		List<Part> list = (List<Part>) request.getParts();
		String cd = list.get(14).getHeader("Content-Disposition");
		//截取不同类型的文件需要自行判断
		  String p_filename = cd.substring(cd.lastIndexOf("=")+2, cd.length()-1);
		  System.out.println(p_filename);
		  //判断文件是否为空
		   if(!p_filename.equals("")){{
              	 String url="C:\\liangzhy\\Uplode\\pet\\";
              	 String path=url+p_filename;
              	 File f = new File(path);
              	 //将文件写入本地
              	list.get(14).write(f.getAbsolutePath());
              	 //存到数具库中，存文件的名字
          }
		//将数据set到pi
		Pet_Info pi = new Pet_Info();
		pi.setP_operator(p_operator);
		pi.setP_id(Integer.parseInt(p_id));
		pi.setP_user(p_user);
		pi.setP_type(p_type);
		pi.setP_pet(p_pet);
		pi.setP_combo(p_combo);
		pi.setP_price1(p_price1);
		pi.setP_other(p_other);
		pi.setP_price2(p_price2);
		pi.setP_tel(p_tel);
		pi.setP_notes(p_notes);
		pi.setP_time(p_time);
		pi.setP_filename(p_filename);
		UpdatePetInfoDao dao = new UpdatePetInfoDao();
		boolean flag = dao.UpdatePetInfo(pi);
		if(flag){
			String a = URLEncoder.encode("修改成功！", "UTF-8");  
	        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryPetInfoServlet'</script>"); 
		}else{
			out.print("<script>alert('修改失败！');" + "window.location.href='updatepetinfo.jsp';</script>");
			}
		}
		//不更新图片的时候
		   else if(p_filename.equals("")){
			   Pet_Info pi = new Pet_Info();
				pi.setP_operator(p_operator);
				pi.setP_id(Integer.parseInt(p_id));
				pi.setP_user(p_user);
				pi.setP_type(p_type);
				pi.setP_pet(p_pet);
				pi.setP_combo(p_combo);
				pi.setP_price1(p_price1);
				pi.setP_other(p_other);
				pi.setP_price2(p_price2);
				pi.setP_tel(p_tel);
				pi.setP_notes(p_notes);
				pi.setP_time(p_time);
			//	pi.setP_filename(p_filename);
				UpdatePetInfoDao dao = new UpdatePetInfoDao();
				boolean flag = dao.UpdatePetInfoNoJPG(pi);
				if(flag){
					String a = URLEncoder.encode("修改成功！", "UTF-8");  
			        out.print("<script>alert(decodeURIComponent('"+a+"') );window.location.href='QueryPetInfoServlet'</script>"); 
				}else{
					out.print("<script>alert('修改失败！');" + "window.location.href='updatepetinfo.jsp';</script>");
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
