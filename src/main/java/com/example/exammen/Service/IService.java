package com.example.exammen.Service;

import com.example.exammen.Entities.Arbres;

import java.util.List;

public interface IService {

    public List<Arbres> afficherall();
    List<Arbres> getAllArbres();
    List<Arbres> findByArbresDomanialiteContaining(String arbresDomanialite);

}
