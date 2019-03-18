package com.ecodeup.proyecto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Envio por request
		request.setAttribute("name1", request.getParameter("txtNombre"));
		
		//Envio por session
		request.getSession().setAttribute("nameSession", request.getParameter("txtNombre"));
		
		//Envio por context
		getServletContext().setAttribute("nameContext", request.getParameter("txtNombre"));
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("/Presentacion.jsp");
		dispatcher.forward(request, response);
	}

}
