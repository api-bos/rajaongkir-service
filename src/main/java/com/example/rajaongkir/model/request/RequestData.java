package com.example.rajaongkir.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestData {
    private String origin;
    private String destination;
    private String weight;
    private String courier;
}
