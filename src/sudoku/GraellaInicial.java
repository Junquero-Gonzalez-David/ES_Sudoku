package sudoku;

public class GraellaInicial {

	int numeros[][];
	
	public String toString(){
		
		//TODO Check the table is displayed properly
		
		String output="";
		for(int i=0;i<numeros.length;i++){
			for(int j=0;j<numeros[i].length;i++){
				output+=numeros[i][j]+'\t';
				if(j%3==0) output+=" | "; // Could not be correct
			}
		}
		
		return output;
	}
	
	public boolean isComplete(){
		return true; // TODO Complete
	}
}
