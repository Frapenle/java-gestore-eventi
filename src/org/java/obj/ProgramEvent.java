package org.java.obj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.java.abs.Event;

public class ProgramEvent {
	private String title;
	private List<Event> events;
	
	public ProgramEvent(String title) {
		setTitle(title);
		events = new ArrayList<>();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
//	custom methods
	public void addEvent(Event event) {
		events.add(event);
	}
//	list size
	public int getNumberOfEvents() {
		return events.size();
	}
//	clear list
	public void clearEvents() throws Exception {
			events.clear();			
	}
//	print title and events sort by date
	public String getEventsSortByDate() {
		String printEvents = "Program Title: " + title;
		
		Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event ev1, Event ev2) {
                return ev1.getDate().compareTo(ev2.getDate());
            }
		});
		for (Event event : events) {
            printEvents = printEvents + event.toString() + "\n";
            System.out.println("---------------");
        }
        return printEvents;
	}
	
	

}
