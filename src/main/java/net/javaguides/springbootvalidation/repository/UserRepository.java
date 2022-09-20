package net.javaguides.springbootvalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springbootvalidation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
