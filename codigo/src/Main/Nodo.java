package Main;

public class Nodo {
	
		private int cordX;
		private int cordY;
		private int costeG;
		private Nodo padre;
		
		
		public Nodo (int cordX, int cordY, Nodo padre){
			this.cordX = cordX;
			this.cordY = cordY;
			this.padre = padre;
			this.costeG = 0;
			
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
			return this.cordX;
		}

		public int getcordY() {
			return this.cordY;
		}
 		void setcordY(int cordY) {
			this.cordY = cordY;
		}

		public Nodo getpadre() {
			return padre;
		}

		public void setpadre(Nodo padre) {
			this.padre = padre;
		}
		
		
		
}


