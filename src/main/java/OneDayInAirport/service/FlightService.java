package OneDayInAirport.service;


import OneDayInAirport.entity.FlightEntity;
import OneDayInAirport.repo.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }


    public void save(FlightEntity entity) {
        repo.save(entity);
    }



    public List<FlightEntity> getAllFlight(){
        return repo.findAll();
    }


    public List<FlightEntity> particularFlight(String city){
        return repo.findAll().stream()
                .filter(f -> Objects.equals(f.getToCity(), city)).collect(Collectors.toList());
    }
}