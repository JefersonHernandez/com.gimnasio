package com.gimnasio.controller;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gimnasio.entities.Clase;
import com.gimnasio.model.ClaseDAO;
import com.gimnasio.model.MonitorDAO;
import com.gimnasio.model.PreparacionDAO;
import com.gimnasio.model.SalaDAO;

/**
 * Servlet implementation class ClaseController
 */
@WebServlet("/ClaseController")
public class ClaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClaseController() {
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
		// TODO Auto-generated method stub
		String method = request.getParameter("method");

		if (method.equals("POST")) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			ClaseDAO cDao = new ClaseDAO();
			SalaDAO sDao = new SalaDAO();
			MonitorDAO mDao = new MonitorDAO();
			PreparacionDAO pDao = new PreparacionDAO();
			Clase c = new Clase();
			c.setSala(sDao.find(Integer.parseInt(request.getParameter("sala"))));
			c.setMonitor(mDao.find(request.getParameter("monitor")));
			c.setPreparacion(pDao.find(Integer.parseInt(request.getParameter("preparacion"))));
			java.sql.Time myTime;

			try {
				String hh[] = request.getParameter("hora").split(":");
				int hora = Integer.parseInt(hh[0]);
				int min = Integer.parseInt(hh[1]);
				Time t = new Time(hora, min, 0);
				c.setHora(t);
				c.setDia(sd.parse(request.getParameter("dia")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cDao.insert(c);
		}else if(method.equals("DELETE")) {
			doDelete(request, response);
		}
		response.sendRedirect(request.getContextPath() + "/ClasesList.jsp");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClaseDAO cDao = new ClaseDAO();
		System.out.println(request.getParameter("clase"));
		cDao.delete(cDao.find(Integer.parseInt(request.getParameter("clase"))));
	}

}
