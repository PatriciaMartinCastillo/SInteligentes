package Main;
import java.util.Random;

public class Problema {
	
	
	// Construimos Estado Inicial, Final y Malla de obst√°culos en esta clase.
	
	private Casilla [] [] 	campoBatalla;
	private int[] inicioRobot;
	private int[] finalRobot;
	private int[][] obstaculos;
	private Configuracion cfg;
	
	public Problema (Configuracion cfg){
		
		campoBatalla= new Casilla[cfg.getNumFila()][cfg.getNumColumna()];
		this.cfg=cfg;

		
		for(int i=0;i<cfg.getNumFila();i++) {
			for(int j=0;j<cfg.getNumColumna();j++) {
				Casilla cas = new Casilla(i,j);
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
			
			//Compruebo que en esa posiciÛn no se encuentre otro obstaculo
					
				if(!campoBatalla[pos1][pos2]._esObstaculo) {
							
					campoBatalla[pos1][pos2].set_esObstaculo(true);
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
			
			if(!campoBatalla[pos1][pos2]._esObstaculo) {
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
			
			if(!campoBatalla[pos1][pos2]._esObstaculo) {
				finalRobot[0]=pos1;
				finalRobot[1]=pos2;
				control++;
			}
			
		}
		
	
	}



	public Casilla[][] getCampoBatalla() {
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

public Casilla getInicio() {
		
		return new Casilla(inicioRobot[0],inicioRobot[1]);
	}
	
	public Casilla getFinal() {
		
		return new Casilla(finalRobot[0],finalRobot[1]);
	}



	public Configuracion getCfg() {
		return cfg;
	}



	public void setCfg(Configuracion cfg) {
		this.cfg = cfg;
	}

	

}
