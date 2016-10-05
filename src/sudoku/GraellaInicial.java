package sudoku;

public class GraellaInicial {
	private Casella [][]graella;
	private char [][]valors = 
			  {{'5','3','?','?','7','?','?','?','?'},
			   {'6','?','?','1','9','5','?','?','?'},
			   {'?','9','8','?','?','?','?','6','?'},
			   {'8','?','?','?','6','?','?','?','3'},
			   {'4','?','?','8','?','3','?','?','1'},
			   {'7','?','?','?','2','?','?','?','6'},
			   {'?','6','?','?','?','?','2','8','?'},
			   {'?','?','?','4','1','9','?','?','5'},
			   {'?','?','?','?','8','?','?','7','9'}}; 
	
	public GraellaInicial() {
		graella = new Casella[9][9];
	}
	
	public boolean afegirNumero(char fila, char col, char valor){
		
		if(!Character.isDigit(fila)) throw new IllegalArgumentException("ERROR: Fila no es un digit");
		if(!Character.isDigit(col)) throw new IllegalArgumentException("ERROR: Columna no es un digit");
		if(!Character.isDigit(valor)) throw new IllegalArgumentException("ERROR: Numero no es un digit");
		
		int nFila=Character.getNumericValue(fila)-1;
		int nCol=Character.getNumericValue(col)-1;
	
		// Check if that position is allowed
		if(nFila<0 || nFila>8 || nCol<0 || nCol>8){
			throw new IllegalArgumentException("ERROR: El numero de fila i columna ha d'estar entre el 1 i el 9");
		}
		
		for (int x = 0; x < graella.length; x++) {
			for (int y = 0; y < graella[x].length; y++) {
				if ((x== nFila|| y==nCol || graella[x][y].getArea()==graella[nFila][nCol].getArea()) && graella[x][y].getValor()==valor){ 
					throw new IllegalArgumentException("ERROR: Ja existeix el numero indicat a la fila, columna o area");
				}
			}
		}
		graella[nFila][nCol].setValor(valor);
		return true;
	}
	
	public void iniciar(){
		for (int x = 0; x < graella.length; x++) {
			for (int y = 0; y < graella[x].length; y++) {
				graella[x][y] = new Casella(valors[x][y],x,y);
			}
		}	
		
	}
	public String toString(){
		int num=1;
		String output = "     ";
		for (int i = 1; i <=9; i++){
			output += i + "   ";
			if (i==3||i==6){
				output += "|   ";
			}
		}
		output += '\n';
		output += "----------------------------------------------" + '\n';
		for (int i = 0; i < graella.length; i++) {
			output += num + "|   ";
			num++;
			for (int j = 0; j < graella[i].length; j++) {
				output += graella[i][j].getValor()+ "   ";
				if (j==2||j==5){
					output += "|   ";
				}
			}
			output += '\n';
			if (i==2||i==5) output += "----------------------------------------------" + '\n';
		}
		return output;
	}

	public boolean isComplete() {
		for (int i = 0; i < graella.length; i++) {
			for (int j = 0; j < graella[i].length; i++) {
				if (graella[i][j].getValor() == '?')
					return false;
			}
	} return true;
}
}
