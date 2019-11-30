package com.gimnasio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gimnasio.entities.Monitor;
import com.gimnasio.entities.Socio;
import com.gimnasio.model.MonitorDAO;
import com.gimnasio.model.SocioDAO;
import com.gimnasio.util.ExceptionInvalidUser;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession misession;
		misession = request.getSession(true);
		String tipoUsuario = request.getParameter("tipo_usuario");
		String usuario = request.getParameter("documento");
		String clave = request.getParameter("clave");

		if (tipoUsuario.equals("SOCIO")) {
			SocioDAO socioDao = new SocioDAO();
			Socio socio = socioDao.find(Integer.parseInt(usuario));

			if (socio != null) {// if user exist

				try {
					if (!socio.getClave().equals(clave)) {// if user pass don't match correctly (local pass with
															// database pass)
						throw new ExceptionInvalidUser("Usuario o Clave Incorrecta");
					}
				
					misession.setAttribute("socio", socio);
					misession.setAttribute("rol_user", 1);
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				} catch (ExceptionInvalidUser e) {
					
					misession.setAttribute("fail_login", e.getMessage());
					response.sendRedirect(request.getContextPath() + "/Login.jsp");
				}

			} else {
				System.out.println("no existe");
				response.sendRedirect(request.getContextPath() + "/index.jsp");
			}

		} else if (tipoUsuario.equals("MONITOR")) {

		} else if (tipoUsuario.equals("ADMINISTRADOR")) {

		}
		// response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
