package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		
		//ClaseDAO clase = new ClaseDAO();
		//clase.delete(clase.find(Integer.parseInt(request.getParameter("codigo"))));
		
		AsisteDAO asisteDao = new AsisteDAO();
		Asiste asiste = new Asiste();
		AsistePK asistePk = new AsistePK();
		SocioDAO socioDao = new SocioDAO();
		ClaseDAO claseDao = new ClaseDAO();
		
		Clase clase = new Clase();
		Socio ss = new Socio();
		
		clase.setCodigo(Integer.parseInt(request.getParameter("codigo_clase")));
		ss.setNumero(Integer.parseInt(request.getParameter("codigo_user")));
		
		clase = claseDao.find(clase.getCodigo());
		ss = socioDao.find(ss.getNumero());
	
		System.out.print(ss.getClave());
		asiste.setSocio(ss);
		asiste.setClase(clase);
		//asistePk.setCodigoClase(asiste.getSocio().getNumero());
		//asistePk.setNumeroSocio(asiste.getClase().getCodigo());
		//asiste.setId(asistePk);
		asisteDao.delete(asiste);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
