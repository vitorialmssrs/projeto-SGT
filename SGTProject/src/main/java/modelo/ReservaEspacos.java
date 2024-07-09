package modelo;

import java.time.LocalDateTime;

public class ReservaEspacos {

	private EspacoHotel reserva;
	private Integer cliente;
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
	public EspacoHotel getReserva() {
		return reserva;
	}
	public void setReserva(EspacoHotel reserva) {
		this.reserva = reserva;
	}
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer id) {
		this.cliente = id;
	}
	
	
}
