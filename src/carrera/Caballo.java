/**
 * clase que contiene la creacion del hilo y lo que ejecutara
 * @author Juan Ricardo Rodriguez Campos - Juan David Reyes
 * @verion 1.0.0
 * @since Carrera con numeros Random 1.0.0
 */

package carrera;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.util.Random;


public class Caballo extends Thread {
    //atributos de la clase
    
    String nombre;
    int limite;
    JLabel label;
    
    /**
     * constructor de la clase 
     * @param nombre
     * @param limite
     * @param label
    */
    public Caballo(String nombre,int limite,JLabel label){
        this.nombre=nombre;
        this.limite=limite;
        this.label=label;
    }
    
    /**
    * este metodo run () es la ejecucion del hilo  
    */
    @Override
    public void run (){
        //objeto random para la creacion de numeros.
        Random avance = new Random();
        int n;
        int p=0;
        do{
            n = avance.nextInt(10);
            p =n+p;
           
            try {
                label.setLocation(p,0);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Caballo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(p<limite);
        
        System.out.println(nombre+ " Finalizo la carrera ");
        System.out.println("-------------------*---------------------");
        
        
        yield();
    }
    
}
