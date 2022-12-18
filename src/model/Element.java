package model;

/**
 * Cette classe permet de stocker les informations associées à un atome en l'instanciant en tant qu'objet {@code Element}. 
 * Un {@code Element} possède 4 caractéristiques inchangeables : nombre atomique, masse atomique, nom et symbole. 
 * Le nombre d'électrons d'un élément peut être modifiée selon sa charge.
 * @author Merieme Bouisri
 */
public class Element {
	
	// Attributs inchangeables
	private final int atomicNumber;
	private final float atomicMass;
	private final String name;
	private final String symbol;
	
	// Attribut modifiable
	private int electronNumber;
	
	/**
	 * Constructeur permettant d'initialiser un élément avec une charge neutre.
	 * Une fois initialisé, les attributs de l'élément ne peuvent plus être modifiés.
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
		
		// Atome neutre
		this.electronNumber = atomicNumber;
	}
	
	/**
	 * Méthode d'accès pour {@code atomicNumber}
	 * @return Numéro atomique de l'élément
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	/**
	 * Méthode d'accès pour {@code atomicMass}
	 * @return Masse atomique de l'élément (avec 4 c.s.)
	 */
	public float getAtomicMass() {
		return atomicMass;
	}
	
	/**
	 * Méthode d'accès pour {@code name}
	 * @return Nom de l'élément (sans accents)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Méthode d'accès pour {@code symbol}
	 * @return Symbole de l'élément
	 */
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * Méthode d'accès pour {@code electronNumber}
	 * @return Nombre d'éléctrons que possède l'élément
	 */
	public int getElectrons() {
		return electronNumber;
	}
	
	/**
	 * Méthode d'altération pour {@code electronNumber} selon la charge attribuée.
	 * {@code electronNumber} correspond à la différence entre {@code atomicNumber} et {@code charge}.
	 * @param charge Charge de l'élément
	 */
	public void setCharge(int charge) {
		this.electronNumber = atomicNumber - charge;
	}
	
	/**
	 * Méthode d'accès pour la charge de l'élément (différence entre 
	 * {@code atomicNumber et {@code electronNumber}).
	 * @return La charge de l'élément
	 */
	public int getCharge() {
		return atomicNumber - electronNumber;
	}
	
	/**
	 * Méthode qui réinitialize l'élément à un état neutre.
	 * Équivalent à {@code setCharge(0)}.
	 */
	public void resetCharge() {
		this.electronNumber = atomicNumber;
	}
}
