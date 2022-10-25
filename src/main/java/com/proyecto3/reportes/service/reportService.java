package com.proyecto3.reportes.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.proyecto3.reportes.entity.employeDepartament;
import com.proyecto3.reportes.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class reportService {
    
    @Autowired
    EmployeeRepository employeeRepository; 

    public String exportReport() throws FileNotFoundException, JRException{
        // ruta para guardar el reporte
        String path = "C:\\Users\\marpe\\Desktop";

        // obtenemos y guardamos los registros
        List<employeDepartament> employee = employeeRepository.findAll();

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:employeeDepartament.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employee);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");

        return "Reporte generado en la siguiente ruta: " + path;

    }
}
