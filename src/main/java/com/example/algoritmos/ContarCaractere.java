package com.example.algoritmos;

import java.util.Arrays;

public class ContarCaractere {
    private int contarCaracter(String palavra, char caracter) {
        int contador = 0;
        if (palavra.length() == 0) {
            return contador;
        }
        if (palavra.charAt(0) == caracter) {
            contador++;
        }
        return contador + contarCaracter(palavra.substring(1), caracter);
    }

    public static void main(String[] args) {
        ContarCaractere contarCaractere = new ContarCaractere();
        System.out.println(contarCaractere.contarCaracter("araraa", 'a'));
    }
}
