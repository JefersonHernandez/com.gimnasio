package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.AparatoEstado;
import com.gimnasio.model.AparatoEstadoDAO;

/**
 * Servlet implementation class DeleteEstadoAparato
 */
@WebServlet("/DeleteEstadoAparato")
public class DeleteEstadoAparato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEstadoAparato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.print("hola"+request.getParameter("codigo")+"fin");
		
		AparatoEstadoDAO dao = new AparatoEstadoDAO();
		
		AparatoEstado ap = dao.find(Integer.parseInt(request.getParameter("codigo")));
		dao.delete(ap);
		response.sendRedirect(request.getContextPath()+"/EstadoAparatoList.jsp");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
