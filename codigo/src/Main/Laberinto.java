package Main;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class Laberinto {
	
	
	// Construimos Estado Inicial, objetivo y Malla de obstáculos en esta clase.
	
	public char [] [] 	matriz;
	int dimensionX;
	int dimensionY;
	private int iniX, iniY;
	int objX;
	int objY;
	private int prb;
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
			setIniX(ram.nextInt(dimensionX));
			setIniY(ram.nextInt(dimensionY));
			matriz[getIniX()][getIniY()] = 'I';

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
			System.out.println("");
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
	public void setIniY(int iniY) {
		this.iniY = iniY;
	}
	public int getObjY(){
        return objY; 
    }
    public int getObjX(){
        return objX; 
	}
	public void pintarsolucion(ArrayList<Nodo> solucion)
	{	
		Iterator<Nodo> i = solucion.iterator();
		Nodo temp = i.next();
		while (i.hasNext())
		{
			if(matriz[temp.getcordX()][temp.getcordY()]!='G' || (matriz[temp.getcordX()][temp.getcordY()]!='I')){
			matriz[temp.getcordX()][temp.getcordY()]='+';
			temp = i.next();
			}
		}

	}
	
}
