package OneDayInAirport.controller;

import OneDayInAirport.entity.FlightEntity;
import OneDayInAirport.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightCtrl {
    private final FlightService service;

    public FlightCtrl(FlightService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public void save(@RequestBody FlightEntity flight){
        service.save(flight);
    }
    @GetMapping("/online_board")
    public List<FlightEntity> getAll(){
        return service.getAllFlight();
    }

    @GetMapping("/specific/{city}")
    public List<FlightEntity> particularFlight(@PathVariable String city){
        return service.particularFlight(city);
    }
}
