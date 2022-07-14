package me.samplespring.my_samples.repos;

import me.samplespring.my_samples.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
