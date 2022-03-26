package Main;

import java.util.Random;

import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSetup;
import robocode.control.RobotSpecification;

/**
 * 
 * @date 2021-03-09
 * 
 * Plantilla para la prÃ¡ctica de algoritmos de bÃºsqueda con Robocode 
 * 
 * 
 */

public class RouteFinder {
	/**
	 * ConfiguraciÃ³n 
	 * 
	 */
	
	//static String robocodeLocalization=  "C:/Robocode"; //Windows
	static String	 robocodeLocalization= "C:/robocode"; //MAC o Linux"
	static String    nombreRobot ="Robot.RobotBusqueda*";
	
	/**
	 * ConfiguraciÃ³n 	 * 
	 */
	
	Configuracion 	cfg;
	RobocodeEngine  engine;
	BattlefieldSpecification battlefield;
	RobotSpecification[] modelRobots;
	RobotSpecification[] existingRobots;
	RobotSetup		  [] robotSetups ;
	Problema	nuevoProblema;
	
	
	public  RouteFinder () {
		 cfg = new Configuracion();	
		 
		 

		//ToDo: GENERAR EL MAPA DE OBSTÃ�CULOS Y LAS POSICIONES INICIAL Y FINAL DEL ROBOT
		
		nuevoProblema = new Problema (cfg);
		Random semilla = new Random();
		
		
		
		
	}
	
	/******************
	 * ConfiguraciÃ³n de la batalla
	 */
	
	public void cfgRobocode() {
		
		// Crear el RobocodeEngine desde una la instalaciÃ³n
			 engine = new RobocodeEngine(new java.io.File(robocodeLocalization)); //Ojo configuraciÃ³n 
			 engine.setVisible(true); // Mostrar el simulador de Robocode
			
		// Crear el campo de batalla
			battlefield = new BattlefieldSpecification(cfg.getNumPixelFila(), cfg.getnumPixelCol());
			
				
		// En modelRobots recogemos la especificaciÃ³n de los robots que utilizaremos en la simulaciÃ³n.
			 modelRobots = engine.getLocalRepository(nombreRobot+",sample.SittingDuck");
				
		// Incluiremos un robot sittingDuck por obstÃ¡culo, mÃ¡s nuestro propio robot.
			 existingRobots =	new RobotSpecification[cfg.getNumObstaculos()+1];
			 robotSetups 	= 	new RobotSetup[cfg.getNumObstaculos()+1];
	}
	
	/*************************************
	 *  AÃ±ado el Robot de BÃºsqueda
	 */
	
	public void addRobotBusqueda() {
		
		/*
	     * Creamos primero nuestro propio robot y lo colocamos en la posiciÃ³n inicial del problema,
	     * que deberÃ¡ estar libre de obstÃ¡culo.
		 */
		
		
		double centro=cfg.getTamCelda()/2;
		double tam = cfg.getTamCelda();
		
		double fila = nuevoProblema.getInicioRobot()[0]*tam + centro;
		double columna=nuevoProblema.getInicioRobot()[1]*tam + centro;
		double arriba=0;
					//Temporal
		existingRobots[0] = modelRobots[0];
		robotSetups	  [0] = new RobotSetup(fila,  columna,  arriba);       //orientaciÃ³n inicial	
	
	}		
		
		
	/*************************************
	 *  AÃ±ado los obstÃ¡culos 
	 */
	
	public void addRobotObstaculos() {
			
		double sittingDuckFila, sittingDuckColumna, arriba = 0.0;	 //Temporal
		
		int obstaculos = cfg.getNumObstaculos();
		int control=0;
		double centro=cfg.getTamCelda()/2;
		double tam = cfg.getTamCelda();
		
		
		
		
		if (obstaculos > 0) {
			while(control < obstaculos) {
				
				double fila = nuevoProblema.getObstaculos()[control][0]*tam + centro;
				double columna=nuevoProblema.getObstaculos()[control][1]*tam + centro;
				
				sittingDuckFila= fila;
				sittingDuckColumna=columna;
				
				
				existingRobots[control+1] 	= modelRobots[1];   //sittingDuck
				
				robotSetups[control+1]		= new RobotSetup( sittingDuckFila, sittingDuckColumna ,  arriba);  
				control++;
				
			}			
			
		}
		System.out.println("Generados "+obstaculos+"  sitting ducks.");
		
		
		
	}
	
	/***************
	 * EjecuciÃ³n
	 */
	public void run () {
		
		/* 
		 * Crear y desarrollar la batalla con los robots antes definidos
		 */
		
		 
		BattleSpecification battleSpec =
				new BattleSpecification(battlefield,
						cfg.numberOfRounds,
						cfg.inactivityTime,
						cfg.gunCoolingRate,
						cfg.sentryBorderSize,
						cfg.hideEnemyNames,
						existingRobots,
						robotSetups);
		
		
		// Ejecutar la simulaciÃ³n el tiempo especificado
		engine.runBattle(battleSpec, true); 
		// Cerrar la simulaciÃ³n
		engine.close();
		// Asegurarse de que la MV de Java se cierra adecuadamente.
		System.exit(0);
	}
	
	/********************************************
	 * Ejecutar
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		RouteFinder practica = new RouteFinder();
		
		
		practica.cfgRobocode();
		practica.addRobotBusqueda();
		practica.addRobotObstaculos();
		practica.run();
		
	
	}
	
}
