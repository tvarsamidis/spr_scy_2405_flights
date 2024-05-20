package flights.service;

import flights.domain.Flight;
import flights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    FlightRepository flightRepository;

    @Override
    public Flight create(Flight flight) {
        return flightRepository.createDb(flight);
    }

    @Override
    public List<Flight> read() {
        return flightRepository.readDb();
    }

    @Override
    public Flight readByName(String name) {
        return flightRepository.readByNameDb(name);
    }

    @Override
    public Flight deleteByName(String name) {
        return flightRepository.deleteByNameDb(name);
    }
}
