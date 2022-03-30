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
        padre.setcosteG(0);
        
        abiertos = new ArrayList<Nodo>();
        cerrados = new ArrayList<Nodo>();

        System.out.println(abiertos.toString());

        abiertos.add(padre);
        System.out.println(abiertos.toString());

        calcularSucesores(padre);
        System.out.println(abiertos.toString());

        

        padre = abiertos.get(0);
        while ((padre.getcordX() == lab.objX && padre.getcordY() == lab.objY)!= true) {
            padre = calcularSucesores(padre); // calcula sucesores del padre, lo elimina de abiertos y lo añade a cerrados
            System.out.println(String.valueOf(lab.getValor(padre.getcordX(), padre.getcordY()))); // da el valor almacenado en el nodo padre
        }
  
        if (abiertos == null){
            throw new RuntimeException("FRACASO");
        }
        
    }

    public boolean objetivo(Nodo n){
        return n.getcordX() == lab.objX && n.getcordY() == lab.objY;
    }
    
    public Nodo calcularSucesores(Nodo nodo){
		
		int i = nodo.getcordX();
		int j = nodo.getcordY();

		
	if(i<lab.dimensionX-1){
        Nodo hijo = new Nodo(i+1,j,nodo);
	    	if(esValido(i+1,j,this.lab) && (cerrados.contains(hijo)!=true) && (abiertos.contains(hijo)!=true)) { //arriba
	    		abiertos.add(hijo);
	    	}
    }
	if(j>0){	
        Nodo hijo = new Nodo(i,j-1,nodo);	
		if(esValido(i,j-1,this.lab) && (cerrados.contains(hijo)!=true)&& (abiertos.contains(hijo)!=true)) { // izquierda
			abiertos.add(hijo);
		}
    }
    if(i>0){		
        Nodo hijo = new Nodo(i-1,j,nodo);
		if(esValido(i-1,j,this.lab) && (cerrados.contains(hijo)!=true)&& (abiertos.contains(hijo)!=true)) { //abajo
			abiertos.add(hijo);
		}
    }	
    if(j<lab.dimensionY-1){	
        Nodo hijo = new Nodo(i,j+1,nodo);	
		if(esValido(i,j+1,this.lab) && (cerrados.contains(hijo)!=true)&& (abiertos.contains(hijo)!=true)) { // derecha
			abiertos.add(hijo);
		}
    }
    
    abiertos.remove(nodo);
    cerrados.add(nodo);
	return elegirhijo(abiertos);

	}

    public boolean esValido(int x, int y, Laberinto lab)
    {
        boolean res = true;
        if(lab.getValor(x,y)=='*')
        {
            res= false;
        }
        return res;
    }
    public int getH(Nodo n){
        int res;
        res = (Math.abs(n.getcordX() - this.lab.objX)) + (Math.abs(n.getcordY() - this.lab.objY));
        return res;
    }
    public void getG(Nodo nodo,int coste){
        if(nodo.getpadre()==null){
            nodo.setcosteG(coste);
        }else{
            nodo.setcosteG(nodo.getpadre().getcosteG()+coste);
        }
    }

    public Nodo elegirhijo(ArrayList<Nodo> abiertos)
    {
        int menor;
        Iterator<Nodo> i = abiertos.iterator();
        Nodo temp= i.next(), res = temp; 
        menor= temp.getcosteG() + getH(temp);
        while (i.hasNext())
        {
            if(menor > temp.getcosteG()+getH(temp))
            {
                menor= temp.getcosteG()+getH(temp);
                res= temp;
            }
            temp= i.next(); 
        }
        if (menor> temp.getcosteG()+getH(temp))
        {
            menor = temp.getcosteG()+getH(temp);
            res=temp;
        } 
        return res;
    }
;
    }


