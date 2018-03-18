package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.userBean;
import model.userDB;

@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registrationServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting data from the JSP pages
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// check if the user exists already, if not add to the database
		userDB user = new userDB();
		try {
			if (user.checkIfUserExist(userName)){
				response.sendRedirect("loginPage.jsp");
			}else {
				user.insertUserToTheDataBase(userName, password, email, fullName);
				response.sendRedirect("loginPage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
