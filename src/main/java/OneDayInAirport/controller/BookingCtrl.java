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

    @PostMapping("/save/{flightNo}/{name}/{surname}/{ticket}")
    public void save(@PathVariable int flightNo, @PathVariable String name,
                     @PathVariable String surname, @PathVariable int ticket){
        service.save(flightNo, name, surname, ticket);
    }
}
