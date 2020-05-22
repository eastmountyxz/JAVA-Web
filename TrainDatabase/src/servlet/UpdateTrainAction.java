package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TrainManageDAO;
import bean.TrainManage;

public class UpdateTrainAction extends HttpServlet {

	public UpdateTrainAction() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	//The doGet method of the servlet.
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	//The doPost method of the servlet
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8"); //设置输出编码  
	    request.setCharacterEncoding("UTF-8");  
		
		try {
			//更新数据库
			String m_trainid = request.getParameter("trainid");
			String m_start = request.getParameter("start");
			String m_end = request.getParameter("end");
			String m_time = request.getParameter("time");
			String m_yz = request.getParameter("yzprice");
			Float m_yzprice = Float.parseFloat(m_yz);
			String m_rz = request.getParameter("rzprice");
			Float m_rzprice = Float.parseFloat(m_rz);
			String m_yw = request.getParameter("ywprice");
			Float m_ywprice = Float.parseFloat(m_yw);
			String m_rw = request.getParameter("rwprice");
			Float m_rwprice = Float.parseFloat(m_rw);
			String m_root = request.getParameter("root");
				
			TrainManage train = new TrainManage();
			train.setTrainid(m_trainid);
			train.setStart(m_start);
			train.setEnd(m_end);
			train.setTime(m_time);
			train.setYzprice(m_yzprice);
			train.setRzprice(m_rzprice);
			train.setYwprice(m_ywprice);
			train.setRwprice(m_rwprice);
			train.setRoot(m_root);
			  
		    int success  = TrainManageDAO.update(train);  
			request.setAttribute("success", success);  
			//设置全路径 否则trainManage.jsp跳转到servlet/trainManage.jsp路径下不存在
		    response.sendRedirect("http://localhost:8080/TrainDatabase/trainManage.jsp");  
		    
		} catch(Exception e) {
			System.out.println("错误："+e.getMessage());  
            response.sendRedirect("http://localhost:8080/TrainDatabase/trainManage.jsp");  
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
