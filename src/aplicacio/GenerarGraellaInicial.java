package aplicacio;

import domini.Taulell;
import prova.GraellaInicial;

public abstract class GenerarGraellaInicial {
	public static void crearGraella(Taulell t) throws Exception{
		GraellaInicial g = new GraellaInicial();
		g.iniciarGraella(t);
	}
	public abstract void iniciarGraella(Taulell t) throws Exception;
}
