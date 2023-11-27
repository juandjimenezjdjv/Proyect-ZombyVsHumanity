/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zz_proyecto1;


import java.io.Serializable;
import javax.swing.JLabel;
/**
 *
 * @author Juan Jimenez
 */
public class Personaje implements Serializable {   //(coordenada-coordenada%25)
    private transient JLabel Personaje;
    private String nombre;
    private String imagenVidaMax;
    private String imagenVidaBaja;
    private String imagenRip;
    private int vida;
    private int cantidad_golpes;//aqui se toma que es golpe por segundo
    private int nivel; //entre mas nivel (+vida y +golpe)
    private int campos;
    private int aparicion; //aparece despues de cierto nivel
    private String tipo; //mediano alcance, aire o tierra
    private int rango;//rango de ataque del personaje
    
    private String registro ="";//registra todo el proceso

    public Personaje(String nombre, String imagenVidaMax, String imagenVidaBaja, int vida, int cantidad_golpes, int nivel, int campos, int aparicion, String tipo, int rango) {
        this.nombre = nombre;
        this.imagenVidaMax = imagenVidaMax;
        this.imagenVidaBaja = imagenVidaBaja;
        this.vida = vida;
        this.cantidad_golpes = cantidad_golpes;
        this.nivel = nivel;
        this.campos = campos;
        this.aparicion = aparicion;
        this.tipo = tipo;
        this.rango = rango;
    }
    
    public Personaje(){
    }
    
    public void setvalues(String nombre, String imagenVidaMax, String imagenVidaBaja, int vida, int cantidad_golpes, int nivel, int campos, int aparicion, String tipo, int rango){
        this.nombre = nombre;
        this.imagenVidaMax = imagenVidaMax;
        this.imagenVidaBaja = imagenVidaBaja;
        this.vida = vida;
        this.cantidad_golpes = cantidad_golpes;
        this.nivel = nivel;
        this.campos = campos;
        this.aparicion = aparicion;
        this.tipo = tipo;
        this.rango = rango;
    }
    
    public JLabel getPersonaje() {
        return Personaje;
    }

    public void setPersonaje(JLabel Personaje) {
        this.Personaje = Personaje;
    }
    
    public void imprimir(){
        System.out.println(nombre + " tiene una vida de : " + vida + " con " + cantidad_golpes + "s y un rango de: "+ rango);
    }
    
    public void morirse(){
        this.vida = 0;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagenVidaMax() {
        return imagenVidaMax;
    }

    public void setImagenVidaMax(String imagenVidaMax) {
        this.imagenVidaMax = imagenVidaMax;
    }

    public String getImagenVidaBaja() {
        return imagenVidaBaja;
    }

    public void setImagenVidaBaja(String imagenVidaBaja) {
        this.imagenVidaBaja = imagenVidaBaja;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCantidad_golpes() {
        return cantidad_golpes;
    }

    public void setCantidad_golpes(int cantidad_golpes) {
        this.cantidad_golpes = cantidad_golpes;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getAparicion() {
        return aparicion;
    }

    public void setAparicion(int aparicion) {
        this.aparicion = aparicion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
    
}
