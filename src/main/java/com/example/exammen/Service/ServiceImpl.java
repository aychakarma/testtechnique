package com.example.exammen.Service;

import com.example.exammen.Entities.Arbres;
import com.example.exammen.Repository.ArbresRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ServiceImpl implements  IService{

     ArbresRepository arbrerepo;
    @Override
    public List<Arbres> afficherall() {
        return arbrerepo.findAll();
    }

    @Override
    public List<Arbres> getAllArbres() {
        return arbrerepo.findAll();
    }

    @Override
    public List<Arbres> findByArbresDomanialiteContaining(String arbresDomanialite) {
        return arbrerepo.findByArbresDomanialiteContaining(arbresDomanialite);
    }

    @Override
    public List<Float> getCirconfDataFromDatabase() {
        return arbrerepo.getCirconfDataFromDatabase();
    }

    @Override
    public List<Integer> getAgeDataFromDatabase() {
        return arbrerepo.getAgeDataFromDatabase();
    }

    @Override
    public double calculateCorrelation(List<Float> circonf, List<Integer> age) {
        double[] circonfArray = circonf.stream().mapToDouble(Float::doubleValue).toArray();
        double[] ageArray = age.stream().mapToDouble(Integer::doubleValue).toArray();

        // Utilisez la classe PearsonsCorrelation pour calculer la corrélation
        PearsonsCorrelation correlation = new PearsonsCorrelation();
        double correlationValue = correlation.correlation(circonfArray, ageArray);

        return correlationValue;
    }

    @Override
    public Map<String, Double>  calculateArbresDensityByQuartier() {
        // Récupérez toutes les données des arbres depuis la base de données
        List<Arbres> arbresList = arbrerepo.findAll();

        // Initialisez une structure de données pour stocker la densité par arrondissement
        Map<String, Double> arrondissementDensityMap = new HashMap<>();

        // Parcourez la liste des arbres et calculez la densité par arrondissement
        for (Arbres arbre : arbresList) {
            String arrondissement = arbre.getArbresArrondissement(); // Remplacez par l'attribut réel contenant l'arrondissement

            // Vérifiez si l'arrondissement est déjà présent dans la carte
            if (arrondissementDensityMap.containsKey(arrondissement)) {
                // Si oui, incrémentez la densité existante
                double density = arrondissementDensityMap.get(arrondissement);
                arrondissementDensityMap.put(arrondissement, density + 1.0); // Vous pouvez ajuster le calcul en fonction de vos besoins
            } else {
                // Si non, ajoutez l'arrondissement à la carte avec une densité de 1
                arrondissementDensityMap.put(arrondissement, 1.0); // Vous pouvez ajuster le calcul en fonction de vos besoins
            }
        }

        return arrondissementDensityMap;
    }

    @Override
    public Arbres ajouteraa(Arbres c) {
        // Ajoutez la logique de validation ou de traitement si nécessaire
        return arbrerepo.save(c);
    }

    @Override
    public void deleteArbreByArbresIdbase(BigDecimal arbresIdbase) {
        arbrerepo.deleteById(arbresIdbase);
    }

    public List<Object[]> countArbresByEspece() {
        return arbrerepo.countArbresByEspece();
    }

}
