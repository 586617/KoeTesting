package no.hvl.DAT102.adt;

import no.hvl.DAT102.exception.EmptyCollectionException;

public interface KoeADT<T> {
		
	/*
	* Legg til et element bak i k�en.
	*/
	void innKoe (T element);
	
	/**
	* Fjerner og returnerer elementet foran i k�en.
	* @return elementet foran i k�en
	* @exception EmptyCollectionException unntak kastes hvis k�en
	allerede er tom
	*/
	T utKoe();
	
	/**
	* Returnerer elementet foran i k�en uten � fjerne det fra k�en.
	* @return elementet foran i k�en
	* @Empty CollectionException unntak kastes hvis k�en allerede er tom
	*/
	T foerste();
	
	/**
	* Returnerer sann hvis k�en ikke inneholder noen elementer.
	* @return sann dersom k�en er tom 
	*/
	boolean erTom();
	
	/**
	* Returnerer antall elementer i k�en.
	* @return antall elementer i k�en
	*/
	int antall();
	
}//interface

