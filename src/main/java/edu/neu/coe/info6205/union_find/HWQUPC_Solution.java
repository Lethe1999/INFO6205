package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {

    /**
     * Return the number of connections
     *
     * @param n
     * @return cnt_connection
     */
    public static int count(int n) {
        Random random = new Random();

        UF_HWQUPC uf = new UF_HWQUPC(n, true);  // Create an object

        int cnt_connection = 0;     // Number of pairs
        while (uf.components() > 1) {
            uf.connect(random.nextInt(n), random.nextInt(n));   // Generate a new pair randomly
            cnt_connection++;
        }

        return cnt_connection;
    }

    public static void main(String[] args) {
        for (int n = 10; n < 5000; n += 100) {
            System.out.print("n = " + n);
//            System.out.println("\t\tm = " + count(n));

            // Calculate the average m
            int m = 0;
            for (int j = 0; j < 10; j++) {
                m += count(n);
            }
            System.out.println("\t\tm = " + m / 10);
        }
    }
}
