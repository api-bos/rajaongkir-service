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
public class Results {
    private String code;
    private String name;
    private ArrayList<Costs> costs;
}
