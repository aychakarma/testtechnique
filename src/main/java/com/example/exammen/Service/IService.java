package com.example.exammen.Service;

import com.example.exammen.Entities.Arbres;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IService {

    public List<Arbres> afficherall();
    List<Arbres> getAllArbres();
    List<Arbres> findByArbresDomanialiteContaining(String arbresDomanialite);
    List<Float> getCirconfDataFromDatabase();
    List<Integer> getAgeDataFromDatabase();
    double calculateCorrelation(List<Float> circonf, List<Integer> age);
    public Map<String, Double> calculateArbresDensityByQuartier();
    public Arbres ajouteraa (Arbres c);

    void deleteArbreByArbresIdbase(BigDecimal arbresIdbase);
    public List<Object[]> countArbresByEspece();
}
