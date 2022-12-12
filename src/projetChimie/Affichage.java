/**
 * 
 */
package projetChimie;

import java.util.Scanner;

/**
 * @author merie
 *
 */
public class Affichage {
		public Affichage() {
			initialize();
		}
		
		private void initialize() {
			
			Scanner input = new Scanner(System.in);
	
			PeriodicTable pt = new PeriodicTable();
			CalculMole calcul = new CalculMole();
			
			System.out.print( "Quel est votre cation?");
			String cations = input.nextLine();
			
			System.out.print("Combien avez vous de cation?");
			double nb_cation  = input.nextDouble();
			
			System.out.print("Quel est la charge de votre cation?");
			int nb_charge = input.nextInt();
			pt.forSymbol(cations).setCharge(nb_charge);
			
			int nb_electron = pt.forSymbol(cations).getElectrons();
			double nx = (nb_cation* nb_electron);
			double Nx = calcul.getNumberOf(nx);

			System.out.print("Le nombre d'électrons dans " + nb_cation  + " ions "+ cations + "est de  "+ Nx);
		}
		
}
