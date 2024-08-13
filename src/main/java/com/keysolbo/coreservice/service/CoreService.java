package com.keysolbo.coreservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keysolbo.coreservice.database.ManageNacional;
import com.keysolbo.coreservice.model.ArchivosCargados;
import com.keysolbo.coreservice.model.Procesos;

@Service
public class CoreService {
    @Autowired
    private ManageNacional manageNacional;

    public List<ArchivosCargados> retrieveArchivosCargados() {
        return manageNacional.retrieveArchivosCargados();
    }
    public List<ArchivosCargados> retrieveArchivosCargados(String serviceComplain) {
        return manageNacional.retrieveArchivosCargados(serviceComplain);
    }
    public Procesos retrieveAllServiceComplain(){
        return manageNacional.retrieveAllServiceComplain();
    }

}
