package com.gimnasio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gimnasio.entities.Asiste;
import com.gimnasio.entities.AsistePK;
import com.gimnasio.entities.Clase;
import com.gimnasio.entities.Socio;
import com.gimnasio.model.AsisteDAO;
import com.gimnasio.model.ClaseDAO;
import com.gimnasio.model.SocioDAO;

/**
 * Servlet implementation class DeleteClaseSocio
 */
@WebServlet("/DeleteClaseSocio")
public class DeleteClaseSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClaseSocio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession misession;
		misession = request.getSession(true);
		
		Socio socio = (Socio) misession.getAttribute("socio");
		ClaseDAO claseDao = new ClaseDAO();
		SocioDAO socioDao = new SocioDAO();
		AsisteDAO asisteDao = new AsisteDAO();
		Asiste asiste = new Asiste();
		AsistePK asistePk = new AsistePK();
		asistePk.setFkClase(claseDao.find(Integer.parseInt(request.getParameter("codigo_clase"))).getCodigo());
		asistePk.setFkSocio(socioDao.find(socio.getNumero()).getNumero());
		asiste.setId(asistePk);
		asisteDao.delete(asisteDao.find(asistePk));
		
		misession.removeAttribute("socio");
		//misession.setAttribute("socio", socioDao.find(socio.getNumero()));
		//misession.putValue("socio", socioDao.find(socio.getNumero()));
		//response.sendRedirect(request.getContextPath() + "/index.jsp");
		//RequestDispatcher r = getServletContext().getRequestDispatcher("/index.jsp");
		//r.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
