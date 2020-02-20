package no.hvl.DAT102.kjedet;

import no.hvl.DAT102.adt.KoeADT;
import no.hvl.DAT102.adt.KoeADTTest;
import no.hvl.DAT102.KjedetKoe;

public class KjedetKoeTest extends KoeADTTest {
	   @Override
		protected KoeADT<Integer> reset() {
			return new KjedetKoe<Integer>();
		}		
}
