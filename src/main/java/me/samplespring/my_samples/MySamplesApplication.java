package me.samplespring.my_samples;

import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.Types;
import me.samplespring.my_samples.repos.ReservationRepository;
import me.samplespring.my_samples.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/*@EnableSwagger2*/
/*@Import(BeanValidatorPluginsConfiguration.class)*/
@SpringBootApplication
public class MySamplesApplication {
    //https://www.freecodecamp.org/news/spring-boot-tutorial-build-fast-modern-java-app/
    //https://spring.io/guides/gs/accessing-data-mysql/
    //https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
    //https://www.baeldung.com/spring-response-entity
    //https://stackoverflow.com/questions/67691575/when-should-you-use-configuration-instead-of-service-controller-component-fo
    //https://www.baeldung.com/spring-component-repository-service
    //https://www.baeldung.com/spring-component-annotation
    public static void main(String[] args) {
        SpringApplication.run(MySamplesApplication.class, args);
    }


    /*@Bean*/
    /*public CommandLineRunner loadData(UserRepository userRepository, ReservationRepository reservationRepository){
        return (args) ->{
            User user = User.builder().name("Foad").build();
            userRepository.save(user);

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
    }*/

}
