package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gimnasio.entities.Asiste;
import com.gimnasio.entities.AsistePK;
import com.gimnasio.entities.Socio;
import com.gimnasio.model.AsisteDAO;

/**
 * Servlet implementation class AddClaseSocio
 */
@WebServlet("/AddClaseSocio")
public class AddClaseSocio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClaseSocio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misession = request.getSession();
		Socio socio = (Socio)misession.getAttribute("socio");
		AsisteDAO asd = new AsisteDAO();
		Asiste as = new Asiste();
		AsistePK aspk = new AsistePK();
		aspk.setFkClase(Integer.parseInt(request.getParameter("codigo_clase")));
		aspk.setFkSocio(socio.getNumero());
		as.setId(aspk);
		asd.insert(as);
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
