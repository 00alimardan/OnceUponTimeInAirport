package OneDayInAirport.service;

import OneDayInAirport.entity.BookingEntity;
import OneDayInAirport.entity.PassengerEntity;
import OneDayInAirport.repo.BookingRepo;
import OneDayInAirport.repo.PassengerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PassengerService {
    private final PassengerRepo repo;
    private final BookingRepo bookingRepo;

    public PassengerService(PassengerRepo repo, BookingRepo bookingRepo) {
        this.repo = repo;
        this.bookingRepo = bookingRepo;
    }

    public void registration(PassengerEntity passenger){
        repo.save(passenger);
    }

    public void deleteMyFlight(Long id){
        bookingRepo.deleteById(id);
    }

    public List<BookingEntity> myFlight(Long id){
        return bookingRepo.findAll().stream()
                .filter(b -> Objects.equals(b.getPassenger().getId(), id)).collect(Collectors.toList());
    }
    public List<PassengerEntity> get(Long id){
        return repo.findById(id).stream()
                .filter(b -> Objects.equals(b.getId(), id)).collect(Collectors.toList());
    }
}
