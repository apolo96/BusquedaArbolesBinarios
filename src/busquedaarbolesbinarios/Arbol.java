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
    
    private int arbol[][];
    
    private ArrayList<Integer> vector;
    
    private final Scanner sc = new Scanner(System.in);
    
    public int niveles;
    
    public int ramas;
        
    public void crear(){
        this.arbol =  new int[niveles][ramas];
    }
    
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
    
    public void imprimir(){
        for( Integer element : vector){            
            if(element != 0)System.out.print(element+"-"); 
            else break;
        }  
    }
}
