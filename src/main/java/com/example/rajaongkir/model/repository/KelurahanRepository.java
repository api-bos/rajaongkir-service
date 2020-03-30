package com.example.rajaongkir.model.repository;

import com.example.rajaongkir.model.dim.Kelurahan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KelurahanRepository extends JpaRepository<Kelurahan, Integer> {
    @Query(value = "SELECT * FROM kelurahan WHERE id_kecamatan = :id_kecamatan", nativeQuery = true)
    List<Kelurahan> getByKecamatanId(@Param("id_kecamatan") int id_kecamatan);
}
