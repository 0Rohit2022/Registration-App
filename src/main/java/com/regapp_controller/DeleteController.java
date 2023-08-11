package com.regapp_controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp_model.DAOService;
import com.regapp_model.DOAService;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session = request.getSession(false);
	   session.setMaxInactiveInterval(10);
	   if(session.getAttribute("email")!= null) {
		String email = request.getParameter("email");
	   DAOService service = new DOAService();
	   service.ConnectDB();
	   service.DeleteByEmail(email);
	   
	   ResultSet result = service.getAllReg();
	   request.setAttribute("result", result);
	   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
	   rd.forward(request, response);
	   }else {
		   RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		   rd.forward(request, response);
	   }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
