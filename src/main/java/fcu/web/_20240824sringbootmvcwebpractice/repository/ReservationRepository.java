package fcu.web._20240824sringbootmvcwebpractice.repository;

import fcu.web._20240824sringbootmvcwebpractice.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
