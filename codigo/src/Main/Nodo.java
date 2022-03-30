package Main;

public class Nodo {
	
		int cordX;
		int cordY;
		private int costeG;
		private Nodo padre;
		
		
		public Nodo (int cordX, int cordY, Nodo padre){
			this.cordX = cordX;
			this.cordY = cordY;
			this.padre = padre;
			
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

		public Nodo getpadre() {
			return padre;
		}

		public void setpadre(Nodo padre) {
			this.padre = padre;
		}
		
		
		
}


