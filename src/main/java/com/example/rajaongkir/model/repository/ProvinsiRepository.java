package com.example.rajaongkir.model.repository;

import com.example.rajaongkir.model.dim.Provinsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvinsiRepository extends JpaRepository<Provinsi, Integer> {
    @Query(value = "SELECT * FROM provinsi ORDER BY id_provinsi", nativeQuery = true)
    List<Provinsi> getAllProvinsi();
}
