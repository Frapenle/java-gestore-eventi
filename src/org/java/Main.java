package org.java;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.java.abs.Event;
import org.java.obj.Concerto;
import org.java.obj.ProgramEvent;

public class Main {

	public static void main(String[] args) throws Exception {
		Concerto concerto = new Concerto("nome concerto", LocalDate.of(2030, 4, 30), 500, LocalTime.of(23, 0), new BigDecimal(23.58234324234));
		System.out.println(concerto);
		System.out.println("------------------");
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Inserisci il nome dell'evento: ");
		String title = sc.nextLine();
		
		System.out.println("Inserisci la data: ");
		String dateUser = sc.nextLine();
		LocalDate date = LocalDate.parse(dateUser, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.print("Numero di posti totali (max 100.000): ");
        int maxSeats = sc.nextInt();
        sc.nextLine();
        
        try {
            Event evento = new Event(title, date, maxSeats);
            System.out.println("Congratulazioni, hai appena creato il seguente evento: ");
            System.out.println(evento);
            System.out.println("------------------------");

            System.out.print("Desideri effettuare delle prenotazioni? (Si/No): ");
            String option = sc.nextLine();

            if (option.equalsIgnoreCase("si")) {
                System.out.print("Inserisci il numero di prenotazioni desiderate: ");
                int reservedSeats = sc.nextInt();
                sc.nextLine();
                try {
                        evento.book(reservedSeats);
                } catch (Exception e) {
                    System.err.println("Errore durante la prenotazione: " + e.getMessage());
                } 
                
            }
            System.out.println("Capienza massima: " + evento.getMaxSeats()
            				+ "\nPosti prenotati: " + evento.getReservedSeats()
            				+ "\nPosti disponibili: " + (evento.getMaxSeats() - evento.getReservedSeats()));
            System.out.println("------------------------");
            System.out.println("Desideri disdire delle prenotazioni? (Si/No): ");
            String opt = sc.nextLine();
            if(opt.equalsIgnoreCase("si")) {
            	System.out.print("Inserisci il numero di posti da disdire: ");
            	int cancelNumber = sc.nextInt();
            	sc.nextLine();
            	
            		try {
            				evento.cancel(cancelNumber);            				
            		} catch (Exception e) {
            			System.err.println("Errore: " + e.getMessage());
            		}
            	
            	System.out.println("Posti disdetti: " + cancelNumber);
            }
            System.out.println("Posti prenotati: " + evento.getReservedSeats()
            				+ "\nPosti disponibili: " + (evento.getMaxSeats() - evento.getReservedSeats()));

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
        sc.close();
        
//      Test Program event
        System.out.println("--------------------");
        ProgramEvent pe = new ProgramEvent("Programma \n");
        Event event1 = new Event("Evento uno", LocalDate.of(2030, 4, 30));
        Event event2 = new Event("Evento due", LocalDate.of(2029, 4, 30));
        Event event3 = new Event("Evento tre", LocalDate.of(2030, 5, 10));
        
        pe.addEvent(event1);
        pe.addEvent(event2);
        pe.addEvent(event3);

//        pe.clearEvents();
        System.out.println("Numero di eventi: " + pe.getNumberOfEvents());
        System.out.println("Ordina per data: " + pe.getEventsSortByDate());
	}

}
