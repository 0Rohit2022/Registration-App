package com.regapp_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.regapp_model.DAOService;
import com.regapp_model.DOAService;

@WebServlet("/register")
public class new_registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public new_registration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/User_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession(false);
				session.setMaxInactiveInterval(10);
				if(session.getAttribute("email")!= null) {
				
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone_no = request.getParameter("phone_no");
				String address = request.getParameter("address");
				
				DAOService service = new DOAService();
				service.ConnectDB();
				service.saveRegistration(name, phone_no, email, address);
				
				request.setAttribute("inserted", "Data Inserted");
				request.setAttribute("sign", "Sign-Up");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/User_registration.jsp");
				rd.forward(request, response);
				}else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.forward(request, response);
				}
			
		
	}

}
