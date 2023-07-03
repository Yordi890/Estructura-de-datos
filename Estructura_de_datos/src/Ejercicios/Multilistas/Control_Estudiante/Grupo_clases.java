/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas.Control_Estudiante;

import Listas.Simple_Enlazada.Simple_Enlazada;

public class Grupo_clases {

    private String identificador;
    private Simple_Enlazada<Estudiante> participantes;


    public Grupo_clases(String identificador, Simple_Enlazada<Estudiante> participantes) {
        this.identificador = identificador;
        this.participantes = participantes;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Simple_Enlazada<Estudiante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Simple_Enlazada<Estudiante> participantes) {
        this.participantes = participantes;
    }
}
