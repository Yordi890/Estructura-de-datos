/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package Ejercicios.Multilistas.Moodle;

import Listas.Circular_Doble.Circular_Doble;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Facultad {

    private String Nombre;
    private Circular_Doble<Carrera> carreras; // Tendré una lista de carreras en cada facultad

    public Facultad(String Nombre, Circular_Doble<Carrera> carreras) {
        this.Nombre = Nombre;
        this.carreras = carreras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Circular_Doble<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Circular_Doble<Carrera> carreras) {
        this.carreras = carreras;
    }
}
