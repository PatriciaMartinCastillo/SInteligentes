package Main;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.*;

public class Astar {

    private Laberinto lab;
    private ArrayList<Nodo> abiertos, cerrados, solucion;
    


    public Astar(Laberinto lab){
        this.lab = lab;
        Nodo padre = new Nodo(lab.getIniX(), lab.getIniY(),null);
        Tree<Nodo> arbol = new Tree<Nodo>(padre);
        abiertos = new ArrayList<Nodo>();
        System.out.println(abiertos.toString());
        abiertos.add(padre);
        System.out.println(padre.cordX + "|" + padre.cordY);
        System.out.println(abiertos.toString());
        calcularSucesores(padre);
        System.out.println(abiertos.toString());
        
        Iterator<Nodo> i = abiertos.iterator();
        while (i.hasNext()) {
        	Nodo temp = i.next();
        	System.out.println(temp.cordX + "|" + temp.cordY);
        	System.out.println(String.valueOf(lab.getValor(temp.cordX, temp.cordY)));
        }
        

        cerrados = new ArrayList<Nodo>();
        
        
        
        
        
        
        
        if (abiertos == null){
            throw new RuntimeException("FRACASO");
        }
        
        







    }

    public boolean objetivo(Nodo n){
        return n.cordX == lab.objX && n.cordY == lab.objY;
    }
    
    public void calcularSucesores(Nodo nodo){
		
		int i = nodo.getcordX();
		int j = nodo.getcordY();
		
		
		if(esValido(i+1,j,this.lab) && lab.getValor(i+1,j) != '*') { //arriba
			abiertos.add(new Nodo(i+1,j,nodo));
		}
		
		if(esValido(i,j-1,this.lab) && lab.getValor(i,j-1) != '*') { // izquierda
			abiertos.add(new Nodo(i,j-1,nodo));
		}
		
		if(esValido(i-1,j,this.lab) && lab.getValor(i-1,j) != '*') { //abajo
			abiertos.add(new Nodo(i-1,j,nodo));
		}
		
		
		if(esValido(i,j+1,this.lab) && lab.getValor(i,j+1) != '*') { // derecha
			abiertos.add(new Nodo(i,j+1,nodo));
		}
		
	}

    public boolean esValido(int cordX, int cordY, Laberinto lab)
    {
        boolean res = true;
        if(cordX >= lab.dimensionX || cordY >= lab.dimensionY || (cordX < 0 || cordY < 0)){
            res= false;
        }
        return res;
    }
    
    public boolean noEsObstaculo(int cordX, int cordY, Laberinto lab) {
    	boolean res = true;
    	if(lab.getValor(cordX,cordY) == '*') {
    		res = false;
    	}
    	return res;
    	
    }

    public int getManhattan(Nodo n){
        int res;
        res = (Math.abs(n.cordX - this.lab.objX)) + (Math.abs(n.cordY - this.lab.objY));
        return res;
    }



}