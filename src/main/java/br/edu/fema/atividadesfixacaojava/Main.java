package br.edu.fema.atividadesfixacaojava;

import br.edu.fema.atividadesfixacaojava.services.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o número da atividade desejada: ");

        Atividade atividade = switch (input.nextInt()) {
            case 1 -> new Atividade1();
            case 2 -> new Atividade2();
            case 3 -> new Atividade3();
            case 4 -> new Atividade4();
            case 5 -> new Atividade5();
            case 6 -> new Atividade6();
            case 7 -> new Atividade7();
            case 8 -> new Atividade8();
            case 9 -> new Atividade9();
            case 10 -> new Atividade10();
            case 11 -> new Atividade11();
            default -> new Atividade1();
        };

        System.out.println("\n");
        atividade.result();
    }
}
