package com.example.CitasMedicas.repositories;

import com.example.CitasMedicas.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {



}
