package com.example.algoritmos;

import java.util.Arrays;

public class PessoaLista {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("João", 25),
                new Pessoa("Maria", 19),
                new Pessoa("Pedro", 32),
                new Pessoa("Ana", 22),
                new Pessoa("Carlos", 28)
        };

        System.out.println("Array original: " + Arrays.toString(pessoas));
        Pessoa[] auxiliar = new Pessoa[pessoas.length];
        merge(pessoas, auxiliar, 0, pessoas.length - 1);
        System.out.println("Array ordenado: " + Arrays.toString(pessoas));
    }

    private static void merge(Pessoa[] vetor, Pessoa[] auxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            merge(vetor, auxiliar, inicio, meio);
            merge(vetor, auxiliar, meio + 1, fim);
            intercalacao(vetor, auxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(Pessoa[] vetor, Pessoa[] auxiliar, int inicio, int meio, int fim) {
        for (int x = inicio; x <= fim; x++) {
            auxiliar[x] = vetor[x];
        }

        int esquerda = inicio;
        int direita = meio + 1;

        for (int x = inicio; x <= fim; x++) {
            if (esquerda > meio) {
                vetor[x] = auxiliar[direita++];
            } else if (direita > fim) {
                vetor[x] = auxiliar[esquerda++];
            } else if (auxiliar[esquerda].getIdade() < auxiliar[direita].getIdade()) {
                vetor[x] = auxiliar[esquerda++];
            } else {
                vetor[x] = auxiliar[direita++];
            }
        }
        System.out.println(Arrays.toString(vetor));
    }
}
