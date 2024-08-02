
package main.java.problemas.edd;

import java.util.Scanner;

public class ParesN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 

        System.out.print("Digite n: ");
        int n = scan.nextInt();  

        System.out.println();
        System.out.println("Lista de pares até o valor de n:");
        Pares(n);

        scan.close();
    }

    public static void Pares(int n) {
        if (n >= 0) {
            Pares(n-1);

            if (n%2==0) {
                System.out.println("* " + n);
            }
        }
    }
}

