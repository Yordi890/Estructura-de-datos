/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package Ejercicios.Multilistas;

import java.util.Scanner;

/**
 * @author Yordanis Tejeda Rodríguez
 */
public class Mulitilistas {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Moodle M = new Moodle();
        int E;
        do {
            System.out.println("""
                    Entre 1 para agregar una facultad
                    Entre 2 para agregar una carrera a una facultad
                    Entre 3 para agregar las asignaturas a una carrera de una facultad
                    Entre 4 para ver todos los datos de una facultad
                    Entre 0 para salir
                    """);
            E = in.nextInt();
            in.nextLine();

            switch (E) {
                case 1 -> {
                    System.out.println("Entre el nombre de la facultad");
                    System.out.println(M.addFacultad(in.nextLine()) ? "Se agrego" : "El nombre de la facultad ya existe");
                }
                case 2 -> {

                    if (!M.Lista.isEmpty()) {
                        System.out.println("Entre el numero de la facultad a la que le quieres agregar una carrera");
                        for (int i = 0; i < M.Lista.size(); i++) {
                            System.out.println((i + 1) + "- " + M.Lista.get(i).getNombre());
                        }
                        int Facultad = in.nextInt();
                        in.nextLine();

                        if (Facultad > 0 && Facultad <= M.Lista.size()) {
                            System.out.println("Entre el nombre de la carrera");
                            String Nom_C = in.nextLine();
                            System.out.println("Entre el year de la carrera " + Nom_C);
                            int year = in.nextInt();
                            in.nextLine();
                            System.out.println((M.addCarrera(Nom_C, year, Facultad - 1)) ? "Se agrego" : "La carrera ya existe");

                        } else {
                            System.out.println("El numero de la facultad que ingreso no existe");
                        }
                    } else {
                        System.out.println("Aun no hay facultades");
                    }
                }
                case 3 -> {

                    if (!M.Lista.isEmpty()) {

                        System.out.println("Listado de facultades");

                        for (int i = 0; i < M.Lista.size(); i++) {
                            System.out.println((i + 1) + "- " + M.Lista.get(i).getNombre());
                        }
                        int identificador_F = in.nextInt();
                        in.nextLine();

                        if (identificador_F > 0 && identificador_F <= M.Lista.size()) {

                            System.out.println("Listado de carreras de " + M.Lista.get(identificador_F - 1).getNombre());

                            for (int i = 0; i < M.Lista.get(identificador_F - 1).getCarreras().size(); i++) {
                                System.out.println((i + 1) + "- " + M.Lista.get(identificador_F - 1).getCarreras().get(i).getNombre());
                            }
                            int identificador_C = in.nextInt();
                            in.nextLine();

                            if (identificador_C > 0 && identificador_C <= M.Lista.get(identificador_F - 1).getCarreras().size()) {
                                System.out.println("Entre el nombre de la asignatura");
                                String N_Asig = in.nextLine();
                                System.out.println("Entre la cantidad de temas de la asignatura " + N_Asig);
                                int C_temas = in.nextInt();
                                in.nextLine();
                                System.out.println("Entre la cantidad de horas de la asignatura " + N_Asig);
                                int C_horas = in.nextInt();
                                in.nextLine();
                                M.addAsignatura(N_Asig, C_temas, C_horas, identificador_F - 1, identificador_C - 1);

                            } else {
                                System.out.println("Entro un numero de carrera que no existe");
                            }
                        } else {
                            System.out.println("Entro un numero de facultad que no existe");
                        }
                    } else {
                        System.out.println("Aun no hay facultades");
                    }

                }
                case 4 -> {

                    if (!M.Lista.isEmpty()) {
                        System.out.println("Entre el nombre de la facultad");
                        M.Mostrar_Facultad(in.nextLine());
                    } else
                        System.out.println("Aun no hay facultades");

                        /*
                         System.out.println("Listado de facultades. Elija una");
                         for (int i = 0; i < M.Lista.size(); i++) {
                              System.out.println((i + 1) + "- " + M.Lista.get(i).getNombre());
                         }
                         int facultad_a_buscar = in.nextInt();
                         in.nextLine();

                         if (facultad_a_buscar > 0 && facultad_a_buscar <= M.Lista.size()) {
                              M.Mostrar_facultad_Mejorado(facultad_a_buscar - 1);
                         } else {
                              System.out.println("La facultad no existe");
                         }
                        */
                }
                case 0 -> System.out.println("Ha salido");
                default -> System.out.println("Entro una operación que no existe");
            }
        } while (E != 0);
    }
}
