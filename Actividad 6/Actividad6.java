/*
   Actividad 6
   Christian José Amparo Sandoval
   POLLO
   Código: 214519335 
 */
package actividad6;
    
public class Actividad6 {
    
    private void metodo1(int valor1, int valor2){
        valor1 = valor1 * valor2;
        System.out.println("La multiplicacion de a y b es: " + valor1);
        valor2 = valor1 + valor2;
        System.out.println("La suma de a y b es: " + valor2);
    }
    private void metodo2(int arreglo1[], int arreglo2[]){
        arreglo1[0] = arreglo1[0] * arreglo2[0];
        System.out.println("La multiplicacion de a y b es: " + arreglo1[0]);
        arreglo2[0] = arreglo1[0] + arreglo2[0];
        System.out.println("La suma de a y b es: " + arreglo2[0]);
            }
    public static void main(String[] args) {
        Actividad6 proceso = new Actividad6();
        int a = 20;
        int[] arreglo = new int[1];
        arreglo[0] = a;
        System.out.println("Antes, el valor de a es: " + a);
        proceso.metodo1(a,a);
        System.out.println("Despues, el valor de a es: " + a);
        System.out.println("Antes, el valor de arreglo es: " + arreglo[0]);
        proceso.metodo2(arreglo, arreglo);
        System.out.println("Despues, el valor de arreglo es: " + arreglo[0]);
    }
    
}
