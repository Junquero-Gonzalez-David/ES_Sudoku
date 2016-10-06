package sudoku;

import java.io.*;

public class Main {
	public static void main(String[] args) {
		GraellaInicial sudoku = new GraellaInicial();
		sudoku.iniciar();	
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do {
			System.out.println(sudoku.toString());
			System.out.println(
					"Entra la fila, columna i numero a afegir separats  per una coma (o qualsevol altre caràcter). \n Exemple:   2,3,5 \n Entra un 0 com a ultim valor per esborrar la posicio indicada.");
			System.out.println("");
			try {	
				input = br.readLine();
				if(input.length()!=5) throw new IllegalArgumentException("ERROR: Format de dades incorrecte");
				sudoku.afegirNumero(input.charAt(0),input.charAt(2),input.charAt(4));
				System.out.println("");
			} catch (IOException e) {
				System.out.println("Ha sorgit un problema inesperat amb la lectura de la linia. \n" + e.getMessage()+ '\n');
			}
			  catch (IllegalArgumentException e) {
				System.out.println("Ha sorgit un problema amb la lectura de dades. El format no es correcte o la posició indicada no es permesa. \n " + e.getMessage()+'\n');
		 	}	
		} while (!sudoku.isComplete());
		System.out.println("Sudoku Completat!");
	}
}

