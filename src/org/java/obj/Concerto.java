package org.java.obj;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import org.java.abs.Event;

public class Concerto extends Event{
	private LocalTime hour;
	private BigDecimal price;
	
	public Concerto(String title, LocalDate date, int maxSeats, LocalTime hour, BigDecimal price) throws Exception {
		super(title, date, maxSeats);
		setHour(hour);
		setPrice(price);
	}

	public LocalTime getHour() {
		return hour;
	}
	public void setHour(LocalTime hour) {
		this.hour = hour;
	}
	public String getFormattedHour() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return hour.format(formatter);
	}

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getFormattedPrice() {
		try (Formatter formatter = new Formatter()) {
			formatter.format("%.2f", price);
			return formatter.toString();
		}
			
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
	    String formattedDate = date.format(formatter).toUpperCase();
	    return "Data: " + formattedDate + " - Ora: " + getFormattedHour() 
	    + "\nNome: " + getTitle() 
	    + "\nPrezzo: " + getFormattedPrice();
		
	}
	
	

}
