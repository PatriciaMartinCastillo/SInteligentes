package Busqueda;

import java.util.*;

import Main.Casilla;
import Main.Problema;


public abstract class Busqueda {
	
	
	
	protected HashSet<Casilla> cerrados;
	protected List<Casilla> abiertos;
	protected List<Accion> accion;
	

	protected Casilla[][] campoBatalla;
	protected Problema pro;
	protected int nodosA;
	protected int maxA;
	
	public Busqueda (Problema p){
		
		cerrados = new HashSet<Casilla>();
		abiertos = new ArrayList<Casilla>();
		accion = new ArrayList<Accion>();
		pro=p;
		campoBatalla=p.getCampoBatalla();
		
	}
	
	abstract public boolean ejecutar();
	
	public List<Accion> getCamino (){
	
		return accion;
	}	
	
	public String getName() {
		return null;
	}
		
	public List <Casilla> getAbierto(){
		return abiertos;
	}
	
	public HashSet	<Casilla> getCerrados() {				
		
		return  cerrados;
	}
	
	public int getNumNodosExtendidos() {
				
		return nodosA;
	}
	
	public int getNumMaxAbiertos() {
		return maxA;
	}
	
	public int getCoste (){
		int gasto = 0;	
		
		return gasto;
	}

	
}