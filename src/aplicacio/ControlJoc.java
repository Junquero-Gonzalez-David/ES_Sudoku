package aplicacio;

import domini.Taulell;

public class ControlJoc {
	Taulell t;
	public ControlJoc(){
		t = new Taulell();
	}
	public void afegirNouValor(int x, int y, int valor) throws Exception{
		t.addValor(x, y, valor, false);
	}	
	public String getToStringTaulell(){return t.toString();}
	public boolean jocCompletat(){return t.isComplete();}
	public int[][] getValorsGraella(){return t.getValors();}
	public int error(int i){
		if(i>1) throw new IllegalArgumentException();
		return t.getError()[i];
		}
}
