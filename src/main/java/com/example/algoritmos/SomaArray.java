package com.example.algoritmos;

import java.util.Arrays;

public class SomaArray {
    private static int somaArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }

        int somaComAPropriaFuncao = array[0] + somaArray(Arrays.copyOfRange(array, 1, array.length));
        return somaComAPropriaFuncao;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(somaArray(array));
    }
}
