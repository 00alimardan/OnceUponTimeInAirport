package OneDayInAirport.repo;

import OneDayInAirport.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<PassengerEntity, Long> {
}
