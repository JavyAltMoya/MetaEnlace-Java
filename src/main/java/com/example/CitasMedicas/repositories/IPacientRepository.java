package com.example.CitasMedicas.repositories;

import com.example.CitasMedicas.models.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacientRepository extends JpaRepository<PacientModel, Long> {

}
