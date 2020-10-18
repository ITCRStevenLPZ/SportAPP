package com.sportapp.databases;

import java.sql.Date;

public class Cooper {
	int ID;
	int distancia;
	String resultado;
	Date fecha;
	
	public Cooper() {
	
	}

	public Cooper(int iD, int distancia, String resultado, Date fecha) {
		super();
		ID = iD;
		this.distancia = distancia;
		this.resultado = resultado;
		this.fecha = fecha;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
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
