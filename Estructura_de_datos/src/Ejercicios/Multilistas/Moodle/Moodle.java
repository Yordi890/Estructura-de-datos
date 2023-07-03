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
 * @author Yordanis Tejeda Rodriguez
 */
public class Moodle {

    Circular_Doble<Facultad> Lista;

    public Moodle() {
        Lista = new Circular_Doble<>();
    }

    /**
     * Nos permite agregar una nueva facultad
     *
     * @param nombre de la facultad
     * @return boolean true si se agregó, en caso contrario false
     */
    public boolean addFacultad(String nombre) {
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return false; // Si el nombre de la facultad existe, retorno false
            }
        }

        // Si llegó aquí es porque la puedo agregar
        Lista.add(new Facultad(nombre, new Circular_Doble<>()));
        return true;
    }

    /**
     * Nos permite agregar una carrera a una facultad
     *
     * @param carrera nombre de la carrera
     * @param year año de la carrera
     * @param Ide_F número de orden de la facultad en la que se desea agregar
     * @return boolean true si se agregó, en caso contrario false
     */
    public boolean addCarrera(String carrera, int year, int Ide_F) {

        for (int i = 0; i < Lista.get(Ide_F).getCarreras().size(); i++) {
            if (Lista.get(Ide_F).getCarreras().get(i).getNombre().equalsIgnoreCase(carrera) && Lista.get(Ide_F).getCarreras().get(i).getYear() == year) {
                return false;
            }
            /*
                      Si el nombre de la carrera y el año coinciden entonces estamos hablando de la misma carrera que ya estaría entonces le
                      doy false, solo las dos a la vez porque a mi entender puede existir la carrera de Ing. Informática en 1.er y 2nd año
             */

        }

        // Si llegó aquí es porque la puedo agregar
        Lista.get(Ide_F).getCarreras().add(new Carrera(carrera, year, new Circular_Doble<>()));
        return true;
    }

    /**
     * Nos permite agregar una asignatura a una carrera
     *
     * @param nombre de la asignatura
     * @param C_temas cantidad de temas que tendrá la asignatura
     * @param C_horas cantidad de horas que tendrá la asignatura
     * @param Ide_F facultad a la que pertenece la asignatura
     * @param Ide_C carrera a la que pertenece la asignatura
     * @return boolean true si se agregó, en caso contrario false
     */
    public boolean addAsignatura(String nombre, int C_temas, int C_horas, int Ide_F, int Ide_C) {

        /* Si el nombre de la asignatura existe, entonces retorno false y no la agrego
           Esto pudiera mejorarse verificando el nombre desde que se pide y así te ahorras entrar los otros datos
         */
        for (int i = 0; i < Lista.get(Ide_F).getCarreras().get(Ide_C).getAsignaturas().size(); i++) {
            if (Lista.get(Ide_F).getCarreras().get(Ide_C).getAsignaturas().get(i).getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        // Si llegó aquí es porque la puedo agregar
        Lista.get(Ide_F).getCarreras().get(Ide_C).getAsignaturas().add(new Asignatura(nombre, C_temas, C_horas));
        return true;
    }

    /**
     * Dado un nombre de facultad de existir, muestra toda su información
     *
     * @param facultad_a_buscar nombre de la facultad
     */
    public void Mostrar_Facultad(String facultad_a_buscar) {
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getNombre().equalsIgnoreCase(facultad_a_buscar)) {
                if (!Lista.get(i).getCarreras().isEmpty()) {
                    System.out.println("Carreras de la facultad " + facultad_a_buscar);
                    for (int j = 0; j < Lista.get(i).getCarreras().size(); j++) {
                        System.out.println((j + 1) + "- " + Lista.get(i).getCarreras().get(j).getNombre() + " Year " + Lista.get(i).getCarreras().get(j).getYear() + ":");
                        if (!Lista.get(i).getCarreras().get(j).getAsignaturas().isEmpty()) {
                            for (int k = 0; k < Lista.get(i).getCarreras().get(j).getAsignaturas().size(); k++) {
                                System.out.println("     " + (k + 1) + "- Nombre de asignatura: " + Lista.get(i).getCarreras().get(j).getAsignaturas().get(k).getNombre() + "\n"
                                        + "     Cantidad de temas: " + Lista.get(i).getCarreras().get(j).getAsignaturas().get(k).getC_temas() + "\n"
                                        + "     Cantidad de horas: " + Lista.get(i).getCarreras().get(j).getAsignaturas().get(k).getC_horas() + "\n");
                            }
                        } else {
                            System.out.println("     La carrera " + Lista.get(i).getCarreras().get(j).getNombre() + " aún no tiene asignaturas");
                        }
                    }
                } else {
                    System.out.println("La facultad " + facultad_a_buscar + " todavía no tiene carreras");
                }
                return;
            }
        }
        System.out.println("La facultad " + facultad_a_buscar + " no existe");
    }

    /*
     public void Mostrar_facultad_Mejorado(int Ide_F) { // Mejorado en el sentido de que será más rápido porque le indicas cual el la facultad
          if (!Lista.get(Ide_F).getCarreras().isEmpty()) {
               System.out.println("Carreras de la facultad " + Lista.get(Ide_F));
               for (int j = 0; j < Lista.get(Ide_F).getCarreras().size(); j++) {
                    System.out.println((j + 1) + "- " + Lista.get(Ide_F).getCarreras().get(j).getNombre() + " Year " + Lista.get(Ide_F).getCarreras().get(j).getYear() + ":");
                    if (!Lista.get(Ide_F).getCarreras().get(j).getAsignaturas().isEmpty()) {
                         for (int k = 0; k < Lista.get(Ide_F).getCarreras().get(j).getAsignaturas().size(); k++) {
                              System.out.println("     " + (k + 1) + "- Nombre de asignatura: " + Lista.get(Ide_F).getCarreras().get(j).getAsignaturas().get(k).getNombre() + "\n"
                                      + "     Cantidad de temas: " + Lista.get(Ide_F).getCarreras().get(j).getAsignaturas().get(k).getC_temas() + "\n"
                                      + "     Cantidad de horas: " + Lista.get(Ide_F).getCarreras().get(j).getAsignaturas().get(k).getC_horas() + "\n");
                         }
                    } else {
                         System.out.println("     La carrera " + Lista.get(Ide_F).getCarreras().get(j).getNombre() + " aun no tiene asignaturas");
                    }
               }
          } else {
               System.out.println("La facultad " + Lista.get(Ide_F) + " todavía no tiene carreras");
          }
     }
     */
}
