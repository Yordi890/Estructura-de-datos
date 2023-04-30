/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas;

import Listas.Circular_Doble.Circular_Doble;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Carrera {

    private String Nombre;
    private int Year;
    private Circular_Doble<Asignatura> asignaturas; // Tendré una lista de asignaturas en la carrera

    public Carrera(String Nombre, int Year, Circular_Doble<Asignatura> asignaturas) {
        this.Nombre = Nombre;
        this.Year = Year;
        this.asignaturas = asignaturas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public Circular_Doble<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void Circular_Doble(Circular_Doble<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
