package Busqueda;

import Main.Casilla;

public class Accion {
	public enum accion {izquierda,derecha,arriba,abajo};
	
	accion action;
	
	
	public Accion(Casilla casIni, Casilla casFin) {
		
		int filaIni = casIni.get_fila();
		int columnaIni = casIni.get_columna();
		int filaFin = casFin.get_fila();
		int columnaFin = casFin.get_columna();
		
		if(filaIni<filaFin && columnaFin==columnaIni) {
			action=accion.arriba;
		}else if(filaIni>filaFin && columnaFin==columnaIni) {
			action=accion.abajo;
		}else if(filaIni==filaFin && columnaFin<columnaIni) {
			action=accion.izquierda;
		}else {
			action=accion.derecha;
		}
		
			
	}


	public accion getAction() {
		return action;
	}
	

}
