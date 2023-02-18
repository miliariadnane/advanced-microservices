package dev.nano.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Integer> {
    Optional<ApplicationEntity> findByName(String name);
}

