package OneDayInAirport.repo;


import OneDayInAirport.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<BookingEntity, Long> {


}
