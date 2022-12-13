
package projetChimie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PeriodicTable {
	
	private ArrayList<Element> elementList = new ArrayList<Element>();

	public PeriodicTable() {
		readElementList();
	}
	
	private Element searchElement(Predicate<Element> predicate) {
		return elementList.stream()
				.filter(predicate)
				.findAny()
				.get();
	}
	
	// Méthodes d'accès à un élément selon l'un de ses attributs
	
	public Element forNumber(int atomicNumber) {
		return searchElement(element -> element.getAtomicNumber() == atomicNumber);
	}
	
	public Element forName(String name) {
		return searchElement(element -> element.getName().equalsIgnoreCase(name));
	}
	
	public Element forMass(float atomicMass) {
		return searchElement(element -> element.getAtomicMass() == atomicMass);
	}
	
	public Element forSymbol(String symbol) {
		return searchElement(element -> element.getSymbol().equalsIgnoreCase(symbol));
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
