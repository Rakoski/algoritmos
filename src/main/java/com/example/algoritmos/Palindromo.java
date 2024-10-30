package com.example.algoritmos;

public class Palindromo {
    private static boolean palindromo(String palavra) {
        int inicio = 0;
        int fim = palavra.length() - 1;
        while (inicio < fim) {
            char letraInicial = palavra.charAt(inicio);
            char letraFinal = palavra.charAt(fim);
            if (letraInicial != letraFinal) {
                return false;
            }
            inicio++;
            fim--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(palindromo("arara"));
//        System.out.println(palindromo("ananas"));
        System.out.println(palindromo("sator arepo tenet opera rotas"));
    }
}
