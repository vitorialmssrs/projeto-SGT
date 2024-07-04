package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Hospedagem {

	private Integer numQuarto;
	/*
	 * private LocalDateTime checkin; private LocalDateTime checkout;
	 */
	// DataEntrada,DataSaida,HoraEntrada,HoraSaida
	private LocalDate DataEntrada;
	private LocalDate DataSaida;
	private LocalTime HoraEntrada;
	private LocalTime HoraSaida;
	private Hospede hospede;

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public LocalDate getDataEntrada() {
		return DataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		DataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return DataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		DataSaida = dataSaida;
	}

	public LocalTime getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public LocalTime getHoraSaida() {
		return HoraSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		HoraSaida = horaSaida;
	}

}
