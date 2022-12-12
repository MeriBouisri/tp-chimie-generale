package projetChimie;

/**
 * @author Merieme Bouisri
 */
public class Element {
	
	private final int atomicNumber;
	private final String name;
	private final String symbol;
	private final float atomicMass;
	
	private int electronNumber;
	
	/**
	 * Constructeur permettant d'initialiser un element a partir des 
	 * valeurs contenues dans un tableau de données. Les indices du 
	 * tableau représentent la colonne de chaque attribut.
	 * @param elementInfo Tableau de données. 
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
	
	public void resetCharge() {
		this.electronNumber = atomicNumber;
	}
}
