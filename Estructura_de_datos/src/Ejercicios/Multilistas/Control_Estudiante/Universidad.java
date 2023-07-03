/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas.Control_Estudiante;

import Listas.Simple_Enlazada.Simple_Enlazada;

public class Universidad {

    private Simple_Enlazada<Facultad> Lista;

    public Universidad(Simple_Enlazada<Facultad> lista) {
        Lista = lista;
    }

    public String add_grupo_cientifico(String nombre_facultad, Grupo_cientifico G) {
        boolean H = false;
        for (Facultad F : Lista) {
            if (F.getNombre().equalsIgnoreCase(nombre_facultad)) {
                for (Grupo_cientifico grupo : F.getGrupos_cientifico()) {
                    if (grupo.getTema().equalsIgnoreCase(G.getTema())) {
                        return "Ese grupo científico ya existe";
                    }
                }
                F.getGrupos_cientifico().add(G);
                break;
            }
        }
        return "Se agregó";
    }

    public String add_grupo_clases(String nombre_facultad, Grupo_clases G) {
        boolean H = false;
        for (Facultad F : Lista) {
            if (F.getNombre().equalsIgnoreCase(nombre_facultad)) {
                H = true;
                for (Grupo_clases grupo : F.getGrupos_clases()) {
                    if (grupo.getIdentificador().equalsIgnoreCase(G.getIdentificador())) {
                        return "Ese grupo de clases ya existe";
                    }
                }
                F.getGrupos_clases().add(G);
                break;
            }
        }
        return !H ? "No se encontró la facultad" : "Se agregó";
    }
}
