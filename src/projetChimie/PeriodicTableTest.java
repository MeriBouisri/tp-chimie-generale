
package projetChimie;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeriodicTableTest extends PeriodicTable {

	@Test
	void testForNumber() {
		assertEquals("hydrogene", forNumber(1).getName());
		assertEquals(1.008f, forNumber(1).getAtomicMass(), 0);
		assertEquals("H", forNumber(1).getSymbol());
	}

	@Test
	void testForName() {
		assertEquals(1, forName("Hydrogene").getAtomicNumber());
		assertEquals(1.008f, forName("hydrOgene").getAtomicMass(), 0);
		assertEquals("H", forName("HYDROGENE").getSymbol());
	}

	@Test
	void testForMass() {
		assertEquals(1, forMass(1.008f).getAtomicNumber());
		assertEquals("hydrogene", forMass(1.008f).getName());
		assertEquals("H", forMass(1.008f).getSymbol());
	}

	@Test
	void testForSymbol() {
		assertEquals(1, forSymbol("H").getAtomicNumber());
		assertEquals("hydrogene", forSymbol("H").getName());
		assertEquals(1.008f, forSymbol("H").getAtomicMass(), 0);
	}
	
	void testAll() {
		assertEquals(forNumber(6).getName(), forSymbol("C").getName());
		assertEquals(forName("carbone").getAtomicNumber(), forSymbol("C").getAtomicNumber());
	}
}
