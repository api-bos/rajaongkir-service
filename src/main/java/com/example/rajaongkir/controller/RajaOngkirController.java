package com.example.rajaongkir.controller;

import bca.bit.proj.library.base.ResultEntity;
import com.example.rajaongkir.model.request.RequestData;
import com.example.rajaongkir.service.RajaOngkirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bos")
@CrossOrigin(origins = {"*"})
public class RajaOngkirController {
    @Autowired
    RajaOngkirService g_rajaOngkirService;

    @PostMapping("/ongkir")
    public ResultEntity getCost(@RequestBody RequestData p_requestData){
        return g_rajaOngkirService.getCost(p_requestData);
    }

    @GetMapping("/provinsi")
    public ResultEntity getProvinsi(){
        return g_rajaOngkirService.getProvince();
    }

    @GetMapping("/kota-kab/{id_provinsi}")
    public ResultEntity getKotaKab(@PathVariable("id_provinsi") int p_provinsiId){
        return g_rajaOngkirService.getKotaKab(p_provinsiId);
    }

    @GetMapping("/kecamatan/{id_kota_kab}")
    public ResultEntity getKecamatan(@PathVariable("id_kota_kab") int p_kotaKabId){
        return g_rajaOngkirService.getKecamatan(p_kotaKabId);
    }

    @GetMapping("/kelurahan/{id_kecamatan}")
    public ResultEntity getKelurahan(@PathVariable("id_kecamatan") int p_kecamatanId){
        return g_rajaOngkirService.getKelurahan(p_kecamatanId);
    }

    @GetMapping("/kota-kab")
    public ResultEntity getKotaKab(){
        return g_rajaOngkirService.getKotaKab();
    }
}
