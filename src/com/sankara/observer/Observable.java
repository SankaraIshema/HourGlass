package com.sankara.observer;

public interface Observable {
	
	public void addObserver(Observer obs);
	public void notifyObserver();
	public void deleteObserver();
}
