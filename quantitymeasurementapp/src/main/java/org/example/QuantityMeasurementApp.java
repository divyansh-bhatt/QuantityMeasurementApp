package java.org.example;

import java.org.example.controller.QuantityMeasurementController;
import java.org.example.dto.QuantityDTO;
import java.org.example.repository.QuantityMeasurementCacheRepository;
import java.org.example.service.QuantityMeasurementServiceImpl;
import java.util.Objects;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // initialize repository
        QuantityMeasurementCacheRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        // initialize service
        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        // initialize controller
        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        // example quantities
        QuantityDTO q1 = new QuantityDTO(10, "FEET", "Length");
        QuantityDTO q2 = new QuantityDTO(6, "INCHES", "Length");

        // call controller
        QuantityDTO result = controller.performAddition(q1, q2);

        System.out.println("Addition result: " + result);
    }
}