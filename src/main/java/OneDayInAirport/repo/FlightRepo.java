package OneDayInAirport.repo;

import OneDayInAirport.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepo extends JpaRepository<FlightEntity, Long> {

}
