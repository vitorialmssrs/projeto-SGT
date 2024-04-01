package modelo;

import java.sql.Date;
import java.sql.Time;

public class LimpezaEspacos {
	
	private int idlimpeza;
	private String tipolimpeza;
	private Time horarioinicio;
	private Time horariofinal;
	private Date dia;
	
	
	public int getIdlimpeza() {
		return idlimpeza;
	}
	public void setIdlimpeza(int idlimpeza) {
		this.idlimpeza = idlimpeza;
	}
	public String getTipolimpeza() {
		return tipolimpeza;
	}
	public void setTipolimpeza(String tipolimpeza) {
		this.tipolimpeza = tipolimpeza;
	}
	public Time getHorarioinicio() {
		return horarioinicio;
	}
	public void setHorarioinicio(Time horarioinicio) {
		this.horarioinicio = horarioinicio;
	}
	public Time getHorariofinal() {
		return horariofinal;
	}
	public void setHorariofinal(Time horariofinal) {
		this.horariofinal = horariofinal;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	
	

}
