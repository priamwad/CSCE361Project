package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.notesBean;
import model.notesDB;
import model.userBean;

/**
 * Servlet implementation class addNotesServlet
 */
public class addNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNotesServlet() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noteTitle = request.getParameter("noteTitle");
		String noteClass = request.getParameter("noteClass");
		String noteDate = request.getParameter("noteDate");
		String noteContent = request.getParameter("noteContent");
		
		HttpSession session =request.getSession(false); 	
        userBean ub = (userBean) session.getAttribute("user");
        String userName = ub.getUserName();
        notesDB NDB = new notesDB();
        PrintWriter out = response.getWriter();
        out.println(userName);
        
        
        HttpSession session2 =request.getSession(false); 
        ArrayList<notesBean> nbList = nbList = (ArrayList<notesBean>) session2.getAttribute("nbList");
        notesBean nb = new notesBean(userName,noteTitle,noteClass,noteDate,noteContent);
        nbList.add(nb);
        try {
			NDB.insertNoteToTheDataBase(userName, noteTitle, noteClass, noteDate, noteContent);
			response.sendRedirect("homePage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

}
