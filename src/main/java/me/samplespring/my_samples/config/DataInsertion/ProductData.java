package me.samplespring.my_samples.config.DataInsertion;

import me.samplespring.my_samples.domain.Product;
import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.Types;
import me.samplespring.my_samples.repos.ProductRepository;
import me.samplespring.my_samples.repos.ReservationRepository;
import me.samplespring.my_samples.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
public class ProductData {

    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository){
        return (args) ->{
            Product user = Product.builder()
                    .productName("P1")
                    .isActive(true)
                    .productCostSet()
                    .build();
            productRepository.save(user);

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

            reservationRepository.save(reservation);
        };
    }
}
