package com.mini_project.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_project.model.ClassDAOImpl;

@WebServlet("/deleteReg")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
			ClassDAOImpl dao = new ClassDAOImpl();
			dao.connectDB();
			dao.deleteRegistration(email);
			ResultSet result = dao.getAllregistrations();
			request.setAttribute("result", result);
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchResults.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
	}

}
