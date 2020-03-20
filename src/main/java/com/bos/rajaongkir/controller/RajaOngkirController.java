package com.bos.rajaongkir.controller;

import com.bos.rajaongkir.service.RajaOngkirService;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bos")
public class RajaOngkirController {
    @Autowired
    RajaOngkirService rajaOngkirService;

    @GetMapping("/province")
    public Response getProvince() throws Exception{
        return rajaOngkirService.getProvince();
    }
}

