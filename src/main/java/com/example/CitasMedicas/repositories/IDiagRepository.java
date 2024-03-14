package com.example.CitasMedicas.repositories;

import com.example.CitasMedicas.models.DiagModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiagRepository extends JpaRepository<DiagModel, Long> {
}
