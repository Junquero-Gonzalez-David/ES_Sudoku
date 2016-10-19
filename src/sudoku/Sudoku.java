package sudoku;

public class Sudoku {
	private static final char BLANK = '?';
	private Casella[][] board;

	public Sudoku() {
		board = new Casella[9][9];
	}

	public boolean addValue(char fila, char col, char valor) {
		
		if (!Character.isDigit(fila))
			throw new IllegalArgumentException("ERROR: Fila no es un digit");
		if (!Character.isDigit(col))
			throw new IllegalArgumentException("ERROR: Columna no es un digit");
		if (!Character.isDigit(valor))
			throw new IllegalArgumentException("ERROR: Numero no es un digit");

		int nFila = Character.getNumericValue(fila) - 1;
		int nCol = Character.getNumericValue(col) - 1;

		// Check if that position is allowed
		if (nFila < 0 || nFila > 8 || nCol < 0 || nCol > 8) {
			throw new IllegalArgumentException("ERROR: El numero de fila i columna ha d'estar entre el 1 i el 9");
		}

		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				if ((x == nFila || y == nCol || board[x][y].getArea() == board[nFila][nCol].getArea())
						&& board[x][y].getValor() == valor) {
					throw new IllegalArgumentException(
							"ERROR: Ja existeix el numero indicat a la fila, columna o area");
				}
			}
		}
		board[nFila][nCol].setValor(valor);
		return true;
	}

	public void iniciar() {

		board = graellaInicial();

	}

	public String toString() {
		int num = 1;
		String output = "     ";
		for (int i = 1; i <= 9; i++) {
			output += i + "   ";
			if (i == 3 || i == 6) {
				output += "|   ";
			}
		}
		output += '\n';
		output += "----------------------------------------------" + '\n';
		for (int i = 0; i < board.length; i++) {
			output += num + "|   ";
			num++;
			for (int j = 0; j < board[i].length; j++) {
				output += board[i][j].getValor() + "   ";
				if (j == 2 || j == 5) {
					output += "|   ";
				}
			}
			output += '\n';
			if (i == 2 || i == 5)
				output += "----------------------------------------------" + '\n';
		}
		return output;
	}

	public boolean isComplete() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].getValor() == BLANK)
					return false;
			}
		}
		return true;
	}

	public static char getEmptyValue() {
		return BLANK;
	}

	public Casella[][] graellaInicial() {

		Casella[][] newBoard = new Casella[9][9];

		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[i].length; j++) {
				newBoard[i][j] = new Casella(BLANK, i, j);
			}
		}
		newBoard[0][0].initValue('5', true);
		newBoard[0][1].initValue('3', true);
		newBoard[0][4].initValue('7', true);
		newBoard[1][0].initValue('6', true);
		newBoard[1][3].initValue('1', true);
		newBoard[1][4].initValue('9', true);
		newBoard[1][5].initValue('5', true);
		newBoard[2][1].initValue('9', true);
		newBoard[2][2].initValue('8', true);
		newBoard[2][7].initValue('6', true);
		newBoard[3][0].initValue('8', true);
		newBoard[3][4].initValue('6', true);
		newBoard[3][8].initValue('3', true);
		newBoard[4][0].initValue('4', true);
		newBoard[4][3].initValue('8', true);
		newBoard[4][5].initValue('3', true);
		newBoard[4][8].initValue('1', true);
		newBoard[5][0].initValue('7', true);
		newBoard[5][4].initValue('2', true);
		newBoard[5][8].initValue('6', true);
		newBoard[6][1].initValue('6', true);
		newBoard[6][6].initValue('2', true);
		newBoard[6][7].initValue('8', true);
		newBoard[7][3].initValue('4', true);
		newBoard[7][4].initValue('1', true);
		newBoard[7][5].initValue('9', true);
		newBoard[7][8].initValue('5', true);
		newBoard[8][4].initValue('8', true);
		newBoard[8][7].initValue('7', true);
		newBoard[8][8].initValue('9', true);

		return newBoard;
	}

}
