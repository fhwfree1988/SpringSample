package me.samplespring.my_samples.domain;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false,unique = true,nullable = false)
    private Long Id;

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column()
    private Long productNo;

    @Column()
    private int productName;

}
