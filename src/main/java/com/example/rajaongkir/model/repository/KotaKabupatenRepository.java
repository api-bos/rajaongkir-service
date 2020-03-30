package com.example.rajaongkir.model.repository;

import com.example.rajaongkir.model.dim.KotaKabupaten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KotaKabupatenRepository extends JpaRepository<KotaKabupaten, Integer> {
    @Query(value = "SELECT * FROM kota_kab WHERE id_provinsi = :id_provinsi", nativeQuery = true)
    List<KotaKabupaten> getByProvinsiId(@Param("id_provinsi") int id_provinsi);
}
