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
			
			System.out.print("Quel est la charge de votre cation?");
			int nb_charge = input.nextInt();
			pt.forSymbol(cations).setCharge(nb_charge);
			
			
			int nb_electron = pt.forSymbol(cations).getElectrons();
			Double Nx = calcul.getNumberOf(nb_electron);
		}
		
}
