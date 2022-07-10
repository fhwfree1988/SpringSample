package me.samplespring.my_samples.controller;

import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.ReservationDTO;
import me.samplespring.my_samples.model.Types;
import me.samplespring.my_samples.model.UserDTO;
import me.samplespring.my_samples.service.ReservationService;
import me.samplespring.my_samples.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Controller
public class HomeController {

    final UserService userService;
    final ReservationService reservationService;

    public HomeController(UserService userService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    /*@GetMapping("/")*/
    public String index(Model model){
        return "index";
    }

   /* @GetMapping("/reservations")*/
    public  String reservation(Model model){
        /*User user = userService.get(10000L);*/
        UserDTO user = userService.get(10000L);


        Reservation reservation = getTempReservation(user);
        if(user.getReservations() != null && !user.getReservations().stream().findFirst().isEmpty())
            reservation = user.getReservations().stream().findFirst().get();
        else{
            Set<Reservation> set = new HashSet<>();
            set.add(reservation);
            user.setReservations(set);
        }
        model.addAttribute("user",user);
        model.addAttribute("reservation", reservation);
        return "reservations";
    }

    private Reservation getTempReservation(UserDTO userDto){
        User user = UserService.MapDTOToEntity(userDto);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Reservation reservation = Reservation.builder()
                .reservationDate(localDate)
                .startTime(LocalTime.of(12, 00))
                .endTime(LocalTime.of(13, 00))
                .user(user)
                .amenityType(Types.AmenityType.POOL)
                .build();
        return reservation;
    }
    @PostMapping("/reservations-submit")
    public String reservationsSubmit(@ModelAttribute ReservationDTO reservation,
                                     @SessionAttribute("user") UserDTO user) {

        /*// Save to DB after updating
        assert user != null;
        reservation.setUser(user);
        reservationService.create(reservation);
        Set<Reservation> userReservations = user.getReservations();
        Set<ReservationDTO> userReservationsDto = ReservationDTO.MapToDTO(userReservations);
        userReservations.add(userReservations);
        user.setReservations(userReservations);
        userService.update(user.getId(), user);
        return "redirect:/reservations";*/
        // Save to DB after updating
        assert user != null;
        reservation.setUser(UserService.MapDTOToEntity(user));
        reservationService.create(reservation);
        /*Set<ReservationDTO> userReservations =  ReservationDTO.MapToDTO(user.getUserReservations());
        userReservations.add(reservation);
        user.setUserReservations(userReservations);*/
        Set<Reservation> userReservations =  user.getReservations();
        userReservations.add(ReservationService.MapDTOToEntity(reservation));
        user.setReservations(userReservations);
        userService.update(user.getId(), user);
        return "redirect:/reservations";
    }
}
