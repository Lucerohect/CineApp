/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.CineApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionDAO {  


    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
   
   private static final String URL = "jdbc:mysql://localhost:3306/cineapp?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "17289Luc";
  
    private static final String INSERT_FUNCION = "INSERT INTO funciones (nombre, horario) VALUES (?, ?)";
    private static final String SELECT_FUNCIONES = "SELECT * FROM funciones";
    private static final String UPDATE_FUNCION = "UPDATE funciones SET nombre = ?, horario = ? WHERE id = ?";
    private static final String DELETE_FUNCION = "DELETE FROM funciones WHERE id = ?";

 
    public static void insertarFuncion(Funcion funcion) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_FUNCION)) {

            statement.setString(1, funcion.getNombre());
            statement.setString(2, funcion.getHorario());

            statement.executeUpdate();

            System.out.println("Función insertada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void obtenerFunciones() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_FUNCIONES)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String horario = resultSet.getString("horario");

                Funcion funcion = new Funcion(id, nombre, horario);
                System.out.println(funcion.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarFuncion(Funcion funcion) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(UPDATE_FUNCION)) {

            statement.setString(1, funcion.getNombre());
            statement.setString(2, funcion.getHorario());
            statement.setInt(3, funcion.getId());

            statement.executeUpdate();

            System.out.println("Función actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarFuncion(int funcionId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(DELETE_FUNCION)) {

            statement.setInt(1, funcionId);

            statement.executeUpdate();

            System.out.println("Función eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
