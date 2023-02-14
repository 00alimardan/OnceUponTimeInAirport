package OneDayInAirport.service;




import OneDayInAirport.entity.BookingEntity;
import OneDayInAirport.entity.FlightEntity;
import OneDayInAirport.entity.PassengerEntity;
import OneDayInAirport.repo.BookingRepo;
import OneDayInAirport.repo.FlightRepo;
import OneDayInAirport.repo.PassengerRepo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepo repo;
    private final FlightRepo flightRepo;
    private final PassengerRepo passengerRepo;
    public BookingService(BookingRepo repo, FlightRepo flightRepo, PassengerRepo passengerRepo) {
        this.repo = repo;
        this.flightRepo = flightRepo;
        this.passengerRepo = passengerRepo;
    }


    public List<FlightEntity> search(String toCity, String date, int free){
        return flightRepo.findAll().stream()
                .filter(f -> Objects.equals(f.getToCity(), toCity)
                        & Objects.equals(f.getDate(), date)
                        & f.getFreeSeats()>=free)
                .collect(Collectors.toList());
    }
    public void save(int flightNo, Long passId, int ticket){


        BookingEntity booking =
                BookingEntity.builder()
                .flight(flightRepo.getByFlightNo(flightNo))
                .passenger(passengerRepo.getById(passId))
                .build();
        booking.setTicket(ticket);
        booking.getFlight().setFreeSeats(booking.getFlight().getFreeSeats()-ticket);

        repo.save(booking);
    }
}
