/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busquedaarbolesbinarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Apolo
 */
public class Arbol {
    
    /**
     * Contiene la estructura del arbol
     * en una matriz
     */
    private int arbol[][];
    
    /**
     * Este vector contiene los elementos del Arbol
     * de forma ordenada segun el metodo de busqueda
     */
    private ArrayList<Integer> vector;
    
    /**
     * Objeto para leer los valores que ingrese el usuario
     */
    private final Scanner sc = new Scanner(System.in);
    
    /**
     * Profundidad del arbol igual al,
     * numero de filas de la matriz
     */
    public int niveles;
    
    /**
     * El numero de ramas es igual a la cantidad 
     * de hijos finales del arbol, define el ancho
     * del arbol
     */
    public int ramas;
        
    /**
     * Crea y define el tamaño del arbol,
     * (Por cada nuevo nivel agregado sin contar el nivel de la raiz
     * las ramas del arbol crecen por 2)
     */
    public void crear(){
        this.arbol =  new int[niveles][ramas];
    }
    
    /**
     * Carga los elementos del arbol segun el tamaño definido,
     *
     */
    public void cargarNodos(){
        
        int ultimo  = niveles - 1;
        int dividendo = ramas;
        int cordenada = 0;
        
        for(int f=0; f < niveles; f++){
            cordenada = dividendo / 2;
            for(int c=0; c < ramas; c++){
                if(f == 0 && c == 0){
                    System.out.println("Digite la Raíz ["+f+c+"]:");
                    arbol[f][c] = sc.nextInt();  
                    break; 
                }                
                if(f < ultimo){                                                            
                    System.out.println("Digite el padre-hijo ["+f+c+"]:");
                    arbol[f][c] = sc.nextInt();
                    c = (c + cordenada) - 1;
                    dividendo = cordenada;
                    continue;
                }                
                if(f == ultimo){
                    System.out.println("Digite el hijo ["+f+c+"]:");
                    arbol[f][c] = sc.nextInt();
                }                
            }
        }         
    }
    
    /**
     * Busca por anchura los elementos del arbol y los ordena en un vector
     */
    public void busquedaAmplitud(){        
        vector =  new ArrayList<Integer>();
        for(int f=0; f < niveles; f++){
            for(int c=0; c < ramas; c++){                    
                int element = arbol[f][c];
                if(element != 0){
                    vector.add(element);
                }               
            }
        }
    }
    
    /**
     * Busca por profundidad los elementos del arbol y los ordena en un vector
     */
    public void busquedaProfundidad(){
        vector =  new ArrayList<Integer>();
        for(int c=0; c < ramas; c++){  
            for(int f=0; f < niveles; f++){            
            int element = arbol[f][c];
                if(element != 0){                    
                    vector.add(element);
                }                         
            }                              
        }  
    }
    
    /**
     * Muestra en pantalla los elementos del vector ordenado
     */
    public void imprimir(){
        for( Integer element : vector){            
            if(element != 0)System.out.print(element+"-"); 
            else break;
        }  
    }
}
