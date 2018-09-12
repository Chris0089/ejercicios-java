package conversor;
/**
 * Christian José Amparo Sandoval
 * Código: 0103978
 */
public class Conversor {
    private final byte NUMERO_BYTE =  0x45;
    private final short NUMERO_SHORT = 0x7F7F;
    private final int NUMERO_INT = 0x75757575;
    private final long NUMERO_LONG = 0x7F7F7F7F7F7F7F7FL;
    
    private byte get_byte(){
        return NUMERO_BYTE;
    }
    private short get_short(){
        return NUMERO_SHORT;
    }
    private int get_int(){
        return NUMERO_INT;
    }
    private long get_long(){
        return NUMERO_LONG;
    }
    private void ejecucion(byte valor){
        int testeo = 0x20;
        for (int i=0; i<8; i++)
        {
            if(i%8==0)
                System.out.print( "|" );
            else if((valor&testeo)==0)
              System.out.print( "0" );
            else
                System.out.print( "1" );
            
            testeo = testeo >>> 1 ;
        }
        System.out.println("|");
    }
    private void ejecucion(short valor){
        int testeo = 0x4000;
        for (int i=0; i<16; i++)
        {
            if(i%8==0)
                System.out.print( "|" );
            else if((valor&testeo)==0)
              System.out.print( "0" );
            else
                System.out.print( "1" );
            
            testeo = testeo >>> 1 ;
        }
        System.out.println("|");
    }
    private void ejecucion(int valor){
        int testeo = 0x80000000;
        for (int i=0; i<32; i++)
        {
            if(i%8==0)
                System.out.print( "|" );
            else if((valor&testeo)==0)
              System.out.print( "0" );
            else
                System.out.print( "1" );
            
            testeo = testeo >>> 1 ;
        }
        System.out.println("|");
    }
    private void ejecucion(long valor){
        long testeo = 0x8000000000000000L;
        for (int i=0; i<64; i++)
        {
            if(i%8==0)
                System.out.print( "|" );
            else if((valor&testeo)==0)
              System.out.print( "0" );
            else
                System.out.print( "1" );
            
            testeo = testeo >>> 1 ;
        }
        System.out.println("|");
    }
    
    
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        conversor.ejecucion(conversor.get_byte());
        conversor.ejecucion(conversor.get_short());
        conversor.ejecucion(conversor.get_int());
        conversor.ejecucion(conversor.get_long());
        
    }
    
}
