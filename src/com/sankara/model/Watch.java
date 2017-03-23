package com.sankara.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.sankara.observer.Observable;
import com.sankara.observer.Observer;

public class Watch implements Observable {
	
	private String hour;
	private Calendar calendar;
	private ArrayList<Observer> listObserver = new ArrayList<>();
	
	public Watch() {}
		
	public void run() {
		while(true) {
			this.calendar = Calendar.getInstance();
			
			this.hour = this.calendar.get(Calendar.HOUR_OF_DAY) + " : "
					
					 + (this.calendar.get(Calendar.MINUTE) < 10 
							 ? "0" + this.calendar.get(Calendar.MINUTE) 
								 : this.calendar.get(Calendar.MINUTE)) + " : "
					
					 + (this.calendar.get(Calendar.SECOND) < 10 
							 ? "0" + this.calendar.get(Calendar.SECOND) 
							 	 : this.calendar.get(Calendar.SECOND));
			
			this.notifyObserver();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				  		
		}
	}

	@Override
	public void addObserver(Observer obs) {
		listObserver.add(obs);	
	}

	@Override
	public void notifyObserver() {
		for(Observer obs : listObserver) {
			obs.update(hour);
		}
	}

	@Override
	public void deleteObserver() {
		listObserver.clear();
	}
}
