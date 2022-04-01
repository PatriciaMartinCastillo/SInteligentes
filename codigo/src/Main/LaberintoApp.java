package Main;

public class LaberintoApp {

	public static void main(String[] args) {
		
		    Laberinto lab = new Laberinto(60,80,30);
		    lab.generarLaberinto();
		    lab.mostrarLaberinto();   
		    Astar a = new Astar(lab);
		    lab.pintarsolucion(a.solucion);
			lab.mostrarLaberinto();
			System.out.println("EL COSTE DE LA SOLUCION ES: " + a.costeSol);
		}	
}
