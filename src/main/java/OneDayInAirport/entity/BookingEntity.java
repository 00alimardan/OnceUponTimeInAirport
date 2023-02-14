package OneDayInAirport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "booking_date")
    private LocalDateTime bookingDate;

    @Column(name = "ticket")
    private int ticket;

    @ManyToOne
    @JoinColumn(name = "flight_id", foreignKey = @ForeignKey(name = "flight_id"))
    private FlightEntity flight;

    @ManyToOne(targetEntity = PassengerEntity.class)
    @JoinColumn(name = "passenger_id")
    private PassengerEntity passenger;

}
