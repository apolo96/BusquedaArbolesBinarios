package busquedaarbolesbinarios;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Busqueda por Amplitud (Anchura) en Árboles
 * @author José Miguel Llanos M
 * Fecha: 31-Ago-2016
 */
public class AmplitudRefactoring {
    
    private static int  matriz[][];
    
    private static ArrayList<Integer> vector;
    
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int niveles;
        int ramas;
        
        // Solicito los Niveles y Ramas para el cargue del árbol
        System.out.println("Digite la cantidad de Niveles:");
        niveles = sc.nextInt();
        
        System.out.println("Digite la cantidad de Ramas:");
        ramas = sc.nextInt();
        
        // Niveles = Filas
        // Ramas = Columnas
        // Defino la matriz m para cargar los elementos del Árbol
        matriz = new int[niveles][ramas];
        
        cargarElementos(niveles, ramas);
               
        //buscarAmplitud(niveles, ramas);
        
        buscarProfundidad(niveles, ramas);
        
        //dFS(0,niveles);
        // Defino un vector para cargar los elementos que se recorren por amplitud
        
        imprimir();
    }
    
    private static void cargarElementos(int niveles, int ramas){
        int ultimo  = niveles - 1;
        int controlador = 1;
        int conmutador = 0;
        int dividendo = ramas;
        int cordenada = dividendo / 2;
        
        for(int f=0; f < niveles; f++){
            for(int c=0; c < ramas; c++){
                if(f == 0 && c == 0){
                    System.out.println("Digite la Raíz ["+f+c+"]:");
                    matriz[f][c] = sc.nextInt();  
                    controlador += controlador;
                    break; 
                }                
                if(f < ultimo){                                                            
                    if(conmutador == controlador){
                        controlador += controlador;
                        dividendo = cordenada;
                        cordenada = dividendo / 2;
                        conmutador = 0;
                        break;
                    }
                    System.out.println("Digite el padre-hijo ["+f+c+"]:");
                    matriz[f][c] = sc.nextInt();
                    c = (c + cordenada) - 1;
                    if(c == (ramas - 1))c--;
                    conmutador++;
                    continue;
                }                
                if(f == ultimo){
                    System.out.println("Digite el hijo ["+f+c+"]:");
                    matriz[f][c] = sc.nextInt();
                }                
            }
        }         
    }
    
    private static void buscarAmplitud(int niveles, int ramas){        
        vector =  new ArrayList<Integer>();
        for(int f=0; f < niveles; f++){
            for(int c=0; c < ramas; c++){                    
                int element = matriz[f][c];
                if(element != 0){
                    vector.add(element);
                }               
            }
        }
    }
    
    private static void buscarProfundidad(int niveles, int ramas)
    {
        vector =  new ArrayList<>();
        for(int c=0; c < ramas; c++){  
            for(int f=0; f < niveles; f++){            
            int element = matriz[f][c];
                if(element != 0){                    
                    vector.add(element);
                }                         
            }                              
        }  
//        vector =  new ArrayList<>();
//        ArrayList<Integer> visitado = new ArrayList<>();
//        visitado.add(0);
//        for(int c=0; c < ramas; c++){  
//            for(int f=0; f < niveles; f++){            
//            int element = matriz[f][c];
//                if(element != 0){                    
//                    if(element != visitado.get(f))
//                    {
//                        vector.add(element);
//                        visitado.add(element);
//                    }
//                }                         
//            }                              
//        }                     
    }
    
    private static void dFS(int u,int niveles){
        vector =  new ArrayList<>();
        ArrayList<Integer> visitado = new ArrayList<>();
        if(u == 0)visitado.add(0);
        for (int f = 0; f < niveles; f++) {
                int element = matriz[f][u];
                if(element != 0){                    
                    if(element != visitado.get(f))
                    {                        
                        vector.add(element);
                        visitado.add(element);                                                                  
                    } else{
                        dFS(u+1,niveles);
                    }
                }                          
        } 
        dFS(u+1,niveles);
    }    
    
    private static void imprimir(){
        // Finalmente imprimo la búsqueda generada por amplitud
        for( Integer element : vector){            
            if(element != 0)System.out.print(element+"-"); 
            else break;
        }  
    }
}
