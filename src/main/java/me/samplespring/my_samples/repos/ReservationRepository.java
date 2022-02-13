package me.samplespring.my_samples.repos;

import me.samplespring.my_samples.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
