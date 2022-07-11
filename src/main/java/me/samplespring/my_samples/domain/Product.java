package me.samplespring.my_samples.domain;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Set;

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
    @SequenceGenerator(name = "productNo",sequenceName = "productNo",allocationSize = 2,initialValue = 3000)
    @GeneratedValue(strategy =  GenerationType.SEQUENCE ,generator = "productNo" )
    @Column()
    private Long productNo;

    @Column()
    private String productName;

    @Column()
    private boolean isActive;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<ProductCost> productCostSet;


}
