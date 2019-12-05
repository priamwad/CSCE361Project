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


public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("d");
		notesDB NDB = new notesDB();
		try {
			NDB.deleteNote(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session =request.getSession(false); 	
        String userName = (String) session.getAttribute("ub");
		request.setAttribute("ub2",userName); 
		request.getRequestDispatcher("index.jsp").forward(request, response); 
	}


}
