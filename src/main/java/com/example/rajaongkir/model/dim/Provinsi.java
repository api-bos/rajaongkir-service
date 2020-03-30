package com.example.rajaongkir.model.dim;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "provinsi")
public class Provinsi {
    @Id
    private int id_provinsi;
    private String provinsi_name;
}
