package sudoku;

import java.io.*;

public class Main {

	public static void main(String[] args) {

		GraellaInicial sudoku = new GraellaInicial();
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {

			System.out.println(sudoku.toString());
			System.out.println(
					"Entra la fila, columna i numero a afegir separats  per una coma. \n Exemple:   2,3,5 \n Entra un 0 com a últim valor per esborrar la posició indicada.");
			try {
				input = br.readLine();
				System.out.println("Input= "+input);
				sudoku.afegirNumero(input.charAt(0),input.charAt(2),input.charAt(4));
			} catch (IOException e) {
				System.out.println("Ha sorgit un problema inesperat amb la lectura de la linia: " + e.getMessage());
			}
			
		} while (!sudoku.isComplete());
	}
}
