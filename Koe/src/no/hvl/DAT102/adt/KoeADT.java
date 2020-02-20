package no.hvl.DAT102.adt;

import no.hvl.DAT102.exception.EmptyCollectionException;

public interface KoeADT<T> {
		
	/*
	* Legg til et element bak i køen.
	*/
	void innKoe (T element);
	
	/**
	* Fjerner og returnerer elementet foran i køen.
	* @return elementet foran i køen
	* @exception EmptyCollectionException unntak kastes hvis køen
	allerede er tom
	*/
	T utKoe();
	
	/**
	* Returnerer elementet foran i køen uten å fjerne det fra køen.
	* @return elementet foran i køen
	* @Empty CollectionException unntak kastes hvis køen allerede er tom
	*/
	T foerste();
	
	/**
	* Returnerer sann hvis køen ikke inneholder noen elementer.
	* @return sann dersom køen er tom 
	*/
	boolean erTom();
	
	/**
	* Returnerer antall elementer i køen.
	* @return antall elementer i køen
	*/
	int antall();
	
}//interface

