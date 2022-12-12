/**
 * 
 */
package projetChimie;

/**
 * @author merie
 *
 */
public class Affichage {
  Scanner input = new Scanner(System.in);

		PeriodicTable pt = new PeriodicTable();
		
		
		System.out.print( "Quel est votre cation?");
		String cations = input.nextLine();
		
		System.out.print("Quel est la charge de votre cations?");
		int nb_charge = input.nextInt();
		pt.forSymbol(cations).setCharge(nb_charge);
		
		
		int nb_electron = pt.forSymbol(cations).getElectrons();
		Double Nx = calcul.convertion(nb_electron);
}
