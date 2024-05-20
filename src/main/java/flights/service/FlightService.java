package flights.service;

import flights.domain.Flight;

import java.util.List;

public interface FlightService {
    Flight create(Flight flight);
    List<Flight> read();
    Flight readByName(String name);
    Flight deleteByName(String name);
}
