package modelo;

import java.time.LocalDateTime;

public class ReservaEspacos {

	private Integer idReservas;
	private LocalDateTime diahorario;
	
	public Integer getIdReservas() {
		return idReservas;
	}
	public void setIdReservas(Integer idReservas) {
		this.idReservas = idReservas;
	}
	public LocalDateTime getDiahorario() {
		return diahorario;
	}
	public void setDiahorario(LocalDateTime diahorario) {
		this.diahorario = diahorario;
	}
	
}
