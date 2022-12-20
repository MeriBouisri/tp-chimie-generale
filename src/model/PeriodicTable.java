package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Cette classe permet d'accéder aux 56 premiers éléments du tableau périodique.
 */
public class PeriodicTable {

	private ArrayList<Element> elementList = new ArrayList<Element>();

	/**
	 * Constructeur sans paramètre. Permet d'accéder aux 56 premiers éléments
	 * du tableau périodique.
	 */
	public PeriodicTable() {
		readElementList();
	}
	
	/**
	 * Cette méthode permet d'accéder à un objet {@code Element} selon l'attribut recherché.
	 * @param predicate Condition qui détermine l'attribut par lequel rechercher un élément
	 * @return Element recherché
	 */
	private Element searchElement(Predicate<Element> predicate) {
		return elementList.stream() // Traverser la liste d'éléments
				.filter(predicate)  // Chercher celui qui correspond au prédicat
				.findAny()          // Récupérer Optional<Element>
				.get();             // Récupérer Element
	}
	
	// Méthodes d'accès à un élément selon l'un de ses attributs
	
	/**
	 * @param atomicNumber 
	 * @return Élément correspondant au nombre atomique.
	 */
	public Element forNumber(int atomicNumber) {
		return searchElement(element -> element.getAtomicNumber() == atomicNumber);
	}
	
	/**
	 * @param atomicMass
	 * @return Élément correspondant à la masse atomique.
	 */
	public Element forMass(float atomicMass) {
		return searchElement(element -> element.getAtomicMass() == atomicMass);
	}
	
	/**
	 * Note : Ne pas affecter d'accents aux voyelles, sinon le nom ne sera pas reconnu 
	 * (Par exemple, "hydrogene" sera reconnu, mais pas "hydrogène").
	 * @param name Nom de l'élément.
	 * @return Élément correspondant au nom (en ignorant les majuscules).
	 */
	public Element forName(String name) {
		return searchElement(element -> element.getName().equalsIgnoreCase(name));
	}
	
	/**
	 * @param symbol
	 * @return Élément correspondant au symbole (en ignorant les majuscules).
	 */
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
		 
		    	String[] infoArray = info.split(";");
		    	
		    	elementList.add(new Element(
		    			Integer.parseInt(infoArray[0]), // Numéro atomique
		    			Float.parseFloat(infoArray[1]), // Masse atomique
		    			infoArray[2],					// Nom de l'élément
		    			infoArray[3])					// Symbole de l'élément
		    			);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}