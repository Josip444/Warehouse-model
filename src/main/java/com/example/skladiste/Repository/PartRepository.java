package com.example.skladiste.Repository;

import com.example.skladiste.Model.Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Parts,Long> {
}
