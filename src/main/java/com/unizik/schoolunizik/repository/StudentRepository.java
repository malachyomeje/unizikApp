package com.unizik.schoolunizik.repository;

import com.unizik.schoolunizik.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {
     Optional<Students> findByEmail (String email);
   Optional <Students>findByPhoneNumber (String phone);
}
