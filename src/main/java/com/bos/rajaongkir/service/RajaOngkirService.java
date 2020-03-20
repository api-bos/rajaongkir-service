package com.bos.rajaongkir.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

@Service
public class RajaOngkirService {
    public Response getProvince() throws Exception{
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.rajaongkir.com/starter/province")
                .get()
                .addHeader("key", "35e56bae6b5fcd7f4ca04a1c7b0fdfc8")
                .build();

        Response response = client.newCall(request).execute();

        return response;
    }
}

