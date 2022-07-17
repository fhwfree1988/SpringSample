package me.samplespring.my_samples;

import me.samplespring.my_samples.config.DataInsertion.RunData;
import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.Types;
import me.samplespring.my_samples.repos.ReservationRepository;
import me.samplespring.my_samples.repos.UserRepository;
/*import org.modelmapper.ModelMapper;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

    public static void main(String[] args) {
        SpringApplication.run(MySamplesApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(RunData runData){
        return (args) -> {
            runData.loadData();

        };
    }

    /*@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }*/
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
