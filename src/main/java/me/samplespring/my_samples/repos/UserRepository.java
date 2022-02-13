package me.samplespring.my_samples.repos;

import me.samplespring.my_samples.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
