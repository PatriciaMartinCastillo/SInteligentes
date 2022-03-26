package Main;

public class Casilla {
	
		private int _fila, _columna, coste;
		private Casilla casAnterior;
		boolean _esObstaculo = false;
		
		public Casilla (int filaP, int columnaP){
			_fila 		= filaP;
			_columna 	= columnaP;
			casAnterior=null;
			
		}
		
		
		public int getCoste() {
			return coste;
		}

		public void setCoste(int coste) {
			this.coste = coste;
		}

		public int get_fila() {
			return _fila;
		}

		public int get_columna() {
			return _columna;
		}

		public void set_fila(int _fila) {
			this._fila = _fila;
		}

		public void set_columna(int _columna) {
			this._columna = _columna;
		}

		public boolean is_esObstaculo() {
			return _esObstaculo;
		}

		public void set_esObstaculo(boolean _esObstaculo) {
			this._esObstaculo = _esObstaculo;
		}

		public Casilla getCasAnterior() {
			return casAnterior;
		}

		public void setCasAnterior(Casilla casAnterior) {
			this.casAnterior = casAnterior;
		}
		
		
		
}


