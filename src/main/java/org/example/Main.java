package org.example;
/*
bu program Eulerian sayılarını hesaplamak için dinamik programlama yöntemini kullanır. Dinamik programlama, tekrarlanan alt problemleri
çözmek için kullanılan bir optimizasyon tekniğidir. Eulerian sayıları için kullanılan dinamik programlama yaklaşımı, her bir n ve m için
bir tablo oluşturarak, tablodaki her bir hücreyi bir alt problemi temsil edecek şekilde doldurur. Ardından, tablodaki hücreler kullanılarak
büyük bir problem olan Eulerian sayısının hesaplanması sağlanır.
Program kullanıcıdan n ve m değerlerini alır ve bu değerlere bağlı olarak Eulerian sayısını hesaplar. Ardından, hesaplanan Eulerian
sayısını ekrana yazdırır.Bu program, rekürsif çözümlerden kaçınarak, daha verimli ve doğru sonuçlar elde etmek için dinamik programlama
yöntemini kullanır. Bu sayede, büyük n ve m değerleri için de hesaplama yapabilir ve sonuçları hızlı bir şekilde elde edebiliriz.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("n değerini girin: ");
        int n = scanner.nextInt();
        System.out.print("m değerini girin: ");
        int m = scanner.nextInt();

        System.out.println("Eulerian sayısı A(" + n + ", " + m + "): " + eulerian(n, m));
    }

    // Eulerian sayısını hesaplayan metod
    public static int eulerian(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j == 1 || j == i) {
                    dp[i][j] = 1;
                } else if (j > i) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (j * dp[i - 1][j]) + ((i - j + 1) * dp[i - 1][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}