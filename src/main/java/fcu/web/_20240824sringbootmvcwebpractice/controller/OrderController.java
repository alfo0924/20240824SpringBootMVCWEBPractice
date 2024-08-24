package fcu.web._20240824sringbootmvcwebpractice.controller;


import fcu.web._20240824sringbootmvcwebpractice.model.Reservation;
import fcu.web._20240824sringbootmvcwebpractice.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final ReservationRepository reservationRepository;

    @Autowired
    public OrderController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservation")
    public String reservationPage(Model model) {
        String reservationNumber = generateReservationNumber();
        model.addAttribute("reservationNumber", reservationNumber);
        return "reservation";
    }

    @PostMapping("/reservation/confirm")
    public String confirmReservation(@RequestParam String reservationNumber) {
        Reservation reservation = new Reservation();
        reservation.setNumber(reservationNumber);
        reservation.setCreatedAt(LocalDateTime.now());
        reservationRepository.save(reservation);
        return "redirect:/orders/order-history";
    }

    @GetMapping("/order-history")
    public String orderHistory(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "order-history";
    }

    private String generateReservationNumber() {
        Random random = new Random();
        return String.format("%05d", random.nextInt(100000));
    }
}
