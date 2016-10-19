package sudoku;

public class Casella {
	private char valor; //valor de la casella
	private boolean restricted; // si és o no valor inicial, per tant restringit
	private int area;
	
	
	
	public Casella (char valor, int x,int y){
		this.valor = valor;
		if(valor==Sudoku.getEmptyValue()){
			this.restricted = false;
		} else {		   
			this.restricted = true;
		}
		
		if(y<3&&x<3)      this.area = 1;
		else if(y<6&&x<3) this.area = 2;
		else if(y<9&&x<3) this.area = 3;
		else if(y<3&&x<6) this.area = 4;
		else if(y<6&&x<6) this.area = 5;
		else if(y<9&&x<6) this.area = 6;
		else if(y<3&&x<9) this.area = 7;
		else if(y<6&&x<9) this.area = 8;
		else if(y<9&&x<9) this.area = 9;
	}

	public void setValor(char nouValor){
		if(restricted) throw new IllegalArgumentException("No pots modificar els numeros inicials");
		else if(nouValor == '0') this.valor = Sudoku.getEmptyValue(); // If nouValor is 0, delete that position
		else this.valor = nouValor; 
	}
	public void initValue(char nouValor,boolean restricted){
		 this.restricted = restricted;
		 this.valor = nouValor; 
	}
	public boolean isRestricted () {
		return this.restricted;
	}
	public char getValor(){
		return this.valor;
	}
	public int getArea(){
		return this.area;
	}

}
