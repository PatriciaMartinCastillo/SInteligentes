package Robot;

import static robocode.util.Utils.normalRelativeAngleDegrees;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import Busqueda.Accion;
import Busqueda.Busqueda;
import Busqueda.Accion.accion;
import Busqueda.BusquedaAmplitud;
import Main.Casilla;
import Main.Configuracion;
import Main.Problema;
import robocode.Robot;



/**
 * @date 2021-03-09
 * 
 * Plantilla para la definiciÃ³n de un robot en Robocode
 *
 * Configurar Robocode: 1. Options. 2. Preferences 3. Development Options 4. Add
 */

public class RobotBusqueda extends Robot {

	Configuracion cfg;
	boolean marca=false;
	
	//The main method in every robot
	public void run() {
		
		cfg = new Configuracion();
		
		System.out.println("Iniciando ejecuciÃ³n del robot");
		
		// Nuestro robot serÃ¡ rojo
		setAllColors(Color.red);

	
		
		//Orientamos inicialmente el robot hacia arriba
		turnRight(normalRelativeAngleDegrees(0 - getHeading()));
		
		
		
		
		// AQUÃ� DEBE:
		//  1. GENERARSE EL PROBLEMA DE BÃšSQUEDA
		Problema nuevoProblema = new Problema(cfg);
		
		//  2. BUSCAR LA SOLUCIÃ“N CON UN ALGORITMO DE BÃšSQUEDA
		BusquedaAmplitud b = new BusquedaAmplitud(nuevoProblema);
		b.ejecutar();
		
		
		//  3. EJECUTAR LA SOLUCIÃ“N ENCONTRADA	
		List<Accion> solucion = b.getCamino();
		Accion accion = null;
		double orientacion  = 0;
		
		for(int i=solucion.size()-1; i>=0;i--) {
			accion=solucion.get(i);
			orientacion=getOrientacion(accion);
			turnRight(normalRelativeAngleDegrees(orientacion - getHeading()));
			ahead(cfg.getTamCelda());
		}
		
		
		
		
		String cfgString = "Algoritmo de busqueda por amplitud. Semilla: "+cfg.getSemilla()+" Obstáculos: " + cfg.getNumObstaculos();
		System.out.println();
		System.out.println(cfgString);
		
		System.out.println(solucion);
				
		
	}
	
	private double getOrientacion(Accion accion) {
		
		double ori = 0;
		
		switch (accion.toString()) {
		case "arriba": ori = 0; break;
		case "derecha": ori = 90; break;
		case "abajo": ori = 180; break;
		case "izquierda": ori = 270; break;
		}
		
		
		return ori;
	}


/***
* EstÃ© mÃ©todo se ejecutarÃ¡ cuÃ¡ndo se pulse el botÃ³n Pintar

*/

	public void onPaint(Graphics2D g) {
		
	    int tamCelda 	= cfg.getTamCelda();
	    int filaPixels 	= cfg.getNumPixelFila();
	    int columnaPixels = cfg.getnumPixelCol();

	    
	    Problema pro = new Problema(cfg);
	    Casilla[][] campoBatalla = pro.getCampoBatalla();
	    int[] inicio = pro.getInicioRobot();
	    int[] fin = pro.getFinalRobot();
	    
	    g.setPaint(Color.white);
	    
	    for(int i=tamCelda; i<filaPixels; i+=50) {
	    	g.drawLine(i, 0, i, columnaPixels);
	    }
	    
	    for(int i=tamCelda; i<filaPixels; i+=50) {
	    	g.drawLine(0, i, filaPixels, i);
	    }

	    
	    
	    //Celda de inicio
	    g.setPaint(Color.green);
		g.fillRect(inicio[0]*tamCelda, inicio[1]*tamCelda, 10, 10);
		
		
		//Celda destino
		g.setPaint(Color.red);
		g.fillRect(fin[0]*tamCelda, fin[1]*tamCelda, 10, 10);
		
		
		BusquedaAmplitud ba = new BusquedaAmplitud(new Problema(cfg));
		boolean encontrado =ba.ejecutar();
		g.setFont(new Font("Serif",Font.BOLD,16));
		
		
		List<Casilla> lista = ba.getAbierto();
					
		g.setPaint(Color.cyan);
		g.drawString("Abiertos", 0, 32);
		
		for(Casilla x: lista) {
			g.fillRect(x.get_fila()+tamCelda,x.get_columna()+tamCelda , 10, 10);
				
		}
		
		List<Casilla> lista2= ba.getSolucion();
			
		g.setPaint(Color.magenta);
		
		
			for(Casilla x: lista2) {
				g.fillRect(x.get_fila()+tamCelda,x.get_columna()+tamCelda , 10, 10);				
			}
		
			
		HashSet<Casilla> lista3= ba.getCerrados();
			
		g.setPaint(Color.yellow);
		g.drawString("Cerrados", 75, 32);
		
			for(Casilla x: lista3) {
				g.fillRect(x.get_fila()+tamCelda,x.get_columna()+tamCelda , 10, 10);
			
			}
		
		
	    if(!marca) {
	    	
	    	
	    	 for (int j = cfg.getNumColumna();j >=0; j--) {		//Crear filas
	    		 
    		 
	 	    	System.out.println();
	 	    		 	    	
	 	    	if(j==cfg.getNumColumna()) {
	 	    		
	 	    		for(int i = -1; i < cfg.getNumFila(); i++) {
	 	    			if(i==-1) {
	 	    				System.out.print("   ");
	 	    			}else {
	 	    				if(i<10) {
	 	    					System.out.print(" 0"+i);
	 	    				}else {
	 	    					System.out.print(" "+i);
	 	    				}
	 	    			}
	 	    		}
	 	    		
	 	    	}else {
	 	    	
		 	    	for(int i = -1; i < cfg.getNumFila(); i++) {			//Crear columnas
		 	    		
		 	    		if(i==-1) {
		 	    			if(j<10) {
		 	    				System.out.print("0" +j);
		 	    			}else {
		 	    				System.out.print(j);
		 	    			}
		 	    				 	    			
		 	    		}else {
		 	    			 	    		
			 	    		if(campoBatalla[i][j].is_esObstaculo()) {
			 	    			System.out.print("  X");
			 	    			
			 	    		}else {
			 	    			
			 	    			if(i == inicio[0] && j==inicio[1]) {
			 	    				System.out.print("  I");
			 	    			}else if(i == fin[0] && j==fin[1]){
			 	    				System.out.print("  F");
			 	    			}else {
			 	    				System.out.print("  -");
			 	    			}
			 	    		}
		 	    		}	
	 	    		}
	 	    	}
	 	    }
	    }	    	   
	    marca=true;	  
	}	
}


