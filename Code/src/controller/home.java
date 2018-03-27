package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public home() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession(false); 	
        String userName = (String) session.getAttribute("ub");
		request.setAttribute("ub2",userName); 
		request.getRequestDispatcher("index.jsp").forward(request, response); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
