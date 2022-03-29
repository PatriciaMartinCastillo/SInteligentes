package Main;

public class LaberintoApp {

	public static void main(String[] args) {
		
		    Laberinto lab = new Laberinto(16,16,20);
		    lab.generarLaberinto();
		    lab.mostrarLaberinto();   
		    Astar a = new Astar(lab);
		    
		    
		}

}
