package examen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main5 {

    public static void main(String[] args) {
        final String MYSQL_CON = "c:\\temp\\mysql.con";
        GestorBBDD gestorBBDD = new GestorBBDD(MYSQL_CON);

        List<Vehicle> vehicles = Arrays.asList(
            new Vehicle("4321-JKL", "Ford",     "Focus",   2019, 17000),
            new Vehicle("8765-MNO", "Hyundai",  "Ioniq 5", 2023, 42000),
            new Vehicle("2109-PQR", "Peugeot",  "308",     2016, 14000)
);


        try (Connection conn = gestorBBDD.getConnectionFromFile()) {
            for ( List<Vehicle> vehicle : vehicles) {
                try {
                    gestorBBDD.executaSQL(conn,
                        "INSERT INTO vehicles (matricula, marca, model, any, preu) VALUES (?, ?, ?, ?, ?)",
                        vehicle
                    );
                } catch (SQLException e) {
                    if ("23000".equals(e.getSQLState()) && e.getErrorCode() == 1062) {
                        System.out.println("error: " + vehicle[0]);
                    } else {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
