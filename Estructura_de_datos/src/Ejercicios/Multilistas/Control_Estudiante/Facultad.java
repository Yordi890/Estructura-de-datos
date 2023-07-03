/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas.Control_Estudiante;

import Listas.Simple_Enlazada.Simple_Enlazada;

public class Facultad {

    private String nombre;
    private Simple_Enlazada<Estudiante> Lista;
    private Simple_Enlazada<Grupo_cientifico> grupos_cientifico;
    private Simple_Enlazada<Grupo_clases> grupos_clases;

    public Facultad(String nombre, Simple_Enlazada<Estudiante> lista, Simple_Enlazada<Grupo_cientifico> grupos_cientifico, Simple_Enlazada<Grupo_clases> grupos_clases) {
        this.nombre = nombre;
        Lista = lista;
        this.grupos_cientifico = grupos_cientifico;
        this.grupos_clases = grupos_clases;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Simple_Enlazada<Estudiante> getLista() {
        return Lista;
    }

    public void setLista(Simple_Enlazada<Estudiante> lista) {
        Lista = lista;
    }

    public Simple_Enlazada<Grupo_cientifico> getGrupos_cientifico() {
        return grupos_cientifico;
    }

    public void setGrupos_cientifico(Simple_Enlazada<Grupo_cientifico> grupos_cientifico) {
        this.grupos_cientifico = grupos_cientifico;
    }

    public Simple_Enlazada<Grupo_clases> getGrupos_clases() {
        return grupos_clases;
    }

    public void setGrupos_clases(Simple_Enlazada<Grupo_clases> grupos_clases) {
        this.grupos_clases = grupos_clases;
    }
}
