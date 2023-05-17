package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.java.abs.Event;

public class Main {

	public static void main(String[] args) throws Exception {
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
                    for (int i = 0; i < reservedSeats; i++) {
                        evento.book();
                    }
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
            			for (int i = 0; i < cancelNumber; i++) {
            				evento.cancel();            				
            			}
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
        
	}

}
