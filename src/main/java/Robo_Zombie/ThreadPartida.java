/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Robo_Zombie;

import com.mycompany.zz_proyecto1.Personaje;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Juan Jimenez
 */
public class ThreadPartida extends Thread {
    
    JuegoGrafico refVentana;
    ArrayList<Personaje> lDefensas;
    ArrayList<Personaje> lZombie;
    boolean isRunning = true;

    public ThreadPartida(JuegoGrafico refVentana, ArrayList<Personaje> _lDefensas, ArrayList<Personaje> _lZombie) {
        lDefensas = _lDefensas;
        lZombie = _lZombie;
        this.refVentana = refVentana;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                int vidaReliquia = refVentana.getVidaReliquia();
                
                sleep(3000);
                
                boolean bandera = refVentana.ZombiesMuertos();

                if (vidaReliquia <= 0 || bandera == true){
                    

                    String Historia = refVentana.MostrarRegistrozzz();

                    // Crear un JTextArea para mostrar el contenido de Historia
                    JTextArea txa = new JTextArea(Historia);
                    txa.setEditable(false);

                    // Crear un JScrollPane y agregar el JTextArea a él con un tamaño específico
                    JScrollPane scrollPane = new JScrollPane(txa, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

                    // Establecer un tamaño específico para el JScrollPane
                    scrollPane.setPreferredSize(new Dimension(400, 670));

                    // Mostrar el contenido de Historia en un cuadro de diálogo emergente
                    JOptionPane.showMessageDialog(
                            refVentana,
                            scrollPane,  // Usar el JScrollPane en lugar del JTextArea directamente
                            "Historia del Juego",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    
                    int option = JOptionPane.showOptionDialog(
                            refVentana,
                            "¡El juego ha terminado! La reliquia ha sido destruida.",
                            "Fin del juego",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new Object[]{"Reiniciar", "Siguiente Nivel", "Guardar y salir"},
                            "Reiniciar"
                    );

                    switch (option) {
                        case 0: // Reiniciar
                            JuegoGrafico ReinicioJuego = new JuegoGrafico();
                            ReinicioJuego.setVisible(true);
                            refVentana.dispose();
                            refVentana = ReinicioJuego;
                            break;

                        case 1: // Siguiente Nivel
                            
                            refVentana.guardarPartidaYSubir();                           
                            JuegoGrafico MejoraJuego = new JuegoGrafico();
                            MejoraJuego.setVisible(true);
                            refVentana.dispose();
                            refVentana = MejoraJuego;
                           JOptionPane.showMessageDialog(
                                    refVentana,
                                    "La partida ha subido de nivel.",
                                    "Subio de Nivel",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            
                            break;

                        case 2: // Guardar Partida
                            refVentana.guardarPartidazzz();
                            JOptionPane.showMessageDialog(
                                    refVentana,
                                    "La partida ha sido guardada exitosamente.",
                                    "Partida Guardada",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                            refVentana.dispose();
                            break;

                        default:
                            break;
                    }

                    isRunning = false;
                }

                

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}