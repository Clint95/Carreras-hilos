/**
 * 
 * @author Juan Ricardo Rodriguez Campos - Juan David Reyes
 * @verion 1.0.0
 * @since Carrera con numeros Random 1.0.0
 */
package carrera;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panel extends JFrame{
    
    //
    
    JPanel[] paneles;
    JLabel[] label;
    String[] nombre={"caballo1","caballo2","caballo3","caballo4"};
    JButton boton;
    int barrera = 1024;
    
    /**
    * constructor de la clase que contiene la creacion de las ventanas e inicializacion de l,os hilos que se muestran 
    * en el programa
    */
    public Panel(){
        setLayout(new GridLayout(0,1));
        paneles = new JPanel[4];
        label = new JLabel[4];
        JButton boton;
       
        for(int i=0;i<4;i++){
            paneles[i]= new JPanel();
            add(paneles[i]);
            label[i]= new JLabel(nombre[i]);
            label[i].setIcon(new ImageIcon(getClass().getResource(nombre[i]+".gif")));
            paneles[i].add(label[i]);
            label[i].setLocation(0, 0);
        }
        
        boton = new JButton("comenzar carrera");
        
        boton.addActionListener(new ActionListener(){
            
            /**
            * creacion de los objeto caballo y junto con ellos la inicializacion de sus hilos 
            */
            @Override
            public void actionPerformed(ActionEvent e) {
                Caballo caballo1 = new Caballo("caballo1",barrera - 40,label[0]);
                Caballo caballo2 = new Caballo("caballo2",barrera - 40,label[1]);
                Caballo caballo3 = new Caballo("caballo3",barrera - 40,label[2]);
                Caballo caballo4 = new Caballo("caballo4",barrera - 40,label[3]);
                
                caballo1.start();
                caballo2.start();
                caballo3.start();
                caballo4.start();
                
           /*
                // fragmento de codigo que determina el ganador ....... "sin funcionar"
                
                
                if(!caballo1.isAlive()){
                    System.out.println("El ganador es el caballo 1");
                }
                else{
                    if(!caballo2.isAlive()){
                        System.out.println("El ganador es el caballo 2");
                    }
                    else{
                        if(!caballo3.isAlive()){
                            System.out.println("El ganador es el caballo 3");
                        }
                        else{
                            if(!caballo4.isAlive()){
                                System.out.println("El ganador es el caballo 4");
                            }
                        }
                    }
            }
            */
                
                
            }
        });
        
        add(boton);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200,250);
        setSize(barrera,710);
        setVisible(true);
    }
    
    //Fin de la clase Panel
    
}
