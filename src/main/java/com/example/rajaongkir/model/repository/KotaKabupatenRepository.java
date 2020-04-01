package com.example.rajaongkir.model.repository;

import com.example.rajaongkir.model.dim.KotaKabupaten;
import com.example.rajaongkir.model.dim.Provinsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KotaKabupatenRepository extends JpaRepository<KotaKabupaten, Integer> {
    @Query(value = "SELECT * FROM kota_kab WHERE id_provinsi = :id_provinsi ORDER BY id_kota_kab", nativeQuery = true)
    List<KotaKabupaten> getByProvinsiId(@Param("id_provinsi") int id_provinsi);

    @Query(value = "SELECT * FROM kota_kab ORDER BY id_kota_kab", nativeQuery = true)
    List<KotaKabupaten> getAllKotaKab();
}
