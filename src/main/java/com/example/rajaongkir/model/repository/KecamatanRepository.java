package com.example.rajaongkir.model.repository;

import com.example.rajaongkir.model.dim.Kecamatan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KecamatanRepository extends JpaRepository<Kecamatan, Integer> {
    @Query(value = "SELECT * FROM kecamatan WHERE id_kota_kab = :id_kota_kab ORDER BY id_kecamatan", nativeQuery = true)
    List<Kecamatan> getByKotaKabId(@Param("id_kota_kab") int id_kota_kab);
}
