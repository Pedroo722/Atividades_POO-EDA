package exercises.problems;

import java.util.*;

public class ShellSort {
    public static void main(String[] args) {
        int numeros[] = { 199, -1, 45, 75, 90, 802, 24, 2, 66 };

		System.out.println("Lista original: " + "\n" + Arrays.toString(numeros) + "\n");

        shellSort(numeros);

        System.out.println("Lista ordenada por Shell Sort: " + "\n" + Arrays.toString(numeros));
    }


    // Algoritmo extensão do InsertSort
    public static void shellSort(int[] numeros){
	    int i, j, temp;
        int tamanho = numeros.length;
	    
	    int incremento = 1;

        // repete até incremento ser maior que o tamanho do array
	    while(incremento < tamanho) {
	        incremento = 3 * incremento + 1;
	    }
	     
	    while (incremento > 1) {
	        incremento = incremento / 3;
	        
            // percore o array com base no index igual ao incremento até o final
	        for (i = incremento; i < tamanho; i++) {
	            temp = numeros[i];
	            j = i - incremento;

                // compara e troca os elemntos
	            while (j >= 0 && temp < numeros[j]) {
	                numeros[j + incremento] = numeros[j];
	                j -= incremento;
	            }

                // insere o elemento temporario no array
	            numeros [j + incremento] = temp;
	        }
	    }	    
	}	
}