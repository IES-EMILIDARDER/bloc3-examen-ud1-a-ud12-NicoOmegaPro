package examen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) throws IOException {
        
        List<Vehicle> vehicles = Arrays.asList(new Vehicle("1234-HJK", "Toyota",     "Corolla", 2010, 12000),
        new Vehicle("5678-KLM", "Volkswagen", "Golf",    2018, 18000),
        new Vehicle("9012-NPR", "Seat",       "Ibiza",   2015, 10000),
        new Vehicle("3456-STU", "Tesla",      "Model 3", 2022, 40000),
        new Vehicle("7890-VWX", "Renault",    "Clio",    2012,  9000)          
);

            long vehicless2 = vehicles.stream().filter(p -> p.getPreu() > 15000).count();
            double vMax = vehicles.stream().map(n -> n.getPreu()).mapToDouble(n->n).max().orElse(0);
            double vMin = vehicles.stream().map(p->p.getPreu()).mapToDouble(e-> e).min().orElse(0);
            double vAvg = vehicles.stream().map(p->p.getPreu()).mapToDouble(n->n).average().orElse(0);
            
           
            System.out.println("Vehiculos que cuestan más de 15k: "+ vehicless2);
            System.out.println("Vehiculo más caro: " + vMax);
            System.out.println("Vehiculo más barato: " + vMin);
            System.out.println("Precio medio de todos los vehiculos: " + vAvg);



    }
}



