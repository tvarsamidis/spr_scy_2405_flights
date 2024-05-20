package flights.repository;

import flights.domain.Flight;

import java.util.List;

public interface FlightRepository {
    Flight createDb(Flight flight);
    List<Flight> readDb();
    Flight readByNameDb(String name);
    Flight deleteByNameDb(String name);
}
