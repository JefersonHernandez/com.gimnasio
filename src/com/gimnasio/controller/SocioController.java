package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.Socio;
import com.gimnasio.model.SocioDAO;

/**
 * Servlet implementation class SocioController
 */
@WebServlet("/SocioController")
public class SocioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocioController() {
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
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		if(method.equals("POST")) {
			SocioDAO sDao = new SocioDAO();
			Socio s = new Socio();
			s.setNombre(request.getParameter("nombre"));
			s.setDireccion(request.getParameter("direccion"));
			s.setDatosBancarios(request.getParameter("banco"));
			s.setProfesion(request.getParameter("profesion"));
			s.setClave(request.getParameter("clave"));
			s.setTelefono(request.getParameter("telefono"));
			sDao.insert(s);
			
		}else if(method.equals("DELETE")) {
			doDelete(request, response);
		}
			//doGet(request, response);
		response.sendRedirect(request.getContextPath()+"/SocioList.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SocioDAO sDao = new SocioDAO();
		sDao.delete(sDao.find(Integer.parseInt(request.getParameter("socio_codigo"))));
		//response.sendRedirect(request.getContextPath()+"/SocioList.jsp");
	}

}
