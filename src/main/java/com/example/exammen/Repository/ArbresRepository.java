package com.example.exammen.Repository;

import com.example.exammen.Entities.Arbres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Repository
public interface ArbresRepository  extends JpaRepository<Arbres,BigDecimal>{

    List<Arbres> findByArbresDomanialite(String arbresDomanialite);
    List<Arbres> findByArbresDomanialiteContaining(String arbresDomanialite);
}
