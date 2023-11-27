/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Robo_Zombie;

import com.mycompany.zz_proyecto1.Personaje;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Juan Jimenez
 */
public class ThreadPersonaje extends Thread {
    Personaje personaje;
    JuegoGrafico refVentana;
    boolean isRunning = true;
    int decicion;
    int id;
    int x,y;
    //hacer que el thread reciva un 1 o un 0 para saber si es defensa o zombie
    

    public ThreadPersonaje(Personaje personaje, JuegoGrafico refVentana, int decicion,int id) {
        this.personaje = personaje; 
        this.refVentana = refVentana;
        this.decicion = decicion;
        this.id = id;
    }
    
    public Personaje estaEnRango(Personaje p, int i, int xd) {
        if (i==1){
            int rango = p.getRango(); // Supongamos que existe un método getRango() en la clase Personaje
            rango = rango*25;
            for (ThreadPersonaje defensa : refVentana.defensas) {
                if (!"muerto".equals(defensa.personaje.getImagenVidaBaja())){//if ("Aereo".equals(p.getTipo())){ //if (defensa.personaje.getTipo()!="Aereo" && (p.getTipo()=="Aereo" || p.getTipo()=="Mediano alcance"))
                        //Las dos lineas de abajo es donde deben ir las validaciones
                    int distanciaX = Math.abs(p.getPersonaje().getX()- defensa.personaje.getPersonaje().getX());
                    int distanciaY = Math.abs(p.getPersonaje().getY() - defensa.personaje.getPersonaje().getY());
                    if (distanciaX <= rango && distanciaY <= rango) {
                        return decidiratacar(defensa, p, xd); 
                    }
                }
            }
        }
    return null;
    }
    
    public Personaje estaEnango2(Personaje p, int i, int xd) {
        if (i == 2){
            int rango = p.getRango(); // Supongamos que existe un método getRango() en la clase Personaje
            rango = rango*25;
            for (ThreadPersonaje zombie : refVentana.zombies) {
                if (!"muerto".equals(zombie.personaje.getImagenVidaBaja())){
                    int distanciaX = Math.abs(p.getPersonaje().getX()- zombie.personaje.getPersonaje().getX());
                    int distanciaY = Math.abs(p.getPersonaje().getY() - zombie.personaje.getPersonaje().getY());
                    if (distanciaX <= rango && distanciaY <= rango) {
                        return decidiratacar(zombie, p, xd);
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public void run() {
        while(isRunning){
            try {
                x = posReliq().getPersonaje().getX();
                y = posReliq().getPersonaje().getY();
                
                Personaje defensaEnRango = estaEnRango(personaje, decicion, id);
                Personaje defensaEnRango2 = estaEnango2(personaje, decicion, id);
                
                if (defensaEnRango==null && decicion==1) {
                    refVentana.moverLabel(personaje.getPersonaje(),x/25,y/25);

                } else if(defensaEnRango != null){
                    if ("Choque".equals(personaje.getTipo())){
                        persoChoque(id);
                    }
                }
                   
                    
                if (defensaEnRango2==null && decicion==2) {
//                    System.out.println("Hola");
                    if ("Aereo".equals(personaje.getTipo())){
                        Personaje aereo = encMasCercana();
                        x=aereo.getPersonaje().getX();
                        y=aereo.getPersonaje().getY();
                        refVentana.moverLabel(personaje.getPersonaje(),x/25,y/25);
                    }

                } else {

                }
                    
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
            
        }
    }
    
    void persoChoque(int id){
        for (ThreadPersonaje zombie : refVentana.zombies){
            if (!"muerto".equals(zombie.personaje.getImagenVidaBaja())){
                if (zombie.id == id){
                    zombie.personaje.setVida(0);
                    ImageIcon nuevaImagen = new ImageIcon("src/main/java/images/lapida.png");
                    Image imagenEscalada = nuevaImagen.getImage().getScaledInstance(zombie.personaje.getPersonaje().getWidth(), zombie.personaje.getPersonaje().getHeight(), Image.SCALE_SMOOTH);
                    nuevaImagen = new ImageIcon(imagenEscalada);
                    zombie.personaje.getPersonaje().setIcon(nuevaImagen);
                    zombie.isRunning = false;
                    
                    zombie.personaje.setImagenVidaBaja("muerto");
                }
            }
        }
    }
    
    public Personaje posReliq(){
        for (ThreadPersonaje def : refVentana.defensas){
            if ("Reliquia".equals(def.personaje.getNombre())){
                return def.personaje;
            }
        }
        return null;
    }
    
    public Personaje encMasCercana() {
        Personaje defensaMasCercana = null;
        int distanciaMasCorta = Integer.MAX_VALUE;
        
        for (int i = 0; i<refVentana.zombies.size(); i++) {
            if (!"muerto".equals(refVentana.zombies.get(i).personaje.getImagenVidaBaja())){
                int distanciaX = Math.abs(personaje.getPersonaje().getX() - refVentana.zombies.get(i).personaje.getPersonaje().getX());
                int distanciaY = Math.abs(personaje.getPersonaje().getY() - refVentana.zombies.get(i).personaje.getPersonaje().getY());
                int distanciaTotal = distanciaX + distanciaY;

                if (distanciaTotal < distanciaMasCorta) {
                    distanciaMasCorta = distanciaTotal;
                    defensaMasCercana = refVentana.zombies.get(i).personaje;
                }
            }
        }
        return defensaMasCercana;
    }
    
    public Personaje decidiratacar(ThreadPersonaje obj, Personaje p, int xd){
        if ("Aereo".equals(p.getTipo()) || "Mediano alcance".equals(p.getTipo())){
            return ataqudef(obj, p, xd);
        }else {																																	// Si ud es de cualquier otro tipo ataque
            if (!"Aereo".equals(obj.personaje.getTipo())) {//  ==   .equal
                return ataqudef(obj, p, xd);
            } else return null;
        }
    }

    public Personaje ataqudef(ThreadPersonaje obj, Personaje p, int xd){
        obj.personaje.setRegistro(obj.personaje.getRegistro()+"La defensa " + p.getNombre() + " con ID " + xd
                            + " le quito " + p.getCantidad_golpes() + "\n");
        obj.personaje.setVida(obj.personaje.getVida()-p.getCantidad_golpes());

        if (obj.personaje.getVida()<=0){
            obj.isRunning = false;
            JLabel label = obj.personaje.getPersonaje();
            ImageIcon nuevaImagen = new ImageIcon("src/main/java/images/lapdef.png");
            Image imagenEscalada = nuevaImagen.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            nuevaImagen = new ImageIcon(imagenEscalada);
            label.setIcon(nuevaImagen);

            obj.personaje.setImagenVidaBaja("muerto");
        }
        return obj.personaje;
    }
}
