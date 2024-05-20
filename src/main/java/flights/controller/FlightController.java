package flights.controller;

import flights.domain.Flight;
import flights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/ping")
    public String ping() {
        return "<h1>FlightsApp</h1>" +
               "This is the FlightsApp controller</br></br>" +
               "The current date is<br/>" +
               new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    @PostMapping("/create")
    public Flight createFlight(@RequestBody Flight flight) {
        return flightService.create(flight);
    }

    @GetMapping()
    public List<Flight> readFlight() {
        return flightService.read();
    }

    @GetMapping("/{flightName}")
    public Flight getFlight(@PathVariable String flightName) {
        return flightService.readByName(flightName);
    }

    @DeleteMapping("/{flightName}")
    public Flight deleteFlight(@PathVariable String flightName) {
        return flightService.deleteByName(flightName);
    }

    @GetMapping("/return/{from}/{to}")
    public String returnFlightFromTo(@PathVariable String from, @PathVariable String to) {
        List<Flight> flights = flightService.read();
        int legs = 0;
        double price = 0;
        for (Flight f : flights) {
            if (
                    (f.getFrom().equalsIgnoreCase(from) && f.getTo().equalsIgnoreCase(to))
                    ||
                    (f.getFrom().equalsIgnoreCase(to) && f.getTo().equalsIgnoreCase(from))
            ) {
                legs++;
                price += f.getPrice();
            }
        }
        if (legs == 0) {
            return "No such flight exists";
        }
        if (legs == 1) {
            return "The flight is one-way only";
        }
        return "The return trip for " + from + "-" + to + "-" + from + " is " + price + " euros";
    }

    @GetMapping("/airport/{location}")
    public String flightFromAirport(@PathVariable String location) {
        List<Flight> flights = flightService.read();
        String s = "All flights to/from " + location + ":</br></br>";
        for (Flight f : flights) {
            if (f.getFrom().equalsIgnoreCase(location) || f.getTo().equalsIgnoreCase(location)) {
                s += f.getName() + ": " + f.getFrom() + " - " + f.getTo() + "</br>";
            }
        }
        s += "</br>End of flights found</br>";
        return s;
    }


}
