package com.gimnasio.test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.gimnasio.entities.Administradores;
import com.gimnasio.entities.Aparato;
import com.gimnasio.entities.AparatoEstado;
import com.gimnasio.entities.Asiste;
import com.gimnasio.entities.AsistePK;
//import com.gimnasio.entities.Asiste;
//import com.gimnasio.entities.AsistePK;
import com.gimnasio.entities.Clase;
import com.gimnasio.entities.Monitor;
import com.gimnasio.entities.PistaEstado;
import com.gimnasio.entities.PistaSquash;
import com.gimnasio.entities.Preparacion;
import com.gimnasio.entities.Reserva;
import com.gimnasio.entities.ReservaPK;
import com.gimnasio.entities.Sala;
import com.gimnasio.entities.Socio;
import com.gimnasio.entities.TipoSala;
import com.gimnasio.model.AdministradoresDAO;
import com.gimnasio.model.AparatoDAO;
import com.gimnasio.model.AparatoEstadoDAO;
import com.gimnasio.model.AsisteDAO;
//import com.gimnasio.model.AsisteDAO;
import com.gimnasio.model.ClaseDAO;
import com.gimnasio.model.MonitorDAO;
import com.gimnasio.model.PistaEstadoDAO;
import com.gimnasio.model.PistaSquashDAO;
import com.gimnasio.model.PreparacionDAO;
import com.gimnasio.model.ReservaDAO;
import com.gimnasio.model.SalaDAO;
import com.gimnasio.model.SocioDAO;
import com.gimnasio.model.TipoSalaDAO;

public class InitDataBase {

	public static void main(String args[]) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

		AparatoEstado aparatos[] = new AparatoEstado[3];

		aparatos[0] = new AparatoEstado();
		aparatos[1] = new AparatoEstado();
		aparatos[2] = new AparatoEstado();

		aparatos[0].setDescripcion("Averiado");
		aparatos[1].setDescripcion("Reparacion");
		aparatos[2].setDescripcion("Buen Estado");

		AparatoEstadoDAO dao = new AparatoEstadoDAO();

		for (AparatoEstado aparatoEstado : aparatos) {
			dao.insert(aparatoEstado);
		}

		TipoSala tipoSala[] = new TipoSala[3];

		tipoSala[0] = new TipoSala();
		tipoSala[1] = new TipoSala();
		tipoSala[2] = new TipoSala();

		tipoSala[0].setDescripcion("Cardio");
		tipoSala[1].setDescripcion("General");
		tipoSala[2].setDescripcion("Muscular");

		TipoSalaDAO tdao = new TipoSalaDAO();

		for (TipoSala tipoSala2 : tipoSala) {
			tdao.insert(tipoSala2);
		}

		// sala
		SalaDAO sdao = new SalaDAO();
		Sala salas[] = new Sala[3];

		salas[0] = new Sala();
		salas[1] = new Sala();
		salas[2] = new Sala();

		salas[0].setMetrosCuadrados("4 Metros");
		salas[0].setUbicacion("ubicacion");
		salas[0].setTipoSalaBean(tdao.find(tipoSala[0].getCodigo()));

		salas[1].setMetrosCuadrados("4.5 Metros");
		salas[1].setUbicacion("ubicacion");
		salas[1].setTipoSalaBean(tdao.find(tipoSala[1].getCodigo()));

		salas[2].setMetrosCuadrados("3 Metros");
		salas[2].setUbicacion("ubicacion");
		salas[2].setTipoSalaBean(tdao.find(tipoSala[2].getCodigo()));

		for (Sala sala : salas) {
			sdao.insert(sala);
		}

		// insert aparato
		AparatoDAO aptd = new AparatoDAO();
		Aparato apt[] = new Aparato[3];

		apt[0] = new Aparato();
		apt[1] = new Aparato();
		apt[2] = new Aparato();

		apt[0].setDescripcion("Mancuerna");
		apt[0].setAparatoEstado(dao.find(aparatos[2].getCodigo()));
		apt[0].setSala(sdao.find(salas[0].getNumero()));

		apt[1].setDescripcion("Barra");
		apt[1].setAparatoEstado(dao.find(aparatos[2].getCodigo()));
		apt[1].setSala(sdao.find(salas[1].getNumero()));

		apt[2].setDescripcion("Press");
		apt[2].setAparatoEstado(dao.find(aparatos[0].getCodigo()));
		apt[2].setSala(sdao.find(salas[2].getNumero()));

		for (Aparato aparato : apt) {
			aptd.insert(aparato);
		}

		// insert monitor
		MonitorDAO mdao = new MonitorDAO();
		Monitor monitores[] = new Monitor[3];

		monitores[0] = new Monitor();
		monitores[1] = new Monitor();
		monitores[2] = new Monitor();

		monitores[0].setCodigo("1151553");
		monitores[0].setExperiencia("2 años");
		monitores[0].setNombre("Jeferson");
		monitores[0].setTelefono("32113877");
		monitores[0].setTitulo("Masajista");
		monitores[0].setClave("0000");

		monitores[1].setCodigo("1094");
		monitores[1].setExperiencia("1 años");
		monitores[1].setNombre("Leonard");
		monitores[1].setTelefono("6584845");
		monitores[1].setTitulo("Nutricionista");
		monitores[1].setClave("0000");

		monitores[2].setCodigo("65974");
		monitores[2].setExperiencia("5 años");
		monitores[2].setNombre("Henry");
		monitores[2].setTelefono("03798545");
		monitores[2].setTitulo("Coach");
		monitores[2].setClave("0000");

		for (Monitor monitor : monitores) {
			mdao.insert(monitor);
		}

		// insert socio
		SocioDAO sociodao = new SocioDAO();
		Socio socios[] = new Socio[3];

		socios[0] = new Socio();
		socios[1] = new Socio();
		socios[2] = new Socio();

		socios[0].setNombre("Danilo");
		socios[0].setDireccion("toledo");
		socios[0].setTelefono("656555");
		socios[0].setProfesion("Abogado");
		socios[0].setDatosBancarios("bancolombia");
		socios[0].setClave("0000");

		socios[1].setNombre("Richard");
		socios[1].setDireccion("villa del rosario");
		socios[1].setTelefono("544554");
		socios[1].setProfesion("Ingeniero");
		socios[1].setDatosBancarios("av villas");
		socios[1].setClave("0000");

		socios[2].setNombre("Steven");
		socios[2].setDireccion("china town");
		socios[2].setTelefono("695478");
		socios[2].setProfesion("Musico");
		socios[2].setDatosBancarios("banco popular");
		socios[2].setClave("0000");

		for (Socio socio : socios) {
			sociodao.insert(socio);
		}

		// insert EstadoPista
		PistaEstadoDAO pdao = new PistaEstadoDAO();
		PistaEstado estadoPista[] = new PistaEstado[3];

		estadoPista[0] = new PistaEstado();
		estadoPista[1] = new PistaEstado();
		estadoPista[2] = new PistaEstado();

		estadoPista[0].setDescripcion("Disponible");
		estadoPista[1].setDescripcion("Ocupada");
		estadoPista[2].setDescripcion("En Mantenimiento");

		for (PistaEstado pistaEstado : estadoPista) {
			pdao.insert(pistaEstado);
		}

		// insert PistaSquash
		PistaSquashDAO psdao = new PistaSquashDAO();
		PistaSquash pistas[] = new PistaSquash[3];

		pistas[0] = new PistaSquash();
		pistas[1] = new PistaSquash();
		pistas[2] = new PistaSquash();

		pistas[0].setDescripcion("Pista A");
		pistas[0].setPistaEstadoBean(pdao.find(estadoPista[1].getCodigo()));

		pistas[1].setDescripcion("Pista B");
		pistas[1].setPistaEstadoBean(pdao.find(estadoPista[1].getCodigo()));

		pistas[2].setDescripcion("Pista B");
		pistas[2].setPistaEstadoBean(pdao.find(estadoPista[2].getCodigo()));

		for (PistaSquash pistaSquash : pistas) {
			psdao.insert(pistaSquash);
		}

		// insert Preparacion
		PreparacionDAO predao = new PreparacionDAO();
		Preparacion preparaciones[] = new Preparacion[3];

		preparaciones[0] = new Preparacion();
		preparaciones[1] = new Preparacion();
		preparaciones[2] = new Preparacion();

		preparaciones[0].setDescripcion("Masaje");
		preparaciones[1].setDescripcion("Coach Training");
		preparaciones[2].setDescripcion("Nutricionista");

		for (Preparacion preparacion : preparaciones) {
			predao.insert(preparacion);
		}

		// insert Clase
		ClaseDAO cdao = new ClaseDAO();
		Clase clases[] = new Clase[3];

		clases[0] = new Clase();
		clases[1] = new Clase();
		clases[2] = new Clase();

		clases[0].setSala(sdao.find(salas[0].getNumero()));
		clases[0].setMonitor(mdao.find(monitores[0].getCodigo()));
		clases[0].setPreparacion(predao.find(preparaciones[0].getCodigo()));
		clases[0].setHora(new Time(30, 20, 10));

		clases[1].setSala(sdao.find(salas[1].getNumero()));
		clases[1].setMonitor(mdao.find(monitores[1].getCodigo()));
		clases[1].setPreparacion(predao.find(preparaciones[1].getCodigo()));
		clases[1].setHora(new Time(30, 20, 10));

		clases[2].setSala(sdao.find(salas[2].getNumero()));
		clases[2].setMonitor(mdao.find(monitores[2].getCodigo()));
		clases[2].setPreparacion(predao.find(preparaciones[2].getCodigo()));
		clases[2].setHora(new Time(30, 20, 10));

		try {
			clases[0].setDia(sd.parse("2019-02-12"));
			clases[1].setDia(sd.parse("2019-01-20"));
			clases[2].setDia(sd.parse("2019-05-15"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Clase clase : clases) {
			cdao.insert(clase);
		}
		/*
		 * // insert Asiste AsisteDAO asistedao = new AsisteDAO(); Asiste asiste[] = new
		 * Asiste[3];
		 * 
		 * asiste[0] = new Asiste(); asiste[1] = new Asiste(); asiste[2] = new Asiste();
		 * 
		 * AsistePK aspk0 = new AsistePK();
		 * aspk0.setCodigoClase(cdao.find(clases[0].getCodigo()).getCodigo());
		 * aspk0.setNumeroSocio(sociodao.find(socios[0].getNumero()).getNumero());
		 * 
		 * AsistePK aspk1 = new AsistePK();
		 * aspk1.setCodigoClase(cdao.find(clases[1].getCodigo()).getCodigo());
		 * aspk1.setNumeroSocio(sociodao.find(socios[1].getNumero()).getNumero());
		 * 
		 * AsistePK aspk2 = new AsistePK();
		 * aspk2.setCodigoClase(cdao.find(clases[2].getCodigo()).getCodigo());
		 * aspk2.setNumeroSocio(sociodao.find(socios[2].getNumero()).getNumero());
		 * 
		 * asiste[0].setId(aspk0); asiste[1].setId(aspk1); asiste[2].setId(aspk2);
		 * 
		 * for (Asiste asiste2 : asiste) { asistedao.insert(asiste2); }
		 */
		// insert Reserva
		ReservaDAO reservaDao = new ReservaDAO();
		Reserva reservas[] = new Reserva[3];

		reservas[0] = new Reserva();
		reservas[1] = new Reserva();
		reservas[2] = new Reserva();

		ReservaPK rspk0 = new ReservaPK();
		ReservaPK rspk1 = new ReservaPK();
		ReservaPK rspk2 = new ReservaPK();

		reservas[0].setSocio(sociodao.find(socios[0].getNumero()));
		reservas[0].setPistaSquash(psdao.find(pistas[0].getNumero()));
		reservas[0].setHora(new Time(30, 20, 10));

		reservas[1].setSocio(sociodao.find(socios[1].getNumero()));
		reservas[1].setPistaSquash(psdao.find(pistas[1].getNumero()));
		reservas[1].setHora(new Time(25, 20, 10));

		reservas[2].setSocio(sociodao.find(socios[1].getNumero()));
		reservas[2].setPistaSquash(psdao.find(pistas[1].getNumero()));
		reservas[2].setHora(new Time(40, 20, 10));

		rspk0.setNumeroSocio(sociodao.find(socios[0].getNumero()).getNumero());
		rspk0.setNumeroPista(psdao.find(pistas[0].getNumero()).getNumero());
		rspk1.setNumeroSocio(sociodao.find(socios[1].getNumero()).getNumero());
		rspk1.setNumeroPista(psdao.find(pistas[1].getNumero()).getNumero());
		rspk2.setNumeroSocio(sociodao.find(socios[2].getNumero()).getNumero());
		rspk2.setNumeroPista(psdao.find(pistas[2].getNumero()).getNumero());

		reservas[0].setId(rspk0);
		reservas[1].setId(rspk1);
		reservas[2].setId(rspk2);

		try {
			reservas[0].setFecha(sd.parse("2019-02-9"));
			reservas[1].setFecha(sd.parse("2019-01-10"));
			reservas[2].setFecha(sd.parse("2019-02-11"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Reserva reserva : reservas) {
			reservaDao.insert(reserva);
		}

		// insert to ASISTE
		// socios[0].addClase(clases[0]);
		// clases[0].addSocio(socios[0]);
		AsisteDAO asd = new AsisteDAO();
		Asiste as = new Asiste();
		Asiste as2 = new Asiste();
		Asiste as3 = new Asiste();
		AsistePK aspk = new AsistePK();
		AsistePK aspk2 = new AsistePK();
		AsistePK aspk3 = new AsistePK();
		
		aspk.setFkClase(clases[0].getCodigo());
		aspk.setFkSocio(socios[0].getNumero());
		aspk2.setFkClase(clases[0].getCodigo());
		aspk2.setFkSocio(socios[1].getNumero());
		aspk3.setFkClase(clases[1].getCodigo());
		aspk3.setFkSocio(socios[0].getNumero());
		
		as.setId(aspk);
		as2.setId(aspk2);
		as3.setId(aspk3);
		
		asd.insert(as);		
		asd.insert(as2);
		asd.insert(as3);
		//asd.delete(asd.find(aspk));
		
		Administradores admin = new Administradores();
		
		admin.setNombre("Admin #1");
		admin.setClave("admin");
		admin.setCodigo("admin");
		AdministradoresDAO adminDao = new AdministradoresDAO();
		adminDao.insert(admin);
	}

	

}
