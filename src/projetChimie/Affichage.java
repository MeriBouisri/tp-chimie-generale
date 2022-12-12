/**
 * 
 */
package projetChimie;

import java.util.Scanner;

/**
 * @author merie
 * @author noé
 */
public class Affichage {
		public Affichage() {
			initialize();
		}
		
		private void initialize() {
			
			Scanner input = new Scanner(System.in);

			PeriodicTable pt = new PeriodicTable();
			CalculMole calcul = new CalculMole();
			
			//demande le nombre de cation
			System.out.print( "Quel est votre cation?");
			String cations = input.nextLine();
			
			//demande le nombre de cations
			System.out.print("Combien avez vous de cation?");
			double nb_cation  = input.nextDouble();
			
			//demande la charge de cation
			System.out.print("Quel est la charge de votre cation?");
			int nb_charge = input.nextInt();
			
			//met la charge sur le cation
			pt.forSymbol(cations).setCharge(nb_charge);
			
			//trouve le nombre d'electrons
			int nb_electron = pt.forSymbol(cations).getElectrons();
			
			//fait les calculs
			double nx = calculMole(nb_cation, nb_electron);
			double Nx = calcul.getNumberOf(nx);

			System.out.print("Le nombre d'électrons dans " + nb_cation  + " ions "+ cations + "est de  "+ Nx);
		}
		
}
