package no.hvl.DAT102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.DAT102.exception.EmptyCollectionException;
import no.hvl.DAT102.adt.KoeADT;


public abstract class KoeADTTest {

	// Referanse til koe
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/*
	 * Henter en ny koe for hver test.
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/*
	 * Test om en ny koe er tom.
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	/**
	 * Tester innKoe og utKoe.
	 */
	@Test
	public void innKoeOgutKoe() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Tester innKoe og utKoe med duplikate verdier.
	 */
	@Test
	public void innKoeutKoeDuplikater() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing av foerste
	 */
	@Test
	public void innKoeutKoeinnKoeinnKoeFoerste() {
		try {
			koe.innKoe(e2);
			koe.utKoe();
			koe.innKoe(e3);
			koe.innKoe(e4);

			assertEquals(e3, koe.foerste());
			koe.utKoe();
			assertEquals(e4, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("utKoe eller foerste feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test at en koe med null elementer er tom.
	 */
	
	@Test
	public void innUtKoeErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("innKoe eller UtKoe feilet uventet " + e.getMessage());
		}
	}
	
	/**
	 * Test av størrelsen
	 */
	@Test
	public void stor() {
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		assertEquals(3, koe.antall());
	}

	/**
	 * Forsøker utKoe av en tom koe skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	@Test
	public void utKoeFromEmptyIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
	
}
