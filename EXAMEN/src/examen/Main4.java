package examen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);
        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            String query = "SELECT * FROM Vehicles WHERE any >= ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, 2020);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Vehicle vehicle = new Vehicle(String matricula, String marca, String modelo, int any, double preu);
                    vehicle.setMatricula(rs.getString("matricula")); 
                    vehicle.setMarca(rs.getString("marca"));
                    vehicle.setModel(rs.getString("model"));
                    vehicle.setAny(rs.getInt("any"));
                    vehicle.setPreu(rs.getDouble("preu"));
                    vehicles.add(vehicle);
                }

            } catch (SQLException e) {
                if ("23000".equals(e.getSQLState()) && e.getErrorCode() == 1062) {
                    System.out.println("Esta mal");
                } else {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //Comprobar vehiculos obtenidos, SI ME FUNCIONARA EL CONSTRUCTOR, no entiendo
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }
}
