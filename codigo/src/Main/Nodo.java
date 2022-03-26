package Main;

public class Nodo {
	
		private int cordX, cordY, costeG;
		private Nodo padre;
		boolean esObstaculo = false;
		
		public Nodo (int filaP, int columnaP){
			cordX = filaP;
			cordY = columnaP;
			padre = null;
			
		}
		
		public boolean mismaPos(Nodo n){
			boolean res = false;
			if (this.cordX ==  n.cordX && this.cordY == n.cordY){
				res=true;
			}
			return res;
		}
		
		public int getcosteG() {
			return costeG;
		}

		public void setcosteG(int costeG) {
			this.costeG = costeG;
		}

		public int getcordX() {
			return cordX;
		}

		public int getcordY() {
			return cordY;
		}

		public void setcordX(int cordX) {
			this.cordX = cordX;
		}

		public void setcordY(int cordY) {
			this.cordY = cordY;
		}

		public boolean isesObstaculo() {
			return esObstaculo;
		}

		public void setesObstaculo(boolean esObstaculo) {
			this.esObstaculo = esObstaculo;
		}

		public Nodo getpadre() {
			return padre;
		}

		public void setpadre(Nodo padre) {
			this.padre = padre;
		}
		
		
		
}


