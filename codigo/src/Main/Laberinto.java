package Main;
import java.util.Random;

public class Laberinto {
	
	
	// Construimos Estado Inicial, objetivo y Malla de obstáculos en esta clase.
	
	private char [] [] 	matriz;
	private int dimensionX;
	private int dimensionY;
	private int iniX, iniY, objX, objY;
	private int prb;
	
	private Configuracion cfg;
	Boolean solucionable;

	// HECHO EL CONSTRUCTOR
	public Laberinto (int dimensionX, int dimensionY, int prob){
		
		

		matriz= new char[dimensionX][dimensionY];
		prb = prob;
		

		
		for(int i=0;i<dimensionX;i++) {
			for(int j=0;j<dimensionY;j++) {
				matriz[i][j]= ' ';
			}
		}
		
		
	// GENERAR LABERINTO
		Random ram = new Random();		

		// ram.setSeed(cfg._semilla);		
	
		int control=0;
		
		int pos1,pos2;
		
		
		//Obstaculos
		
		int tope=(prob/100)*(dimensionX*dimensionY);
				
		while(control<tope) {
					
			//Creo posiciones aleatorias
				
			pos1=ram.nextInt(dimensionX);
			pos2=ram.nextInt(dimensionY);
			
			//Compruebo que en esa posicion no se encuentre otro obstaculo
					
				if(matriz[pos1][pos2] != '*') {
							
					matriz[pos1][pos2] = '*';
					control++;
				}
			
		}
				
				
			//Inicial	
				
		
		control=0;
				
		while(control<1) {
			
			//Posicion aleatoria
			iniX=ram.nextInt(dimensionX);
			iniY=ram.nextInt(dimensionY);
			
			//Es obstaculo
			
			if(matriz[iniX][iniY] != '*') {
				matriz[iniX][iniY] = 'I';
				control++;
			}
			
		}
		
		
		//objetivo
		
		control=0;
		
		while(control<1) {
			
			//Posicion aleatoria
			objX=ram.nextInt(dimensionX);
			objY=ram.nextInt(dimensionY);
			
			//Es obstaculo
			
			if(matriz[objX][objY] != '*' && matriz[objX][objY] != 'I') {
				matriz[objX][objY] = 'G';
				control++;
			}
			
		}
		
	
	}

    

	public Nodo[][] getmatriz() {
		return matriz;
	}



	public int[] getinicio() {
		return inicio;
	}



	public int[] getobjetivo() {
		return objetivo;
	}



	public int[][] getObstaculos() {
		return obstaculos;
	}

public Nodo getInicio() {
		
		return new Nodo(inicio[0],inicio[1]);
	}
	
	public Nodo getobjetivo() {
		
		return new Nodo(objetivo[0],objetivo[1]);
	}



	public Configuracion getCfg() {
		return cfg;
	}



	public void setCfg(Configuracion cfg) {
		this.cfg = cfg;
	}

	

}
