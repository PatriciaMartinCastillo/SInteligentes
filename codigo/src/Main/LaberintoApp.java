package Main;

public class LaberintoApp {

	public static void main(String[] args) {
		
		    Laberinto lab = new Laberinto(20,20,30);
		    lab.generarLaberinto();
		    lab.mostrarLaberinto();   
		    Astar a = new Astar(lab);
		    
		    
		}

}
