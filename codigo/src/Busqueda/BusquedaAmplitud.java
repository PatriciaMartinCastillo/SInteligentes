package Busqueda;

import java.util.ArrayList;
import java.util.*;

import Main.Casilla;
import Main.Configuracion;
import Main.Problema;

public class BusquedaAmplitud extends Busqueda {

	ArrayList<Casilla> solucion;
	
	public BusquedaAmplitud(Problema p) {
		super(p);
		solucion = new ArrayList<Casilla>();
		
	}
	public ArrayList<Casilla> getSolucion(){
		return solucion;
	}

	@Override
	public boolean ejecutar() {

		
		boolean ok=false;
		
		Casilla n=null;
		ArrayList<Casilla> sucesores;
		
		
		super.abiertos.add(super.pro.getInicio());
		
		while(!super.abiertos.isEmpty() && !ok) {
			
			n = super.abiertos.remove(0);
			super.nodosA++;
			super.cerrados.add(n);
			
			if(n.equals(pro.getFinal())) {
				ok=true;
			}else {
				
				
				sucesores = calcularSucesores(n);
				for(Casilla x: sucesores) {
					
					if(!super.abiertos.contains(x) && !super.cerrados.contains(x)){
						
						x.setCasAnterior(n);
						super.abiertos.add(x);
					
					}		
				}
				
				if(super.abiertos.size() > super.maxA) {
					super.maxA = super.abiertos.size();
				}

			}									
		}
		
		if(ok) {
			while(n!= null) {
				solucion.add(n);
				if(n.getCasAnterior()!=null) {
					
					super.accion.add(new Accion(n.getCasAnterior(),n));
				}
					
				n = n.getCasAnterior();
				
				
			}
		}
		
		
		return ok;
		
	}
	
	
	public ArrayList<Casilla> calcularSucesores(Casilla nodo){
		
		ArrayList<Casilla> sucesores = new ArrayList<Casilla>();
		int i = nodo.get_fila();
		int j = nodo.get_columna();
		
		
		if(esValido(i+1,j)) { //arriba
			sucesores.add(super.campoBatalla[i+1][j]);
		}
		
		if(esValido(i,j-1)) { // izquierda
			sucesores.add(super.campoBatalla[i][j-1]);
		}
		
		if(esValido(i-1,j)) { //abajo
			sucesores.add(super.campoBatalla[i-1][j]);
		}
		
		
		if(esValido(i,j+1)) { // derecha
			sucesores.add(super.campoBatalla[i][j+1]);
		}
	
		
		return sucesores;
		
	}
	
	private boolean esValido(int x, int y) {
		Casilla[][] campoBatalla = super.campoBatalla;
		Configuracion cfg = super.pro.getCfg();
		return ((x>=0)) && ((y>=0)) && (x<cfg.getNumFila()) && (y<cfg.getNumColumna() && (!campoBatalla[x][y].is_esObstaculo()));
	}
	
	
	

}

