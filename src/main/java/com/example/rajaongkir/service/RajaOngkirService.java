package com.example.rajaongkir.service;

import bca.bit.proj.library.base.ResultEntity;
import bca.bit.proj.library.enums.ErrorCode;
import com.example.rajaongkir.model.dim.Kecamatan;
import com.example.rajaongkir.model.dim.Kelurahan;
import com.example.rajaongkir.model.dim.KotaKabupaten;
import com.example.rajaongkir.model.dim.Provinsi;
import com.example.rajaongkir.model.repository.KecamatanRepository;
import com.example.rajaongkir.model.repository.KelurahanRepository;
import com.example.rajaongkir.model.repository.KotaKabupatenRepository;
import com.example.rajaongkir.model.repository.ProvinsiRepository;
import com.example.rajaongkir.model.request.RequestData;
import com.example.rajaongkir.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.ProxyProvider;

import java.util.List;

@Service
public class RajaOngkirService {

    private HttpClient tmp_httpClient = HttpClient.create()
            .tcpConfiguration(tcpClient ->
                    tcpClient.proxy(proxy -> proxy.type(ProxyProvider.Proxy.HTTP).host("10.17.10.42").port(8080)));

    private ReactorClientHttpConnector tmp_connector = new ReactorClientHttpConnector(tmp_httpClient);

    private WebClient g_webClient = WebClient.builder().baseUrl("https://api.rajaongkir.com/starter")
            .clientConnector(tmp_connector)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE).build();

    @Autowired
    ProvinsiRepository g_provinsiRepository;
    @Autowired
    KotaKabupatenRepository g_kotaKabupatenRepository;
    @Autowired
    KecamatanRepository g_kecamatanRepository;
    @Autowired
    KelurahanRepository g_kelurahanRepository;

    public ResultEntity getCost(RequestData p_requestData){
        ResultEntity l_output;

        try {
            ResponseData tmp_ResponseData = g_webClient.post().uri("/cost")
                    .accept(MediaType.APPLICATION_JSON)
                    .header("key", "35e56bae6b5fcd7f4ca04a1c7b0fdfc8")
                    .body(BodyInserters
                            .fromFormData("origin", p_requestData.getOrigin())
                            .with("destination", p_requestData.getDestination())
                            .with("weight", p_requestData.getWeight())
                            .with("courier", p_requestData.getCourier()))
                    .retrieve()
                    .bodyToMono(ResponseData.class)
                    .block();

            l_output = new ResultEntity(tmp_ResponseData.getRajaongkir().getResults(), ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }

    public ResultEntity getProvince(){
        ResultEntity l_output;

        try {
            List<Provinsi> tmp_provinsiList = g_provinsiRepository.getAllProvinsi();

            l_output = new ResultEntity(tmp_provinsiList, ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }

    public ResultEntity getKotaKab(int p_provinsiId){
        ResultEntity l_output;

        try {
            List<KotaKabupaten> tmp_kotaKabupatenList = g_kotaKabupatenRepository.getByProvinsiId(p_provinsiId);

            l_output = new ResultEntity(tmp_kotaKabupatenList, ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }

    public ResultEntity getKecamatan(int p_kotaKabId){
        ResultEntity l_output;

        try {
            List<Kecamatan> tmp_kecamatanList = g_kecamatanRepository.getByKotaKabId(p_kotaKabId);

            l_output = new ResultEntity(tmp_kecamatanList, ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }

    public ResultEntity getKelurahan(int p_kecamatanId){
        ResultEntity l_output;

        try {
            List<Kelurahan> kelurahanList = g_kelurahanRepository.getByKecamatanId(p_kecamatanId);

            l_output = new ResultEntity(kelurahanList, ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }

    public ResultEntity getKotaKab(){
        ResultEntity l_output;

        try {

            l_output = new ResultEntity(g_kotaKabupatenRepository.getAllKotaKab(), ErrorCode.BIT_000);

        }catch (Exception e){
            e.printStackTrace();

            l_output = new ResultEntity(e.toString(), ErrorCode.BIT_999);
        }

        return l_output;
    }
}
