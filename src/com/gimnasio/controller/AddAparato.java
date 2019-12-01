package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.Aparato;
import com.gimnasio.entities.AparatoEstado;
import com.gimnasio.model.AparatoDAO;
import com.gimnasio.model.AparatoEstadoDAO;
import com.gimnasio.model.SalaDAO;

/**
 * Servlet implementation class AddAparato
 */
@WebServlet("/AddAparato")
public class AddAparato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAparato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aparato aparato = new Aparato();
		AparatoDAO aparatoDao = new AparatoDAO();
		AparatoEstadoDAO aparatoEstadoDao = new AparatoEstadoDAO();
		SalaDAO salaDao = new SalaDAO();
		aparato.setDescripcion(request.getParameter("descripcion"));
		aparato.setAparatoEstado(aparatoEstadoDao.find(Integer.parseInt(request.getParameter("estado"))));
		aparato.setSala(salaDao.find(Integer.parseInt(request.getParameter("sala"))));
		aparatoDao.insert(aparato);
		response.sendRedirect(request.getContextPath()+"/AparatosList.jsp");
	}

}
