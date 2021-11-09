package com.mini_project.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mini_project.model.ClassDAOImpl;

@WebServlet("/newReg")
public class WelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WelcomeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/welcome.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {doGet(request, response);
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		try {
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
			ClassDAOImpl dao = new ClassDAOImpl();

			dao.connectDB();

			dao.newRegistration(name, city, email, mobile);

			request.setAttribute("newRegMsg", "Record is saved!!");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/welcome.jsp");
			rd.include(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
