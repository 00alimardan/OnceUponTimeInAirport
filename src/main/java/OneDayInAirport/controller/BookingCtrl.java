package OneDayInAirport.controller;



import OneDayInAirport.entity.FlightEntity;
import OneDayInAirport.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingCtrl {
    private final BookingService service;

    public BookingCtrl(BookingService service) {
        this.service = service;
    }

    @GetMapping("/search/{toCity}/{date}/{free}")
    public List<FlightEntity> search(@PathVariable String toCity, @PathVariable String date, @PathVariable int free){
        return service.search(toCity, date, free);
    }

    @PostMapping("/s/{flightNo}/{passId}/{ticket}")
    public void save(@PathVariable int flightNo, @PathVariable Long passId, @PathVariable int ticket){
        service.save(flightNo, passId, ticket);
    }
}
