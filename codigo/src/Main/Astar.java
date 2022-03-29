package Main;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.*;

public class Astar {

    private Laberinto lab;
    private ArrayList<Nodo> abiertos, cerrados, solucion;
    


    public Astar(Laberinto lab){
        this.lab = lab;
        Nodo padre = new Nodo(lab.getIniX(), lab.getIniX(),null);
        Tree<Nodo> arbol = new Tree<Nodo>(padre);
        
        

        abiertos = new ArrayList<Nodo>();

        calcularSucesores(padre, abiertos);

        cerrados = new ArrayList<Nodo>();



        if (abiertos == null){
            throw new RuntimeException("FRACASO");
        }







    }

    public boolean objetivo(Nodo n){
        return n.cordX == lab.objX && n.cordY == lab.objY;
    }
    
    public void calcularSucesores(Nodo nodo, ArrayList<Nodo> abiertos){
		
		int i = nodo.getcordX();
		int j = nodo.getcordY();
		
		
		if(esValido(i+1,j,this.lab)) { //arriba
			abiertos.add(new Nodo(i+1,j,nodo));
		}
		
		if(esValido(i,j-1,this.lab)) { // izquierda
			abiertos.add(new Nodo(i,j-1,nodo));
		}
		
		if(esValido(i-1,j,this.lab)) { //abajo
			abiertos.add(new Nodo(i-1,j,nodo));
		}
		
		
		if(esValido(i,j+1,this.lab)) { // derecha
			abiertos.add(new Nodo(i,j+1,nodo));
		}
		
	}

    public boolean esValido(int cordX, int cordY, Laberinto lab)
    {
        boolean res = false;
        if((lab.getValor(cordX,cordY)!='*') && (cordX < lab.dimensionX && cordY < lab.dimensionY) && (cordX >= 0 && cordY >= 0))
        {
            res= true;
        }
        return res;
    }

    public int getManhattan(Nodo n){
        int res;
        res = (Math.abs(n.cordX - this.lab.objX)) + (Math.abs(n.cordY - this.lab.objY));
        return res;
    }



}