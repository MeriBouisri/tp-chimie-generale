package projetChimie;

/**
 * @author Merieme Bouisri
 */
public class Element {

	private int atomicNumber;
	private String name;
	private String symbol;
	private float atomicMass;
	
	private int electronNumber;
	
	/**
	 * Constructeur permettant d'initialiser un élément à partir des 
	 * valeurs contenues dans un tableau de données.
	 * @param elementInfo
	 */
	public Element(String[] elementInfo) {
		this.atomicNumber = Integer.parseInt(elementInfo[0]);
		this.name = elementInfo[1];
		this.symbol = elementInfo[2];
		this.atomicMass = Float.parseFloat(elementInfo[3]);
		
		// Élément initialisé avec une charge nulle
		this.electronNumber = atomicNumber;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}

	public float getAtomicMass() {
		return atomicMass;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getElectrons() {
		return electronNumber;
	}
	
	public void setCharge(int charge) {
		this.electronNumber = atomicNumber - charge;
	}
	
	public int getCharge() {
		return atomicNumber - electronNumber;
	}
}
