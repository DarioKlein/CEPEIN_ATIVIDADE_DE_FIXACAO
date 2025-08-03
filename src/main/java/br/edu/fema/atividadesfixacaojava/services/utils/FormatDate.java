package br.edu.fema.atividadesfixacaojava.services.utils;

import java.time.LocalDate;
import java.util.List;

public class FormatDate {

    private FormatDate() {}

    public static LocalDate format(String date) {
        if (!date.contains("/")) {
            throw new RuntimeException("A data passada não possui o formato adequado");
        }

        return LocalDate.parse(arrayDateToStringDate(changeArrayOrder(date)));
    }

    private static String arrayDateToStringDate(List<String> dates) {
        return String.join("-", dates);
    }

    private static List<String> changeArrayOrder(String date) {
        String[] parts = date.split("/");
        return List.of(parts[2], parts[1], parts[0]);
    }
}
