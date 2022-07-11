package me.samplespring.my_samples.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long Id;

    @Column
    private int Cost;

    @DateTimeFormat(pattern = "yyyy-mm-dd hh:mm")
    @Column(nullable = false)
    private LocalDate submitionDate;

    @Column
    private boolean isActive;

    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

}
