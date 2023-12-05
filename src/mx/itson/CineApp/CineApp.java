/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.CineApp;

import java.util.Scanner;

/**
 *
 * @author Hector Lucero
 */
public class CineApp {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar función");
            System.out.println("2. Ver funciones");
            System.out.println("3. Actualizar función");
            System.out.println("4. Eliminar función");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la función: ");
                    String nombreFuncion = scanner.next();
                    System.out.print("Ingrese el horario de la función: ");
                    String horarioFuncion = scanner.next();

                    Funcion nuevaFuncion = new Funcion(0, nombreFuncion, horarioFuncion);
                    FuncionDAO.insertarFuncion(nuevaFuncion);
                    break;
                case 2:
                    FuncionDAO.obtenerFunciones();
                    break;
                case 3:
                    System.out.print("Ingrese el ID de la función a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Ingrese el nuevo nombre de la función: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese el nuevo horario de la función: ");
                    String nuevoHorario = scanner.next();

                    Funcion funcionActualizada = new Funcion(idActualizar, nuevoNombre, nuevoHorario);
                    FuncionDAO.actualizarFuncion(funcionActualizada);
                    break;
                case 4:
                    System.out.print("Ingrese el ID de la función a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    FuncionDAO.eliminarFuncion(idEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}


