package com.example.exammen.Service;

import com.example.exammen.Entities.Arbres;
import com.example.exammen.Repository.ArbresRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

}
