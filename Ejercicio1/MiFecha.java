/* Christian Jose Amparo Sandoval - POLLO
 * Código: 214519335
 * Seminario de solución de problemas de sistemas operativos de red
 * 20 de enero de 2018
 * Si el anio es multiplo del anio es bisiesto
 * Si es multiplo de 100 no es bisiesto
 */
import java.util.Scanner;

public class MiFecha {
    //Constantes, para ponerlas en un solo archivo, las puse como atributos... [dev 0.1]
    private final int ENERO = 1, FEBRERO = 2, MARZO = 3, ABRIL = 4, MAYO = 5, JUNIO = 6, JULIO=7;
    private final int AGOSTO = 8, SEPTIEMBRE =9, OCTUBRE = 10, NOVIEMBRE =11, DICIEMBRE = 12;
    private final int LIMITEDIA = 31, LIMITEMES = 12, LIMITEFEBRERO = 28, LIMITEOTROMES = 30, LIMITEBISIESTO=29;
    private final int DIAACTUAL = 20, MESACTUAL = 01, ANIOACTUAL = 2018;
    private final int EXCEPCIONBISIESTO = 100, BISIESTO = 4;
    //Fin de pseudo constantes
    
    private  int dia, mes, anio;
    
    public MiFecha()
    {
        dia = DIAACTUAL;
        mes = MESACTUAL;
        anio = ANIOACTUAL;
    }
    private boolean verificacion(int valorDia, int valorMes, int valorAnio)
    {
        if (valorDia <= 0 || valorDia > LIMITEDIA || valorMes <= 0  || valorMes > LIMITEMES)
        {
            return false;
        }else if ((valorMes == ABRIL || valorMes == JUNIO || valorMes == SEPTIEMBRE || valorMes == NOVIEMBRE) && (valorDia == LIMITEOTROMES))
        {
            return false;
        }
        else if (valorMes == FEBRERO)
        {
            if (valorDia > LIMITEBISIESTO)
            {
                return false;
            }else if ( valorAnio % EXCEPCIONBISIESTO == 0 && valorDia == LIMITEBISIESTO)
            {
                return false;
            }else if (valorAnio % BISIESTO != 0 && valorDia == LIMITEBISIESTO )
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }
    public int dameDia()
    {
        return dia;
    }
    public int dameMes()
    {
        return mes;
    }
    public int dameAnio()
    {
        return anio;
    }
    public boolean fijaDia(int numero)
    {
        dia = numero;
        return true;
    }
    public boolean fijaMes(int numero)
    {
        mes = numero;
        return true;
    }
    public boolean fijaAnio(int numero)
    {
        anio = numero;
        return true;
    }
    public static void main (String []args){
        MiFecha miFecha = new MiFecha();
        Scanner cin= new Scanner(System.in); 
        int SALIR = 4;
        int menu_opcion = 0;
        int temp_dia, temp_mes, temp_anio;
        do{
            System.out.print("La fecha actual es: ");
            System.out.print(miFecha.dameDia());
            System.out.print("/");
            System.out.print(miFecha.dameMes());
            System.out.print("/");
            System.out.print(miFecha.dameAnio());
            System.out.println(".");
            System.out.println("Selecciona la opción a la que deseas acceder:");
            System.out.println("1- Modificar dia");
            System.out.println("2- Modificar mes");
            System.out.println("3- Modificar anio");
            System.out.println("4- Salir");
            menu_opcion=cin.nextInt();
            
            switch(menu_opcion){
            case 1:
                System.out.println("Escribe el dia: ");
                temp_dia=cin.nextInt();
                if( miFecha.verificacion(temp_dia, miFecha.dameMes(), miFecha.dameAnio()))
                {
                 miFecha.fijaDia(temp_dia);
                }else
                {
                    System.out.println("La fecha es incorrecta");
                }
                break;
            case 2:
                System.out.println("Escribe el mes: ");
                temp_mes=cin.nextInt();
                if( miFecha.verificacion(miFecha.dameDia(), temp_mes, miFecha.dameAnio()))
                {
                 miFecha.fijaMes(temp_mes);
                }else
                {
                    System.out.println("La fecha es incorrecta");
                }
                break;
            case 3:
                System.out.println("Escribe el anio: ");
                temp_anio=cin.nextInt();
                if( miFecha.verificacion(miFecha.dameDia(), miFecha.dameMes(), temp_anio))
                {
                 miFecha.fijaAnio(temp_anio);
                }else
                {
                    System.out.println("La fecha es incorrecta");
                }
                break;
         
        }
            
        }while (menu_opcion != SALIR);
    }
}
