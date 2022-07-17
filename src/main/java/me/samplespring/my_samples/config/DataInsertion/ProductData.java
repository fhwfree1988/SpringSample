package me.samplespring.my_samples.config.DataInsertion;

import me.samplespring.my_samples.domain.Product;
import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.Types;
import me.samplespring.my_samples.repos.ProductRepository;
import me.samplespring.my_samples.repos.ReservationRepository;
import me.samplespring.my_samples.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class ProductData {

    @Autowired
    private ProductRepository productRepository;

    public void loadData() {
        if (productRepository.findAll().size() == 0) {
            int count = 0;
            while (count < 10) {
                Product user = Product.builder().id((long) (count+2))
                        .productName("P_" + count)
                        .isActive(true)
                        .build();
                productRepository.save(user);
                count++;

            }
        }
    }

//    public CommandLineRunner loadData(ProductRepository productRepository){
//        return (args) ->{
//            if(productRepository.findAll().size() == 0) {
//                int count = 0;
//                while (count < 10) {
//                    Product user = Product.builder()
//                            .productName("P1")
//                            .isActive(true)
//                            .build();
//                    productRepository.save(user);
//                    count++;
//                }
//            }
//
//            /*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            Date date = new Date();
//            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            Reservation reservation = Reservation.builder()
//                    .reservationDate(localDate)
//                    .startTime(LocalTime.of(12, 00))
//                    .endTime(LocalTime.of(13, 00))
//                    .user(user)
//                    .amenityType(Types.AmenityType.POOL)
//                    .build();
//
//            reservationRepository.save(reservation);*/
//        };
//    }
}
