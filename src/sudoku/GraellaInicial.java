package sudoku;

public class GraellaInicial {
	private char [][]graella;
	private int correctes;
	private static final char BLANC = '?'; 
	
	public GraellaInicial() {
		graella = new char[9][9];
		correctes = 17;
	}
	
	public boolean afegirNumero(int fila, int col, int num){
		if(this.comprovar(fila, col, num)){
			//afegir a graella
			return true;
		}
		else return false;
	}
	public boolean comprovar(int fila, int col, int num){
		return true;
	}
	public void iniciar(){
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; j++) {
				this.graella[i][j] = BLANC;
			}
		}
	}
	public String toString(){
		// TODO Check the table is displayed properly
		String output = "";
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; j++) {
				output += graella[i][j] + "   ";
				if (j==2||j==5){
					output += "|   ";
				}
			}
			output += '\n';
			if (i==2||i==5) output += "-----------------------------------------";
			output += '\n';
		}
		return output;
	}

	public boolean isComplete() {
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; i++) {
				if (graella[i][j] == BLANC)
					return false;
			}
	} return true;
}
}
