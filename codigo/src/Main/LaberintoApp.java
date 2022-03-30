package Main;

public class LaberintoApp {

	public static void main(String[] args) {
		
		    Laberinto lab = new Laberinto(60,80,20);
		    lab.generarLaberinto();
		    lab.mostrarLaberinto();   
		    Astar a = new Astar(lab);
		    lab.pintarsolucion(a.solucion);
			lab.mostrarLaberinto();


		}

}
