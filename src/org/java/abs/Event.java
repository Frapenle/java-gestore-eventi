package org.java.abs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
	private String title;
	protected LocalDate date;
	private int maxSeats;
	private int reservedSeats;
	
	public Event(String title, LocalDate date, int maxSeats) throws Exception {
		setTitle(title);
		setDate(date);
		setMaxSeats(maxSeats);
		this.reservedSeats = 0;
	}
	public Event(String title, LocalDate date) throws Exception {
		// TODO Auto-generated constructor stub
		setTitle(title);
		setDate(date);
	}
	//	title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
//	date
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) throws Exception {
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("La data dell'evento non può essere nel passato.");
		}
		this.date = date;
	}
//	Seats
	public int getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(int maxSeats) throws Exception {
		if(maxSeats <= 0) {
			throw new Exception("Il numero di posti totali deve essere positivo");
		}
		if(maxSeats > 100000) {
			throw new Exception("Il numero di posti totali non deve superare i 100.000");
		}
		this.maxSeats = maxSeats;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}
//	book
	public int book(int seats) throws Exception {
		if (date.isBefore(LocalDate.now())) {
			throw new Exception ("Non puoi prenotare un evento già passato.");
		}
		
		if (reservedSeats >= maxSeats) {
			throw new Exception("I posti sono esauriti.");
		}
		return reservedSeats = reservedSeats + seats;
	}
//	cancel
	public int cancel(int seats) throws Exception{
		if (date.isBefore(LocalDate.now())) {
			throw new Exception("Non puoi disdire un evento passato.");
		}
		if(reservedSeats <= 0) {
			throw new Exception("Errore! Impossibile disdire. Non son presenti prenotazioni.");
		}
		return reservedSeats = reservedSeats - seats;
	}
	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
	    String formattedDate = date.format(formatter).toUpperCase();
	    return "Data: " + formattedDate + " - " + "Nome: " + getTitle();
	}
	
}
