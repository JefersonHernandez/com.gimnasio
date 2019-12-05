package com.gimnasio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.model.SalaDAO;

/**
 * Servlet implementation class SalaController
 */
@WebServlet("/SalaController")
public class SalaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Aqui GET");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect(request.getContextPath()+"/SalaList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Aqui post");
		if(request.getParameter("method").equals("DELETE")) {
			doDelete(request, response);
		}
		//doGet(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaDAO salaDao= new SalaDAO();
		System.out.println("Aqui delete");
		try {
			salaDao.delete(salaDao.find(Integer.parseInt(request.getParameter("id_sala"))));
			response.sendRedirect(request.getContextPath()+"/SalaList.jsp");
			//doGet(request, response);
		} catch(Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage()+"asasasasasas");
		}
	}

}
