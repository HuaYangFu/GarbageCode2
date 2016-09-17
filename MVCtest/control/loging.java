package com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.userbeanC;

/**
 * Servlet implementation class loging
 */
@WebServlet("/loging")
public class loging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loging() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String u = request.getParameter("username");
		String p = request.getParameter("passwd");
		int pageSize = 5; //一頁顯示幾條記錄
		int pageNow = 1; //希望顯示第幾頁
		
		
		userbeanC userbeanC = new userbeanC();
		if(userbeanC.checkUser(u, p)){
	
			
			int pagecount = userbeanC.getpageCoint();
			
			ArrayList al = userbeanC.getresult(pageSize, pageNow);
			request.setAttribute("pageNow",pageNow+"");
			request.setAttribute("result",al);
			request.setAttribute("pagecount",pagecount+"");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("loging.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
