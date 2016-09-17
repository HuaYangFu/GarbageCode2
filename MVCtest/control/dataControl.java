package com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.userbeanC;

/**
 * Servlet implementation class dataControl
 */
@WebServlet("/dataControl")
public class dataControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dataControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);
			String flag = request.getParameter("flag");
			System.out.println(1);
//新增控制=====================================================================================================
			if(flag.equals("adduser")){
				System.out.println(1);
				userbeanC userbeanC = new userbeanC();
				System.out.println(2);
				int pagecount = userbeanC.getpageCoint();
				int pageSize = 5; //一頁顯示幾條記錄
				int pageNow = 1;
				System.out.println(3);
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String psw = request.getParameter("psw");
				userbeanC.adduser(id, name, psw);
				System.out.println(4);
				ArrayList al = userbeanC.getresult(pageSize, pageNow);
				System.out.println(5);
				request.setAttribute("result", al);
				request.setAttribute("pageNow",pageNow+"");
				request.setAttribute("pagecount",pagecount+"");
				System.out.println(6);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
//搜尋控制=====================================================================================================
			if(flag.equals("search")){
				userbeanC userbeanC = new userbeanC();
				
				int pagecount = userbeanC.getpageCoint();
				int pageSize = 5; //一頁顯示幾條記錄
				int pageNow = 1;
				
				String id = request.getParameter("id");
				
				ArrayList al = userbeanC.searchuser(id);
				
				request.setAttribute("result", al);
				request.setAttribute("pageNow",pageNow+"");
				request.setAttribute("pagecount",pagecount+"");
				
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}	
//修改控制=====================================================================================================
			if(flag.equals("edit")){
				userbeanC userbeanC = new userbeanC();
				
				int pagecount = userbeanC.getpageCoint();
				int pageSize = 5; //一頁顯示幾條記錄
				int pageNow = 1;
				
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String psw = request.getParameter("psw");
				userbeanC.edituser(id, name, psw);
				
				ArrayList al = userbeanC.getresult(pageSize, pageNow);
				
				request.setAttribute("result", al);
				request.setAttribute("pageNow",pageNow+"");
				request.setAttribute("pagecount",pagecount+"");
				
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
//刪除控制器==================================================================================================
			else if(flag.equals("delete")){
				
				userbeanC userbeanC = new userbeanC();
				
				int pagecount = userbeanC.getpageCoint();
				int pageSize = 5; //一頁顯示幾條記錄
				int pageNow = 1;
				
				String id = request.getParameter("id");
				
				userbeanC.deleteuser(id);
				
				ArrayList al = userbeanC.getresult(pageSize, pageNow);
				
				request.setAttribute("result", al);
				request.setAttribute("pageNow",pageNow+"");
				request.setAttribute("pagecount",pagecount+"");
				
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			}
//分頁控制器===================================================================================================
			else if(flag.equals("fenya")){
				
				userbeanC userbeanC = new userbeanC();
				
				int pagecount = userbeanC.getpageCoint();
				int pageSize = 5; //一頁顯示幾條記錄
				int pageNow = Integer.parseInt(request.getParameter("pageNow"));
				
				ArrayList al = userbeanC.getresult(pageSize, pageNow);
				
				request.setAttribute("result", al);
				request.setAttribute("pagecount",pagecount+"");
				request.setAttribute("pageNow",pageNow+"");
				
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
