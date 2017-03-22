
package busquedaarbolesbinarios;

import java.util.Scanner;

/**
 *
 * @author Apolo
 */
public class BusquedaArbolesBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Arbol arbol = new Arbol();
        
        System.out.println("Digite la cantidad de Niveles:");
        arbol.niveles = sc.nextInt();
        
        System.out.println("Digite la cantidad de Ramas:");
        arbol.ramas = sc.nextInt();
        
        arbol.crear();        
        arbol.cargarNodos();
        arbol.busquedaProfundidad();
        arbol.imprimir();
    }
    
}
