package no.hvl.DAT102;

import no.hvl.DAT102.adt.KoeADT;
import no.hvl.DAT102.exception.EmptyCollectionException;

public class TabellKoe<T> implements KoeADT<T> {
	private static final int STDK = 100;
	private int bak;
	private T[] koe;
	
	public TabellKoe() {
		this(STDK);
	}
	
	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[])(new Object[startKapasitet]);
	}
	
	@Override
	public void innKoe(T element) {
		if(antall() == koe.length) {
			utvid();
		}
		
		koe[bak] = element;
		bak++;
	}

	@Override
	public T utKoe() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = koe[0];
		bak--;
		
		/**flytter elementene en plass fram */
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i+1];
		}
		koe[bak] = null;
		
		return resultat;
	}

	@Override
	public T foerste() {
		if(erTom())
			throw new EmptyCollectionException("koe");
		
		T resultat = koe[0];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}
	
	private void utvid() {
		T[] hjelpetabell = (T[])(new Object[koe.length * 2]);
		
		for(int soek = 0; soek < bak; soek++) {
			hjelpetabell[soek] = koe[soek];
		}
		
		koe = hjelpetabell;
	}
	
}
