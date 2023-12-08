package com.mylabs.pds.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SumarSemanasAFecha {
    public static void main(String[] args) {
        // Fecha inicial
        String fechaInicialString = "28/01/2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaInicial = LocalDate.parse(fechaInicialString, formatter);

        // Sumar 12 semanas
        LocalDate fechaResultado = fechaInicial.plusWeeks(3);

        // Imprimir el resultado
        System.out.println("Fecha inicial: " + fechaInicial.format(formatter));
        System.out.println("Fecha después de sumar x semanas: " + fechaResultado.format(formatter));
    }
}
