package com.sportapp.databases;

import java.sql.Date;

public class Frecuencias {
	int ID;
	String descripcion;
	Date fecha;
	int frecuencia;
	public Frecuencias() {		
	}
	
	public Frecuencias(int iD, String descripcion, Date fecha, int frecuencia) {
		this.ID = iD;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.frecuencia = frecuencia;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
}
