/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Robo_Zombie;

import java.util.ArrayList;

/**
 *
 * @author Juan Jimenez
 */
public class Posiciones {

    private ArrayList<String> coordenadasOcupadas;

    public Posiciones() {
        coordenadasOcupadas = new ArrayList<>();
    }

    public void ocuparPosicion(int x, int y) {
        String coordenada = x + "," + y;
        coordenadasOcupadas.add(coordenada);
    }

    public boolean verificarPosicion(int x, int y) {
        String coordenada = x + "," + y;
        return !coordenadasOcupadas.contains(coordenada);
    }

    // Otras funciones según sea necesario

    public void desocuparPosicion(int x, int y) {
        String coordenada = x + "," + y;
        coordenadasOcupadas.remove(coordenada);
    }
}
