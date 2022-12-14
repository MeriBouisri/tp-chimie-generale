package projetChimie;

/**
 * @author Merieme Bouisri
 */
public class Element {
	
	private final int atomicNumber;
	private final float atomicMass;
	private final String name;
	private final String symbol;
	
	private int electronNumber;
	
	/**
	 * Constructeur permettant d'initialiser un élément avec un charge neutre.
	 * @param atomicNumber numéro atomique de l'élément
	 * @param atomicMass masse atomique de l'élément
	 * @param name nom de l'élément
	 * @param symbol symbole de l'élément
	 */
	public Element(int atomicNumber, float atomicMass, String name, String symbol) {
		this.atomicNumber = atomicNumber;
		this.atomicMass = atomicMass;
		this.name = name;
		this.symbol = symbol;
		
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
