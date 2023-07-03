/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas.Control_Estudiante;

public class Estudiante {
    private String CI, nombre, grupo_cientifico, grupo_clase;

    public Estudiante(String CI, String nombre, String grupo_cientifico, String grupo_clase) {
        this.CI = CI;
        this.nombre = nombre;
        this.grupo_cientifico = grupo_cientifico;
        this.grupo_clase = grupo_clase;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo_cientifico() {
        return grupo_cientifico;
    }

    public void setGrupo_cientifico(String grupo_cientifico) {
        this.grupo_cientifico = grupo_cientifico;
    }

    public String getGrupo_clase() {
        return grupo_clase;
    }

    public void setGrupo_clase(String grupo_clase) {
        this.grupo_clase = grupo_clase;
    }
}
