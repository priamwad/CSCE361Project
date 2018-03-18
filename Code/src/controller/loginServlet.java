package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.notesBean;
import model.notesDB;
import model.userBean;
import model.userDB;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {
        super();  
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//grabbing data from jsp
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//Fetching user data from database for validation
		//Redirects the user to the appropriate links
		userDB user = new userDB();
		try {
			if(user.checkIfUserExist(userName) == true && user.checkIfUserPasswordExist(userName, password) == true){
				userBean ub = user.returnUserbyUserName(userName);
		       
				HttpSession session=request.getSession();  
		        session.setAttribute("user",ub);  
		        
		        HttpSession session2=request.getSession();  
		        ArrayList<notesBean> nbList = null;
		        notesDB NDB = new notesDB();
		        try {
		        	if(NDB.doesTheUserHaveAnyNotes(userName)){
		        		nbList = NDB.returnNotes(userName);	
		        		 session2.setAttribute("nbList",nbList);  
		        		 response.sendRedirect("homePage.jsp");
		        	}else {
		        		response.sendRedirect("homePage.jsp");
		        	}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (user.checkIfUserExist(userName) == true && user.checkIfUserPasswordExist(userName, password) == false){
				response.sendRedirect("loginPage.jsp");
			}else{
				response.sendRedirect("registrationPage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
