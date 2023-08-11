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
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String phone_no = request.getParameter("phone_no");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("phone_no", phone_no);
		request.setAttribute("address", address);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Update_registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			HttpSession session = request.getSession(false);
				session.setMaxInactiveInterval(10);
				if(session.getAttribute("email")!=null) {
			
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String phone_no = request.getParameter("phone_no");
				String address = request.getParameter("address");
				
				DAOService service = new DOAService();
				service.ConnectDB();
				service.update( name ,  email,  phone_no,  address);
				
				ResultSet result =  service.getAllReg();
				request.setAttribute("result", result);
				request.setAttribute("inserted", "Update User Registration");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
				rd.forward(request, response);
				}else
				{
					RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
					rd.forward(request, response);
				}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
