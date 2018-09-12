package cadenabytes;
/**
 * Christian José Amparo Sandoval (Pollo)
 * Código; 214519335
 */
public class CadenaBytes {

    public static void main(String[] args) {
        byte[] arreglo = new byte[50];
        String cadena = "Hola bb";
        empaquetado(cadena, arreglo);
        for(int i=0; i<=cadena.length();i++)
            System.out.print(arreglo[i] + " ");
        System.out.println();
        System.out.print(desempaquetado(arreglo));
        System.out.println();   
    }

    private static void empaquetado(String cadena, byte[] arreglo) {
        byte[] auxiliar;
        auxiliar = cadena.getBytes();
        
        arreglo[0] =(byte) cadena.length();
        System.arraycopy(auxiliar, 0, arreglo, 1, cadena.length());
    }

    private static String desempaquetado(byte[] arreglo) {
        String otraCadena = new String(arreglo,1,arreglo[0]);
        return otraCadena;
    }
    
}
