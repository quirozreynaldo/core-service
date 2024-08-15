package com.keysolbo.coreservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.keysolbo.coreservice.model.ArchivosCargados;
import com.keysolbo.coreservice.model.Procesos;
import com.keysolbo.coreservice.service.CoreService;

@RequestMapping("/api")
@RestController
public class CoreController {
    @Autowired
    private CoreService coreService;

    @GetMapping("/archivos")
    public ResponseEntity<List<ArchivosCargados>> retrieveCantidadArchivos() {
        List<ArchivosCargados> archivos = coreService.retrieveArchivosCargados();
        return ResponseEntity.status(200).body(archivos);
    }

    @GetMapping("/archivos/{serviceComplain}")

    public ResponseEntity<List<ArchivosCargados>> retrieveCantidadArchivos(@PathVariable String serviceComplain) {
        List<ArchivosCargados> archivos = coreService.retrieveArchivosCargados(serviceComplain);
        return ResponseEntity.status(200).body(archivos);
    }
    @GetMapping("/procesos")
    public ResponseEntity<List<Procesos>> retrieveAllServiceComplain() {
        List<Procesos> archivos = coreService.retrieveAllServiceComplain();
        return ResponseEntity.status(200).body(archivos);
    }


}
