package flights.repository;

import flights.domain.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightRepositoryImpl implements FlightRepository {

    private static Map<String, Flight> allFlights = new HashMap<>();

    private static int nextId = 1;

    @Override
    public Flight createDb(Flight flight) {
        allFlights.put(flight.getName(), flight);
        flight.setId(nextId);
        nextId++;
        return flight;
    }

    @Override
    public List<Flight> readDb() {
        return new ArrayList<>(allFlights.values());
    }

    @Override
    public Flight readByNameDb(String name) {
        return allFlights.get(name);
    }

    @Override
    public Flight deleteByNameDb(String name) {
        Flight flight = allFlights.get(name);
        allFlights.remove(name);
        return flight;
    }
}
