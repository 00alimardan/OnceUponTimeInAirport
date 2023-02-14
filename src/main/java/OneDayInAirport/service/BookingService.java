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
    private static final BookingEntity booking = new BookingEntity();
    private static final PassengerEntity passenger = new PassengerEntity();
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


    public void save(int flightNo, String name, String surname, int ticket){

        for (FlightEntity f: flightRepo.findAll()){
            if (f.getFlightNo()==flightNo & f.getFreeSeats()>=ticket){
                passenger.setName(name); passenger.setSurname(surname);
                passengerRepo.save(passenger);

                booking.setPassenger(passenger);
                booking.setFlight(f);
                booking.setTicket(ticket);

                f.setFreeSeats(f.getFreeSeats()-ticket);
            }
        }
        repo.save(booking);
        passenger.setBooking(Collections.singletonList(booking));
    }
}
