package com.example.algoritmos;

public class MergeSort {
    public static void main(String[] args) {
        int vetor[] = {2, 1, 4, 5, 3, 7, 8};
        int auxiliar[] = new int[vetor.length];
        mergeia(vetor, auxiliar, 0, vetor.length - 1);
        System.out.println("Vetor ordenado: ");
        for (int x = 0; x < vetor.length; x++) {
            System.out.print(vetor[x] + " ");
        }
    }

    private static void mergeia(int[] vetor, int[] vetorAuxiliar, int inicio, int fim) {
        // sempre que trabalhamos com recursão preciso de um caso base
        if (fim > inicio) {
            int meio = (inicio + fim)/2; // apenas a posição, por isso sempre vai ser inteiro
            mergeia(vetor, vetorAuxiliar, inicio, meio);
            mergeia(vetor, vetorAuxiliar, meio + 1, fim);

            intercalacao(vetor, vetorAuxiliar, inicio, meio, fim);
        }
    }

    private static void intercalacao(int[] vetor, int[] vetorAuxiliar, int inicio, int meio, int fim) {
        for (int x = inicio; x <= fim; x++) {
            vetorAuxiliar[x] = vetor[x]; // alocando todos os valores do vetor original no vetor auxiliar
        }

        // duas variaveis pra ponteiro (uma do merge esquerdo e a outra do merge direito)
        int esquerda = inicio;
        int direita = meio + 1;

        for (int x = inicio; x <= fim; x++) {
            if (esquerda > meio) {
              vetor[x] = vetorAuxiliar[direita];
              direita++;
            } else if (direita > fim) { // vulgo chegou no fim do bloquinho
              vetor[x] = vetorAuxiliar[esquerda];
              esquerda++;
            } else if (vetorAuxiliar[esquerda] < vetorAuxiliar[direita]) {
                vetor[x] = vetorAuxiliar[esquerda]; // se o da esqueda é menor, pega o da direita e copia ele pro vetor
                esquerda++;
            } else {
                vetor[x] = vetorAuxiliar[direita];
                direita++;
            }
        }
    }
}
