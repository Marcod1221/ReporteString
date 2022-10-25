package com.proyecto3.reportes.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="reportDepartament")
public class employeDepartament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="id_empleado")
    private Long id_empleado;
    @Column(name="nombre")
    private String nombre;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="hora")
    private Time hora;
    @Column(name="nombre_depto")
    private String nombre_depto;
    
}
