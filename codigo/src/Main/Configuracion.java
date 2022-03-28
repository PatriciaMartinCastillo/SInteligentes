package Main;

public class Configuracion {
	int _numObstaculos, _semilla;
	
	int numPixelFila, numPixelCol, _tamCelda, nfila, nColumna	;
	
	
			
			
	public Configuracion( ){
		_numObstaculos	=  20;
		_semilla		=  100;
		cfg_ini();
	}
	
	
	Configuracion(int obstaculos, int semilla){
		
		_numObstaculos = obstaculos;
		_semilla		   = semilla;
		
		cfg_ini();
	}
	
	private void cfg_ini() {
		 numPixelFila	= 800;
		 numPixelCol	= 600;
		 _tamCelda 		= 50;
		
		 nfila      =  numPixelFila / _tamCelda;
		 nColumna	= numPixelCol  / _tamCelda;
	}
	
	public int getNumObstaculos () {
		return _numObstaculos;
	}
	
	public int getSemilla () {
		return _semilla;
	}
	
	public int getTamCelda() {
		return _tamCelda;
	}
	
	public int getNumPixelFila() {
		return numPixelFila;
	}
	
	public int getnumPixelCol() {
		return numPixelCol;
	}
	
	public int getNumFila() {
		return nfila;
	}
	
	public int getNumColumna() {
		return nColumna;
	}
}