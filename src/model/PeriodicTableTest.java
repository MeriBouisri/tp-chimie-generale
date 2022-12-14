
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
		
		assertEquals("scandium", forNumber(21).getName());
		assertEquals(44.96f, forNumber(21).getAtomicMass(), 0);
		assertEquals("Sc", forNumber(21).getSymbol());
	
		assertNotEquals("hydrogene", forNumber(40).getName());
		assertNotEquals(16.00f, forNumber(1).getAtomicMass(), 0);
		assertNotEquals("V", forNumber(9).getSymbol());
	}

	@Test
	void testForName() {
		assertEquals(1, forName("Hydrogene").getAtomicNumber());
		assertEquals(1.008f, forName("hydrOgene").getAtomicMass(), 0);
		assertEquals("H", forName("HYDROGENE").getSymbol());
		
		assertEquals(21, forName("scandium").getAtomicNumber());
		assertEquals(44.96f, forName("SCANDIUM").getAtomicMass(), 0);
		assertEquals("Sc", forName("scAnDiUm").getSymbol());
	}

	@Test
	void testForMass() {
		assertEquals(1, forMass(1.008f).getAtomicNumber());
		assertEquals("hydrogene", forMass(1.008f).getName());
		assertEquals("H", forMass(1.008f).getSymbol());
		
		assertEquals(21, forMass(44.96f).getAtomicNumber());
		assertEquals("scandium", forMass(44.96f).getName());
		assertEquals("Sc", forMass(44.96f).getSymbol());
	}

	@Test
	void testForSymbol() {
		assertEquals(1, forSymbol("H").getAtomicNumber());
		assertEquals("hydrogene", forSymbol("H").getName());
		assertEquals(1.008f, forSymbol("H").getAtomicMass(), 0);
		
		assertEquals(21, forSymbol("Sc").getAtomicNumber());
		assertEquals("scandium", forSymbol("Sc").getName());
		assertEquals(44.96f, forSymbol("Sc").getAtomicMass(), 0);
	}
	
	void testAll() {
		assertEquals(forNumber(6).getName(), forSymbol("C").getName());
		assertEquals(forName("carbone").getAtomicNumber(), forSymbol("C").getAtomicNumber());
		
		assertEquals(forNumber(21).getName(), forSymbol("Sc").getName());
	}
	
	void testIonization() {
		forSymbol("Sc").setCharge(3);
		assertEquals(18, forSymbol("Sc").getElectrons());
		assertEquals(3, forName("scandium").getCharge());
	}
}
