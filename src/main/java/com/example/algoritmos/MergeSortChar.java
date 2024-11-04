package com.example.algoritmos;

import java.util.Arrays;

public class MergeSortChar {
    public static void main(String[] args) {
        String vetor[] = {"banana", "abacaxi", "laranja", "uva", "manga", "pera", "kiwi"};
        String auxiliar[] = new String[vetor.length];

        System.out.println("Array original: " + Arrays.toString(vetor));
        merge(vetor, auxiliar, 0, vetor.length-1);
        System.out.println("Array ordenado: " + Arrays.toString(vetor));
    }

    private static void merge(String vetor[], String auxiliar[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            merge(vetor, auxiliar, inicio, meio);
            merge(vetor, auxiliar, meio + 1, fim);
            intercalacao(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(String[] vetor, String[] auxiliar, int inicio, int meio, int fim) {
        if (fim + 1 - inicio >= 0) System.arraycopy(vetor, inicio, auxiliar, inicio, fim + 1 - inicio);

        int esquerda = inicio;
        int direita = meio + 1;

        for (int x = inicio; x <= fim; x++) {
            if (esquerda > meio) {
                System.out.println("não existe esquerda");
                vetor[x] = auxiliar[direita++];
            } else if (direita > fim) {
                System.out.println("não existe direita");
                vetor[x] = auxiliar[esquerda++];
            } else if (auxiliar[esquerda].compareTo(auxiliar[direita]) < 0) {
                System.out.println("copiando da esquerda");
                vetor[x] = auxiliar[esquerda++];
            } else {
                System.out.println("copiando da direita");
                vetor[x] = auxiliar[direita++];
            }
        }
        System.out.println(Arrays.toString(vetor));
    }
}
