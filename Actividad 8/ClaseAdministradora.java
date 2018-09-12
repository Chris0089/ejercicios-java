/*
 Christian José Amparo Sandoval
POLLO
Código 214519335
Actividad 8
 */
package claseadministradora;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.Scanner;

public class ClaseAdministradora {
    private final int INICIO_CONTADOR= 1;
    private Hashtable<Integer, Materia> tabla = new Hashtable<Integer, Materia>();
    private int contador = INICIO_CONTADOR;
    
    public int agregarMateria(String clave, String nombre)
        {
            Materia materia = new Materia(clave, nombre);
            tabla.put(contador, materia);
            return contador++;
        }
        public void quitarMateria(int idUnico)
        {
            tabla.remove(idUnico);
        }
        public Materia consultarMateria(int idUnico)
        {
            return tabla.get(idUnico);
           
        }
        public void imprime()
        {
            Enumeration<Integer> claves = tabla.keys();
            Enumeration<Materia> materias = tabla.elements();
           
            while(claves.hasMoreElements() && materias.hasMoreElements())
            {
                Materia materia = materias.nextElement();
                System.out.println(claves.nextElement()+ " | " + materia.dameClave() + " | " + materia.dameNombre());
            }
        }
  
    class Materia
    {
        private String clave, nombre;
        
        private Materia(String unaClave, String unNombre)
        {
            clave = unaClave;
            nombre = unNombre;
        }
        public String dameClave()
        {
            return clave;
        }
        public String dameNombre()
        {
            return nombre;
        }
        
    }
    
    public static void main(String[] args) {
        ClaseAdministradora admin = new ClaseAdministradora();
        Scanner scanner = new Scanner(System.in);
        int opcion=0, id;
        String clave, nombre;
        //Valores por defecto//
        admin.agregarMateria("I521", "Administración de redes");
        admin.agregarMateria("I531", "Sistemas Operativos");
        admin.agregarMateria("I711", "Inteligencia artificial");
        
        
        while(opcion!=5)
        {
            System.out.println("[][][][] Actividad 8 [][][][] \n");
            System.out.println("Tabla completa:");
            admin.imprime();
            System.out.println("\n Escribe la opción que deseas acceder:");
            System.out.println("1.Registrar materia");
            System.out.println("2.Borrar materia");
            System.out.println("3.Obtener materia");
            System.out.println("4.Imprimir tabla");
            System.out.println("5.Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:  
                    System.out.println("Registrar Materia");
                    System.out.println("Escribe la clave de la materia");
                    clave = scanner.next();
                    System.out.println("Escribe el nombre de la materia");
                    nombre = scanner.next();
                    admin.agregarMateria(clave, nombre);
                    admin.imprime();
                    break;
                case 2:  
                    System.out.println("Eliminar Materia");
                    System.out.println("Escribe el id de la materia que quieres eliminar");
                    id = scanner.nextInt();
                    admin.quitarMateria(id);
                    admin.imprime();
                    break;
                case 3:  
                    System.out.println("Obtener Materia");
                    System.out.println("Escribe el id de la materia que quieres obtener");
                    id = scanner.nextInt();
                    admin.consultarMateria(id);
                    admin.imprime();
                    break;
                case 4:
                    System.out.println("Imprimir la tabla");
                    admin.imprime();
                    break;
                case 5:  System.out.println("Bye bye");
                         break;
                default: 
                    System.out.println("Hola bb, la opcion es incorrecta");
                    break;
            }
        }
    }
}
