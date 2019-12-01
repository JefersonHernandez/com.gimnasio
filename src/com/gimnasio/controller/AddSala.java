package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.Sala;
import com.gimnasio.model.SalaDAO;
import com.gimnasio.model.TipoSalaDAO;

/**
 * Servlet implementation class AddSala
 */
@WebServlet("/AddSala")
public class AddSala extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSala() {
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
		SalaDAO salaDao= new SalaDAO();
		TipoSalaDAO tipo = new TipoSalaDAO();
		Sala sala = new Sala();
		sala.setMetrosCuadrados(request.getParameter("metros"));
		sala.setUbicacion(request.getParameter("ubicacion"));
		sala.setTipoSalaBean(tipo.find(Integer.parseInt(request.getParameter("tipo_sala"))));
		salaDao.insert(sala);
		response.sendRedirect(request.getContextPath()+"/SalaList.jsp");
	}

}
