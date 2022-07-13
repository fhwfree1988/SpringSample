package me.samplespring.my_samples.domain;

import lombok.*;
import org.hibernate.Session;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.tuple.ValueGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
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
    /*@Column(unique = true,nullable = false)*/
    private Long Id;

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @SequenceGenerator(name = "productNo",sequenceName = "productNo",initialValue = 3000)
    /*@GenericGenerator(name = "productNo2",strategy = "increment")*/
    @GeneratedValue(strategy =  GenerationType.SEQUENCE ,generator = "productNo")
    @Column(unique = true)
    private Long productNo;

    @Column()
    private String productName;

    @Column()
    private boolean isActive;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private Set<ProductCost> productCostSet;

    /*@Column()
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ONE")
    @SequenceGenerator(name = "ONE", sequenceName = "ONE", allocationSize =1)
    private Long seq;*/

    /*@Generated(GenerationTime.INSERT)*/
    /*@Column(name = "column_name", insertable = false)*/
    /*@Column(columnDefinition = "integer auto_increment")
    private Integer orderID;*/

    @GeneratorType(type = MyGenerator.class, when = GenerationTime.INSERT)
    @Column(name = "dat_auto")
    private Long auto;

}

class MyGenerator implements ValueGenerator<Long>
{
    public String generateValue(Session session, Object owner)
    {
        /*return (
                (BigInteger) session
                        .createNativeQuery("select nextval('TST_DATA_SEQ')")
                        .getSingleResult()

        ).longValue();*/
        LocalDate localDate = LocalDate.now();
        return localDate.getYear() + localDate.getMonth() + localDate.getDayOfMonth() + localDate.;
    }
}