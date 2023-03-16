package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Numerotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NumerotationRepository extends JpaRepository<Numerotation, Long> {
    Optional <Numerotation> findByCode(String code);

}
