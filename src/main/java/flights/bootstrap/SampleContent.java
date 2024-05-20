package flights.bootstrap;


import flights.domain.Flight;
import flights.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {

    @Autowired
    FlightService flightService;

    @Override
    public void run(String... args) {
        System.out.println("Creating sample content");

        flightService.create(new Flight("A01", "Alexandroupoli", "Athens", 100.00));
        flightService.create(new Flight("A02", "Alexandroupoli", "Kalamata", 130.00));
        flightService.create(new Flight("A03", "Alexandroupoli", "Rhodes", 110.00));
        flightService.create(new Flight("A04", "Alexandroupoli", "Thessaloniki", 45.00));

        flightService.create(new Flight("A05", "Athens", "Alexandroupoli", 95.00));
        flightService.create(new Flight("A06", "Athens", "Kalamata", 70.00));
        flightService.create(new Flight("A07", "Athens", "Rhodes", 120.00));
        flightService.create(new Flight("A08", "Athens", "Thessaloniki", 85.00));

        flightService.create(new Flight("A09", "Kalamata", "Alexandroupoli", 120.00));
        flightService.create(new Flight("A10", "Kalamata", "Athens", 75.00));
        flightService.create(new Flight("A11", "Kalamata", "Rhodes", 100.00));
        flightService.create(new Flight("A12", "Kalamata", "Thessaloniki", 110.00));

        flightService.create(new Flight("A13", "Rhodes", "Alexandroupoli", 100.00));
        flightService.create(new Flight("A14", "Rhodes", "Athens", 130.00));
        flightService.create(new Flight("A15", "Rhodes", "Kalamata", 100.00));
        flightService.create(new Flight("A16", "Rhodes", "Thessaloniki", 110.00));

        flightService.create(new Flight("A17", "Thessaloniki", "Alexandroupoli", 50.00));
        flightService.create(new Flight("A18", "Thessaloniki", "Athens", 75.00));
        flightService.create(new Flight("A19", "Thessaloniki", "Kalamata", 105.00));
        flightService.create(new Flight("A20", "Thessaloniki", "Rhodes", 120.00));

        System.out.println("Sample content creation done.");
    }
}