package projetChimie;

public class Element {
	
	private int atomicNumber;
	private String name;
	private String symbol;
	private double atomicMass;
	
	public Element(int atomicNumber, String name, String symbol, double atomicMass) {
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.symbol = symbol;
		this.atomicMass = atomicMass;
	}
	
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	
	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	public double getAtomicMass() {
		return atomicMass;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	

	
	
}
