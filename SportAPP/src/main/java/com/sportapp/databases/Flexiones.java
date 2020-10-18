package com.sportapp.databases;

import java.sql.Date;

public class Flexiones {
	int ID;
	int flexiones;
	String resultado;
	Date fecha;
	
	public Flexiones() {
		
	}
	


	public Flexiones(int iD, int flexiones, String resultado, Date fecha) {
		super();
		ID = iD;
		this.flexiones = flexiones;
		this.resultado = resultado;
		this.fecha = fecha;
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getFlexiones() {
		return flexiones;
	}

	public void setFlexiones(int flexiones) {
		this.flexiones = flexiones;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
