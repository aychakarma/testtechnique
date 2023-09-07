package com.example.exammen.Controller;


import com.example.exammen.Entities.Arbres;
import com.example.exammen.Service.IService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {
    IService i;
    @GetMapping("/getallusers")
    public ResponseEntity<?> getAllusers()
    {
        List<Arbres> users = i.afficherall();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/arbre")
    public List<Arbres> getAllArbres() {
        return i.afficherall();
    }
    @GetMapping("/arbres")
    public String afficherArbres(Model model) {
        List<Arbres> arbres = i.afficherall(); // Remplacez par votre méthode pour récupérer les arbres depuis la base de données.
        model.addAttribute("arbres", arbres);
        return "arbres"; // Assurez-vous que le nom correspond au nom de votre fichier HTML (arbres.html).
    }
    @GetMapping("/test")
    public String testThymeleaf(Model model) {
        model.addAttribute("message", "Ceci est un test Thymeleaf.");
        return "test"; // Créez une vue Thymeleaf nommée "test.html".
    }
    @GetMapping("/chart")
    public String showChart(Model model) {
        // Vous pouvez ici obtenir les données de la base de données si nécessaire
        // et les passer à la page Thymeleaf.
        // Exemple : List<Arbre> arbres = service.getArbres();
        // model.addAttribute("arbres", arbres);

        return "arbres"; // Assurez-vous que "chart" correspond au nom de votre fichier HTML sans l'extension.
    }

    @GetMapping("/getallarbres")
    public ResponseEntity<List<Arbres>> getAlllArbres() {
        List<Arbres> arbres = i.getAllArbres();
        return ResponseEntity.ok(arbres);
    }
    @GetMapping("/equipes")
    public List<Arbres> chercherParNom(@RequestParam("arbresDomanialite") String arbresDomanialite) {
        return i.findByArbresDomanialiteContaining(arbresDomanialite);
    }
    @GetMapping("/circonf-data")
    public List<Float> getCirconfData() {
        return i.getCirconfDataFromDatabase();
    }

    @GetMapping("/age-data")
    public List<Integer> getAgeData() {
        return i.getAgeDataFromDatabase();
    }

    @GetMapping("/correlation")
    public double calculateCorrelation() {
        List<Float> circonfData = i.getCirconfDataFromDatabase();
        List<Integer> ageData = i.getAgeDataFromDatabase();

        return i.calculateCorrelation(circonfData, ageData);
    }
    @GetMapping("/arbres-density")
    public String calculateArbresDensityByQuartier(Model model) {
        Map<String, Double> quartierDensityMap = i.calculateArbresDensityByQuartier();
        model.addAttribute("quartierDensityMap", quartierDensityMap);
        return "arbresd"; // Ceci correspondra au nom du fichier HTML (arbres-density.html)
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Arbres> ajouterArbre(@RequestBody Arbres arbre) {
        Arbres arbreAjoute = i.ajouteraa(arbre);
        return ResponseEntity.status(HttpStatus.CREATED).body(arbreAjoute);
    }
    @DeleteMapping("/delete/{arbresIdbase}")
    public ResponseEntity<String> deleteArbreByArbresIdbase(@PathVariable BigDecimal arbresIdbase) {
        i.deleteArbreByArbresIdbase(arbresIdbase);
        return ResponseEntity.ok("L'arbre avec l'arbresIdbase " + arbresIdbase + " a été supprimé avec succès.");
    }
    @GetMapping("/distribution-especes")
    public String distributionEspeces(Model model) {
        List<Object[]> especesCount = i.countArbresByEspece();
        model.addAttribute("especesCount", especesCount);
        return "dis"; // Nom de la vue HTML
    }
}
