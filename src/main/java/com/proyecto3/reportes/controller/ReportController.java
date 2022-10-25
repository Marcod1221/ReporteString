package com.proyecto3.reportes.controller;

import com.proyecto3.reportes.entity.employeDepartament;
import com.proyecto3.reportes.repository.EmployeeRepository;
import com.proyecto3.reportes.service.reportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private reportService service;

    @GetMapping("/getEmployees")
    public List<employeDepartament> getEmployees() {
        return repository.findAll();
    }

    @GetMapping("/report")
    public String generateReport() throws FileNotFoundException, JRException {
        return service.exportReport();
    }
}
