
package projetChimie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Merieme Bouisri
 */
public class PeriodicTable {
	
	ArrayList<Element> elementList = new ArrayList<Element>();

	public PeriodicTable() {
		readElementList();
	}
	
	public Element forNumber(int atomicNumber) {
		return elementList.stream()
				.filter(x -> x.getAtomicNumber() == atomicNumber)
				.findAny()
				.get();
	}
	
	public Element forName(String name) {
		return elementList.stream()
				.filter(x -> x.getName().equalsIgnoreCase(name))
				.findAny()
				.get();
	}
	
	public Element forMass(float atomicMass) {
		return elementList.stream()
				.filter(x -> x.getAtomicMass() == atomicMass)
				.findAny()
				.get();
	}
	
	public Element forSymbol(String symbol) {
		return elementList.stream()
				.filter(x -> x.getSymbol().equals(symbol))
				.findAny()
				.get();
	}
	
	/**
	 * Cette fonction sert à récupérer les données du fichier elements.csv qui contient les 
	 * infos sur les 56 premiers éléments. Chaque ligne du tableau contient le numéro atomique,
	 * le nom, le symbole et la masse atomique d'un élément.
	 */
	public  void readElementList() {
		boolean firstLine = true;
		
		// Fixed bug
		// gotta assign bf.readLine() to variable
 		String info;

		try (BufferedReader bf = new BufferedReader(new FileReader("elements.csv"))) {
		    while ((info = bf.readLine()) != null) { 
		    	if (firstLine) { firstLine = false; continue; } // Skip header
		 
		    	// Créer un nouvel élément pour chaque ligne de données
		    	elementList.add(new Element(info.split(";")));
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
