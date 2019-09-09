package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

}