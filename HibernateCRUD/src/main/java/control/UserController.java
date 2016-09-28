package control;

/**
 * Created by 傅華暘 on 2016/9/26.
 */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import org.apache.log4j.Logger;

import util.HibernateUtil;
import model.User;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        dao = new UserDao();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            request.setAttribute("users", dao.getAllUsers());
            request.getRequestDispatcher("showall.jsp").forward(request, response);
        }

        else if (action.equalsIgnoreCase("edit")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            User user = dao.getUserById(userId);
            request.setAttribute("user", user);
            request.setAttribute("users", dao.getAllUsers());
            request.getRequestDispatcher("showall.jsp").forward(request, response);
        }

        else if (action.equalsIgnoreCase("showAll")){
            request.setAttribute("users", dao.getAllUsers());
            request.getRequestDispatcher("showall.jsp").forward(request, response);
        }

        else if(action.equalsIgnoreCase("insert")){
            request.getRequestDispatcher("showall.jsp").forward(request, response);
        }

        else{
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            User user = new User();
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            try {
                Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dob"));
                user.setDob(dob);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setEmail(request.getParameter("email"));
            String userid = request.getParameter("userid");
            if (userid == null || userid.isEmpty()) {
                dao.addUser(user);
            } else {
                user.setUserid(Integer.parseInt(userid));
                dao.updateUser(user);
            }
            request.setAttribute("users", dao.getAllUsers());
            request.getRequestDispatcher("showall.jsp").forward(request, response);
        }
    }


