/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Asignatura {

    private String Nombre;
    private int C_temas, C_horas;

    public Asignatura(String Nombre, int C_temas, int C_horas) {
        this.Nombre = Nombre;
        this.C_temas = C_temas;
        this.C_horas = C_horas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getC_temas() {
        return C_temas;
    }

    public void setC_temas(int C_temas) {
        this.C_temas = C_temas;
    }

    public int getC_horas() {
        return C_horas;
    }

    public void setC_horas(int C_horas) {
        this.C_horas = C_horas;
    }

}
