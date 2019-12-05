package com.gimnasio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.Monitor;
import com.gimnasio.model.MonitorDAO;

/**
 * Servlet implementation class MonitorController
 */
@WebServlet("/MonitorController")
public class MonitorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonitorController() {
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
		String method = request.getParameter("method");
		if (method.equals("POST")) {
			MonitorDAO mDao = new MonitorDAO();
			Monitor m = new Monitor();
			m.setCodigo(request.getParameter("codigo"));
			m.setNombre(request.getParameter("nombre"));
			m.setExperiencia(request.getParameter("experiencia"));
			m.setTelefono(request.getParameter("telefono"));
			m.setTitulo(request.getParameter("titulo"));
			m.setClave(request.getParameter("clave"));
			mDao.insert(m);
		}else if(method.equals("DELETE")){
			doDelete(request, response);
		}
		//doGet(request, response);
		response.sendRedirect(request.getContextPath()+"/MonitorList.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MonitorDAO mDao = new MonitorDAO();
		mDao.delete(mDao.find(request.getParameter("codigo_monitor")));
		//response.sendRedirect(request.getContextPath()+"/MonitorList.jsp");
	}

}
