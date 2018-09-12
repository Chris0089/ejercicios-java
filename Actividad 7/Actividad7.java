/*
    Actividad 7
    Christian José Amparo Sandoval
    POLLO
    Código: 214519335
 */
package actividad7;

public class Actividad7 {
    private int indice_modificados = 0;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String palabra = "CHIVAS";
    private char[] arreglo_modificados = new char[50];
    
    public void generacionAleatoria(char[] arreglo){       
        for(int i=0; i<arreglo.length; i++){
            int aleatorio=(int) (Math.random()*alfabeto.length()); //seed
            arreglo[i]=alfabeto.charAt(aleatorio);
        }
    }
    public void generacionFinal(char[] arreglo){
        int j=0;
        for(int i=0; i<arreglo.length; i++){
             if(palabra.charAt(j)!=arreglo[i]){
                arreglo_modificados[indice_modificados]=palabra.charAt(j);
                indice_modificados++;
            }
            arreglo[i]=palabra.charAt(j);    
            if(j>=palabra.length()-1){
                j=0;
                if(arreglo.length - i < palabra.length())
                    break;
            }else{
                j++;
            }
        }
    }
    public void imprimirArregloModificados(){
        for(int i=0; i<arreglo_modificados.length; i++)
            System.out.print(arreglo_modificados[i]);
    }
     
    public static void main(String[] args) {
        Actividad7 act7 = new Actividad7();
        char[] arreglo = new char[50];
        act7.generacionAleatoria(arreglo);
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i]);
        System.out.println(" ");
        act7.generacionFinal(arreglo);
        for(int i=0; i<arreglo.length; i++)
            System.out.print(arreglo[i]);
        System.out.println(" ");
        act7.imprimirArregloModificados();
  
        
        
    }
    
}
