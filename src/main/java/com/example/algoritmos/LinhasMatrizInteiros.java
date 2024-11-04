package com.example.algoritmos;

import java.util.Arrays;

public class LinhasMatrizInteiros {
    public static void main(String[] args) {
        int[][] matriz = {
                {5, 2, 9},
                {1, 1, 1},
                {3, 4, 2},
                {8, 1, 1}
        };

        System.out.println("Matriz: ");
        printMatrix(matriz);

        int[][] auxiliar = new int[matriz.length][];
        for (int i = 0; i < matriz.length; i++) {
            auxiliar[i] = new int[matriz[i].length];
        }

        merge(matriz, auxiliar, 0, matriz.length - 1);

        System.out.println("\nMatriz ordenada (por soma das linhas):");
        printMatrix(matriz);
    }

    private static void merge(int[][] matriz, int[][] auxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            merge(matriz, auxiliar, inicio, meio);
            merge(matriz, auxiliar, meio + 1, fim);
            intercalacao(matriz, auxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(int[][] matriz, int[][] auxiliar, int inicio, int meio, int fim) {
        for (int x = inicio; x <= fim; x++) {
            auxiliar[x] = matriz[x].clone();
        }

        int esquerda = inicio;
        int direita = meio + 1;

        for (int x = inicio; x <= fim; x++) {
            if (esquerda > meio) {
                matriz[x] = auxiliar[direita++];
            } else if (direita > fim) {
                matriz[x] = auxiliar[esquerda++];
            } else if (somaLinha(auxiliar[esquerda]) < somaLinha(auxiliar[direita])) {
                matriz[x] = auxiliar[esquerda++];
            } else {
                matriz[x] = auxiliar[direita++];
            }
        }

        printMatrix(matriz);
    }

    private static int somaLinha(int[] linha) {
        int soma = 0;
        for (int valor : linha) {
            soma += valor;
        }
        return soma;
    }

    private static void printMatrix(int[][] matriz) {
        for (int[] linha : matriz) {
            System.out.println(Arrays.toString(linha) + " (soma: " + somaLinha(linha) + ")");
        }
    }
}
