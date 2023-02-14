package OneDayInAirport.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passengers")
public class PassengerEntity {
    @Id
    @Column(name = "passenger_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(targetEntity = BookingEntity.class)
    @JoinTable(name = "passenger_bookings",joinColumns = @JoinColumn(name = "passenger_id"),
    inverseJoinColumns = @JoinColumn(name = "booking_id"))
    private List<BookingEntity> booking;
}
