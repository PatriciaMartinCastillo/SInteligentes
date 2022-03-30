package Main;
import java.lang.Math.*;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import java.util.*;

public class Astar {

    Laberinto lab;
    ArrayList<Nodo> abiertos, cerrados;
    ArrayList<Nodo> solucion;
    


    public Astar(Laberinto lab){
        this.lab = lab;
        Nodo padre = new Nodo(lab.getIniX(), lab.getIniY(),null);
        padre.setcosteG(0);
        
        abiertos = new ArrayList<Nodo>();
        cerrados = new ArrayList<Nodo>();
        solucion = new ArrayList<Nodo>();

        System.out.println(abiertos.toString());

        abiertos.add(padre);
        System.out.println(abiertos.toString());

        calcularSucesores(padre);
        System.out.println(abiertos.toString());

        if (abiertos == null){
            throw new RuntimeException("FRACASO");
        }

        padre = abiertos.get(0);
        while ((padre.getcordX() == lab.objX && padre.getcordY() == lab.objY)!= true) {
            padre = calcularSucesores(padre); // calcula sucesores del padre, lo elimina de abiertos y lo añade a cerrados
            System.out.print(padre.getcordX());
            System.out.println(padre.getcordY()); // da el valor almacenado en el nodo padre
        }

        cerrados.add(padre);
        System.out.println("Donete :)");

        while(padre.getcordX()!=lab.getIniX() && padre.getcordY()!=lab.getIniY())
        {
            solucion.add(padre);
            padre=padre.getpadre();
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
	    if(esValido(i+1,j,this.lab) && estacerrado(cerrados, hijo) && estacogido(abiertos, hijo)) { //arriba
            System.out.print("Nodo abierto creado en: ");
            System.out.print(hijo.getcordX());
            System.out.println(hijo.getcordY());
	        abiertos.add(hijo);
	    }
    }
    if(i>0){		
        Nodo hijo = new Nodo(i-1,j,nodo);
		if(esValido(i-1,j,this.lab) && estacerrado(cerrados, hijo) && estacogido(abiertos, hijo)) { //abajo
            System.out.print("Nodo abierto creado en: ");
            System.out.print(hijo.getcordX());
            System.out.println(hijo.getcordY());
			abiertos.add(hijo);
		}
    }	
	if(j>0){	
        Nodo hijo = new Nodo(i,j-1,nodo);	
		if(esValido(i,j-1,this.lab) && estacerrado(cerrados, hijo) && estacogido(abiertos, hijo)) { // izquierda
            System.out.print("Nodo abierto creado en: ");
            System.out.print(hijo.getcordX());
            System.out.println(hijo.getcordY());
			abiertos.add(hijo);
		}
    }
    if(j<lab.dimensionY-1){	
        Nodo hijo = new Nodo(i,j+1,nodo);	
		if(esValido(i,j+1,this.lab) && estacerrado(cerrados, hijo) && estacogido(abiertos, hijo)) { // derecha
            System.out.print("Nodo abierto creado en: ");
            System.out.print(hijo.getcordX());
            System.out.println(hijo.getcordY());
			abiertos.add(hijo);
		}
    }
    cerrados.add(nodo);
    abiertos.remove(nodo);
    Nodo hijo = elegirhijo(abiertos);
	return hijo;

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
    public boolean estacerrado(ArrayList<Nodo> cerrados, Nodo hijo)
    {
        boolean yes = true; //es al reves para no liarla luego arriba
        Iterator<Nodo> i = cerrados.iterator();
        while(i.hasNext())
        {
            if(i.next().mismaPos(hijo)==true)
            {
                yes= false; //es al reves para no liarla luego arriba
            }
        }
        return yes;

    }

    public boolean estacogido(ArrayList<Nodo> abiertos, Nodo hijo)
    {
        boolean yes = true; //es al reves para no liarla luego arriba
        Iterator<Nodo> i = abiertos.iterator();
        while(i.hasNext())
        {
            if(i.next().mismaPos(hijo)==true)
            {
                yes= false; //es al reves para no liarla luego arriba
            }
        }
        return yes;
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
}


