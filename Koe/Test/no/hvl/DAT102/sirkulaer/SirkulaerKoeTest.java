package no.hvl.DAT102.sirkulaer;

import no.hvl.DAT102.adt.KoeADT;
import no.hvl.DAT102.adt.KoeADTTest;
import no.hvl.DAT102.SirkulaerKoe;

public class SirkulaerKoeTest extends KoeADTTest {
	   @Override
		protected KoeADT<Integer> reset() {
			return new SirkulaerKoe<Integer>();
		}		
}