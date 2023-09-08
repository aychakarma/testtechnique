package com.example.exammen.Repository;

import com.example.exammen.Entities.Arbres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Repository
public interface ArbresRepository  extends JpaRepository<Arbres,BigDecimal> {

    List<Arbres> findByArbresDomanialite(String arbresDomanialite);

    List<Arbres> findByArbresDomanialiteContaining(String arbresDomanialite);

    @Query("SELECT a.arbresCirconferenceencm FROM Arbres a")
    List<Float> getCirconfDataFromDatabase();

    @Query("SELECT YEAR(a.arbresDateplantation) FROM Arbres a")
    List<Integer> getAgeDataFromDatabase();

    // Compte les arbres par espèce
    @Query("SELECT arbres.arbresEspece, COUNT(arbres) FROM Arbres arbres GROUP BY arbres.arbresEspece")
    List<Object[]> countArbresByEspece();


    long countByArbresGenre(String genre);
}
