package br.edu.fema.atividadesfixacaojava.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Atividade11 implements Atividade {

    private Map<String, List<String>> fruitsByColor() {
        Map<String, List<String>> mapFruits = new HashMap<>();

        mapFruits.put("Vermelha", Arrays.asList("Maçã", "Morango", "Cereja"));
        mapFruits.put("Amarela", Arrays.asList("Banana", "Abacaxi", "Manga"));
        mapFruits.put("Verde", Arrays.asList("Kiwi", "Uva Verde", "Maçã Verde"));
        mapFruits.put("Roxa", Arrays.asList("Uva", "Ameixa", "Jabuticaba"));
        mapFruits.put("Laranja", Arrays.asList("Laranja", "Cenoura", "Caqui"));
        mapFruits.put("Branca", Arrays.asList("Pêra", "Coco", "Melão"));

        return mapFruits;
    }


    @Override
    public void result() {
        Map<String, List<String>> mapFruits = fruitsByColor();

        System.out.println("Iterando o Map com ForEach Funcional");
        mapFruits.forEach((color, fruits) -> {
            System.out.println(color + " - " + fruits);
        });

        System.out.println("Iterando o Map com ForEach (sem usar a API de Stream, Programação Funcional e Method Reference)");
        for (Map.Entry<String, List<String>> entry : mapFruits.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
