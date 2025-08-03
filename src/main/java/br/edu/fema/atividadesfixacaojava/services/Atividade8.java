package br.edu.fema.atividadesfixacaojava.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Atividade8 implements Atividade {

    public BigDecimal calcListInteger(List<Integer> list) {
        return BigDecimal.valueOf(list.stream().reduce(0, Integer::sum));
    }

    public Optional<Double> calcListDouble(List<Double> list) {
        return list.stream().reduce(Double::sum);
    }

    public OptionalDouble transformListDoubleToIntAndCalcAverage(List<Double> list) {
        return OptionalDouble.of((double) list.stream().mapToInt(Double::intValue).sum() / list.size());
    }


    @Override
    public void result() {
        List<Integer> listInteger = List.of(1, 2, 3, 4, 5);
        List<Double> listDouble = List.of(1.0, 2.0, 3.0, 4.0, 5.0);

        System.out.println("1. Lista de inteiros somada com return BigDecimal: " + calcListInteger(listInteger));
        System.out.println("\n2. Lista de reais somada com return Optional<Double>: " + calcListDouble(listDouble));
        System.out.println("\n3. Lista de reais transformada em números inteiros, média dos números e retorno em OptionalDouble: " + transformListDoubleToIntAndCalcAverage(listDouble));
    }
}
