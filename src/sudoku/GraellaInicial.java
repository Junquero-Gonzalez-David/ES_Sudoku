package sudoku;

public class GraellaInicial {
	private char [][]graella;
	private boolean [][]restricted;
	private int correctes;
	private static final char BLANC = '?'; 
	
	public GraellaInicial() {
		graella = new char[9][9];
		restricted = new boolean[9][9];
		correctes = 17;
	}
	
	public boolean afegirNumero(char fila, char col, char num){
		
		if(!Character.isDigit(fila)) throw new IllegalArgumentException("Fila no es un digit");
		if(!Character.isDigit(col)) throw new IllegalArgumentException("Columna no es un digit");
		if(!Character.isDigit(num)) throw new IllegalArgumentException("Numero no es un digit");
		
		int nFila=Character.getNumericValue(fila);
		int nCol=Character.getNumericValue(col);
		
		// If that position is restricted, throw error
		
		if(restricted[nFila][nCol])throw new IllegalArgumentException("No pots modificar els numeros inicials");
		
		// If num is 0, delete that position
		
		if(num=='0'){
			graella[nFila][nCol]=BLANC;
			return true;
		}
		
		// Check if that position is allowed
		
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; j++) {
				// Delete for debugging info
				// System.out.println("Fila "+ i+" Columna "+j+" Valor ij=" + graella[i][j]+"  Num="+num);
				if ((i== nFila|| j==nCol) && graella[i][j]==num) throw new IllegalArgumentException("Ja existeix el numero indicat a la fila o columna");
			}
		}
		graella[nFila][nCol]=num;
		return true;
	}

	public void iniciar(){
		
		for (int i = 0; i < restricted.length; i++) {
			for (int j = 0; j < restricted[i].length; j++) {
				restricted[i][j]=true;
			}
		}		
		graella[0][0]='5';
		graella[0][1]='3';
		graella[0][4]='7';
		graella[1][0]='6';
		graella[1][3]='1';
		graella[1][4]='9';
		graella[1][5]='5';
		graella[2][0]='9';
		graella[2][4]='8';
		graella[2][8]='6';
		graella[3][0]='8';
		graella[3][4]='6';
		graella[3][8]='3';
		graella[4][0]='4';
		graella[4][3]='8';
		graella[4][5]='3';
		graella[4][8]='1';
		graella[5][0]='7';
		graella[5][4]='2';
		graella[5][8]='6';
		graella[6][1]='6';
		graella[6][6]='2';
		graella[6][7]='8';
		graella[7][3]='4';
		graella[7][4]='1';
		graella[7][5]='9';
		graella[7][8]='5';
		graella[8][4]='8';
		graella[8][7]='7';
		graella[8][8]='9';
		
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; j++) {
				if(!Character.isDigit(graella[i][j])){
				this.restricted[i][j]=false;
				this.graella[i][j] = BLANC;	
				}
			}
		}
	}
	public String toString(){
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
