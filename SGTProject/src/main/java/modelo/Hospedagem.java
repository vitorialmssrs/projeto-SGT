package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Hospedagem {
	
	private Integer numQuarto;
	private LocalDate checkindata;
	private LocalTime checkinhora;
	private LocalDate checkoutdata;
	private LocalTime checkouthora;
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public LocalDate getCheckindata() {
		return checkindata;
	}
	public void setCheckindata(LocalDate checkindata) {
		this.checkindata = checkindata;
	}
	public LocalTime getCheckinhora() {
		return checkinhora;
	}
	public void setCheckinhora(LocalTime checkinhora) {
		this.checkinhora = checkinhora;
	}
	public LocalDate getCheckoutdata() {
		return checkoutdata;
	}
	public void setCheckoutdata(LocalDate checkoutdata) {
		this.checkoutdata = checkoutdata;
	}
	public LocalTime getCheckouthora() {
		return checkouthora;
	}
	public void setCheckouthora(LocalTime checkouthora) {
		this.checkouthora = checkouthora;
	}

	
}
