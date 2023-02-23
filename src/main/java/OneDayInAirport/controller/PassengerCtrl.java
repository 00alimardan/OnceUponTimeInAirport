package OneDayInAirport.controller;

import OneDayInAirport.entity.BookingEntity;
import OneDayInAirport.entity.PassengerEntity;
import OneDayInAirport.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myFlight")
public class PassengerCtrl {
    //  http://localhost:8080/myFlight
    private final PassengerService service;

    public PassengerCtrl(PassengerService service) {
        this.service = service;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMyFlight(@PathVariable Long id){
        service.deleteMyFlight(id);
    }
    @GetMapping("/my/{id}")
    public List<BookingEntity> getById(@PathVariable Long id){

        return service.myFlight(id);
    }
    @GetMapping("/myf/{id}")
    public PassengerEntity get(@PathVariable Long id){
        return service.get(id);
    }
}
