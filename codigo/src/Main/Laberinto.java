package Main;
import java.util.Random;

public class Laberinto {
	
	
	// Construimos Estado Inicial, Final y Malla de obstáculos en esta clase.
	
	private Nodo [] [] 	campoBatalla;
	private int[] inicioRobot;
	private int[] finalRobot;
	private int[][] obstaculos;
	private Configuracion cfg;
	
	public Laberinto (Configuracion cfg){
		
		campoBatalla= new Nodo[cfg.getNumFila()][cfg.getNumColumna()];
		this.cfg=cfg;

		
		for(int i=0;i<cfg.getNumFila();i++) {
			for(int j=0;j<cfg.getNumColumna();j++) {
				Nodo cas = new Nodo(i,j);
				campoBatalla[i][j]= cas;
			}
		}
		
		
		Random ram = new Random();
		ram.setSeed(cfg._semilla);		
	
		int control=0;
		
		int pos1,pos2;
		
		
		//Obstaculos
		
		control=0;
		obstaculos = new int[cfg.getNumObstaculos()][2];
				
		while(control<cfg.getNumObstaculos()) {
					
			//Creo posiciones aleatorias
				
			pos1=ram.nextInt(cfg.getNumFila());
			pos2=ram.nextInt(cfg.getNumColumna());
			
			//Compruebo que en esa posici�n no se encuentre otro obstaculo
					
				if(!campoBatalla[pos1][pos2].esObstaculo) {
							
					campoBatalla[pos1][pos2].setesObstaculo(true);
					obstaculos[control][0]=pos1;
					obstaculos[control][1]=pos2;
					control++;
				}
			
		}
				
				
			//Inicial	
				
		inicioRobot= new int[2];
		control=0;
				
		while(control<1) {
			
			//Posicion aleatoria
			pos1=ram.nextInt(cfg.getNumFila());
			pos2=ram.nextInt(cfg.getNumColumna());
			
			//Es obstaculo
			
			if(!campoBatalla[pos1][pos2].esObstaculo) {
				inicioRobot[0]=pos1;
				inicioRobot[1]=pos2;
				control++;
			}
			
		}
		
		
		//Final
		
		control=0;
		finalRobot= new int[2];
		
		while(control<1) {
			
			//Posicion aleatoria
			pos1=ram.nextInt(cfg.getNumFila());
			pos2=ram.nextInt(cfg.getNumColumna());
			
			//Es obstaculo
			
			if(!campoBatalla[pos1][pos2].esObstaculo) {
				finalRobot[0]=pos1;
				finalRobot[1]=pos2;
				control++;
			}
			
		}
		
	
	}



	public Nodo[][] getCampoBatalla() {
		return campoBatalla;
	}



	public int[] getInicioRobot() {
		return inicioRobot;
	}



	public int[] getFinalRobot() {
		return finalRobot;
	}



	public int[][] getObstaculos() {
		return obstaculos;
	}

public Nodo getInicio() {
		
		return new Nodo(inicioRobot[0],inicioRobot[1]);
	}
	
	public Nodo getFinal() {
		
		return new Nodo(finalRobot[0],finalRobot[1]);
	}



	public Configuracion getCfg() {
		return cfg;
	}



	public void setCfg(Configuracion cfg) {
		this.cfg = cfg;
	}

	

}
