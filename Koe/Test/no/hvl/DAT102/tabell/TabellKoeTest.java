package no.hvl.DAT102.tabell;

import no.hvl.DAT102.adt.KoeADT;
import no.hvl.DAT102.adt.KoeADTTest;
import no.hvl.DAT102.TabellKoe;

public class TabellKoeTest extends KoeADTTest {
	   @Override
		protected KoeADT<Integer> reset() {
			return new TabellKoe<Integer>();
		}
}
