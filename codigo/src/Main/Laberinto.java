package Main;
import java.util.Random;

public class Laberinto {
	
	
	// Construimos Estado Inicial, objetivo y Malla de obstáculos en esta clase.
	
	private char [] [] 	matriz;
	int dimensionX;
	int dimensionY;
	private int iniX, iniY;
	int objX;
	int objY;
	private int prb;
	private Configuracion cfg;
	Boolean solucionable;

	// HECHO EL CONSTRUCTOR
	public Laberinto (int dimensionX, int dimensionY, int prob){
		
		
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		matriz= new char[dimensionX][dimensionY];
		prb = prob;
		
	}
		
		public void generarLaberinto(){

			for(int i=0;i<dimensionX;i++) {
				for(int j=0;j<dimensionY;j++) {
					matriz[i][j]= ' ';
				}
			}
			Random ram = new Random();		

			// ram.setSeed(semilla);		
		
			int control=0;

			//Inicio
			this.iniX = ram.nextInt(dimensionX);
			this.iniY = ram.nextInt(dimensionY);
			matriz[iniX][iniY] = 'I';

			//Objetivo
			while(control<1){
				objX=ram.nextInt(dimensionX);
				objY=ram.nextInt(dimensionY);
				if(matriz[objX][objY] != 'I') {
					matriz[objX][objY] = 'G';
					control++;
				}
			}

			//Obstaculos
			//Si no es inicio, no es fin y no entra en probabilidad entonces es obstaculo
			for(int i=0;i<dimensionX;i++) {
				for(int j=0;j<dimensionY;j++) {
					if(matriz[i][j]!='G' && matriz[i][j]!='I' && ram.nextInt(100)<prb){
						matriz[i][j]= '*';
					}
				}
			}		
		
		}

	public void mostrarLaberinto(){
		for(int i=0;i<dimensionX;i++) {
			System.out.print("|");
			for(int j=0;j<dimensionY;j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.print("|");
			System.out.print("\n");
		}
	}

	public int getValor(int cordX, int cordY){
		return matriz[cordX][cordY];
	}

	public int getIniX() {
		return iniX;
	}
	
	public int getIniY() {
		return iniY;
	}

	public void setIniX(int iniX) {
		this.iniX = iniX;
	}

	
}
