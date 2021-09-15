package net.javaspringapi.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaspringapi.springboot.model.Testing;

@Repository
public interface TestingRepository extends JpaRepository<Testing, Long>{

}
