package com.example.rajaongkir.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Costs {
    private String service;
    private String description;
    private ArrayList<Cost> cost;
}
