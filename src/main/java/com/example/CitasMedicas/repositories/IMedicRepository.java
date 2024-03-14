package com.example.CitasMedicas.repositories;

import com.example.CitasMedicas.models.MedicModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicRepository extends JpaRepository<MedicModel, Long> {
}
