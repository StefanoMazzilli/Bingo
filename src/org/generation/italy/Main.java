package org.generation.italy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> tabellone = new HashSet<Integer>();
		Random r=new Random();
		Scanner sc=new Scanner (System.in);
		HashSet<Integer> scheda =new HashSet<Integer>();
		ArrayList<Integer> scheda1=new ArrayList<Integer>();
		boolean vittoria=false;
		
		int numRiga, numColonna, numero, estratto, nSchede=1;
		
		
		System.out.println("Quante schede vuoi acquistare?");
		nSchede=sc.nextInt();
		sc.nextLine();
		int[] schede= new int[nSchede];
		int[][][] schedaIniziale= new int[3][5][nSchede];
		int[][] indici =new int[3][nSchede];
		
		//creazione scheda assicurandoci che non sia ripetuto il numero
		for (int contatore=0; contatore<nSchede; contatore++) {	
			
			for (numRiga=0; numRiga<3; numRiga++) {
				for (numColonna=0; numColonna<5; numColonna++) {
					do {
						numero=r.nextInt(90)+1;
					} while (scheda.contains(numero));//ripeto se il numero è già uscito
					schedaIniziale[numRiga][numColonna][contatore]=numero;
					scheda.add(numero);
					scheda1.add(numero);
				}
				
			}
			scheda.clear();
			
			for (numRiga=0; numRiga<3; numRiga++) {
				for (numColonna=0; numColonna<5; numColonna++) {
					System.out.print(schedaIniziale[numRiga][numColonna][contatore]+" ");
				}
				System.out.println();
			}
			System.out.println(" ");
			
		}
		
		//estrazione
		do { //ciclo di estrazione
			do { //ciclo di controllo del tabellone
				estratto = r.nextInt(90)+1;
			} while (tabellone.contains(estratto));
			System.out.println("\nIl numero estratto è: "+estratto+"\n");
			
			tabellone.add(estratto);
			
			if (scheda1.contains(estratto)) {
				//controlla se il numero estratto è stato inserito in una delle schede
				for (int contatore=0; contatore<nSchede; contatore++) {
					//cerca il numero estratto tra le varie schede
					for (numColonna=0; numColonna<5; numColonna++) {
						if (schedaIniziale[0][numColonna][contatore]==estratto) {
							indici[0][contatore]++;
							schedaIniziale[0][numColonna][contatore]=schedaIniziale[0][numColonna][contatore]*(-1);
							if ((indici[0][contatore]==5)) {
								System.out.println("CINQUINA!");
								
							}
						}
						if (schedaIniziale[1][numColonna][contatore]==estratto) {
							indici[1][contatore]++;
							schedaIniziale[1][numColonna][contatore]=schedaIniziale[1][numColonna][contatore]*(-1);
							if ((indici[1][contatore]==5)) {
								System.out.println("CINQUINA!");
							}
						}
						if (schedaIniziale[2][numColonna][contatore]==estratto) {
							indici[2][contatore]++;
							schedaIniziale[2][numColonna][contatore]=schedaIniziale[2][numColonna][contatore]*(-1);
							if ((indici[2][contatore]==5)) {
								System.out.println("CINQUINA!");
							}
						}
						
					}
					//stampa tutte le schede
					for (numRiga=0; numRiga<3; numRiga++) {
						for (numColonna=0; numColonna<5; numColonna++) {
							System.out.print(schedaIniziale[numRiga][numColonna][contatore]+" ");
						}
						System.out.println();
					}
					System.out.println(" ");
				}
				
			
			}
			
			//controllo se una scheda ha fatto bingo
			for (int contatore=0; contatore<nSchede; contatore++) {
				if(indici[0][contatore]==5&&indici[1][contatore]==5&&indici[2][contatore]==5) {
					System.out.println("Complimenti! Hai fatto BINGO!");
					for (numRiga=0; numRiga<3; numRiga++) {
						for (numColonna=0; numColonna<5; numColonna++) {
							System.out.print(schedaIniziale[numRiga][numColonna][contatore]+" ");
						}
						System.out.println();
					}
					System.out.println(" ");
					vittoria=true;
				}
			}
			
			System.out.println("\nPremere invio per continuare");
			sc.nextLine();
			
		} while (!vittoria);
		
		sc.close();
	}

}
