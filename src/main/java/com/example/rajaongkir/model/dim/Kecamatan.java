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
@Table(name = "kota_kab")
public class Kecamatan {
    @Id
    private int id_kecamatan;
    private int id_kota_kab;
    private String kecamatan_name;
}
