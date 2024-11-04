package com.example.algoritmos;

public class SomaDigitosInteiro {
    private static int somaDigitosInteiros(int numero) {
        if (numero < 10) {
            return numero;
        }
        return numero % 10 + somaDigitosInteiros(numero / 10);
    }

    public static void main(String[] args) {
        System.out.println(somaDigitosInteiros(123));
    }
}
