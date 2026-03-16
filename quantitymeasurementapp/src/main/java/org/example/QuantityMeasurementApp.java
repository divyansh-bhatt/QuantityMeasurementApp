package java.org.example;

import java.org.example.controller.QuantityMeasurementController;
import java.org.example.dto.QuantityDTO;
import java.org.example.repository.IQuantityMeasurementRepository;
import java.org.example.repository.QuantityMeasurementCacheRepository;
import java.org.example.repository.QuantityMeasurementDatabaseRepository;
import java.org.example.service.QuantityMeasurementServiceImpl;
import java.org.example.util.ApplicationConfig;
import java.util.Objects;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository;

        String repositoryType =
                ApplicationConfig.getProperty("repository.type", "cache");

        if (repositoryType.equalsIgnoreCase("database")) {

            repository = new QuantityMeasurementDatabaseRepository();

        } else {

            repository = QuantityMeasurementCacheRepository.getInstance();
        }

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(10, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(2, "FEET", "Length");

        double result = controller.performDivision(q1, q2);

        System.out.println("Division result: " + result);
    }
}