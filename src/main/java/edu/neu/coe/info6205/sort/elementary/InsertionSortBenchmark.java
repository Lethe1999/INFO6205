package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Random;
import java.util.function.Supplier;

public class InsertionSortBenchmark {

    public static void main(String[] args) {

        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Benchmark_Timer<Integer[]> timer = new Benchmark_Timer<>("Insertion sort benchmark tests",
                xs -> insertionSort.sort(xs, 0, xs.length));

        System.out.println("---------- Random array ----------");
        for (int n = 500; n <= 16000; n *= 2) {
            int N = n;
            // Random Array
            Supplier<Integer[]> randomArray = () -> {
                Random random = new Random();
                Integer[] arr = new Integer[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = random.nextInt(N);
                }
                return arr;
            };
            // Warm up and start tests
            double meanTime = timer.runFromSupplier(randomArray, 30);
            System.out.println("Size:" + N + "\tMean time:" + meanTime);
        }

        System.out.println("---------- Ordered array ----------");
        for (int n = 500; n <= 16000; n *= 2) {
            int N = n;
            // Ordered Array
            Supplier<Integer[]> ordered = () -> {
                Integer[] arr = new Integer[N];
                for (int i = 0; i < N; i++) {
                    arr[i] = i;
                }
                return arr;
            };
            // Warm up and start tests
            double meanTime = timer.runFromSupplier(ordered, 30);
            System.out.println("Size:" + N + "\tMean time:" + meanTime);
        }

        System.out.println("---------- Partially-ordered array ----------");
        for (int n = 500; n <= 16000; n *= 2) {
            int N = n;
            // Partially-ordered Array
            Supplier<Integer[]> partiallyOrdered = () -> {
                Integer[] arr = new Integer[N];
                Random random = new Random();
                int sep = N / 3;    // One third of the array will be in ordered
                for (int i = 0; i < sep; i++) {
                    arr[i] = random.nextInt(N);
                }
                for (int i = sep; i < sep * 2; i++) {
                    arr[i] = i;
                }
                for (int i = sep * 2; i < N; i++) {
                    arr[i] = random.nextInt(N);
                }
                return arr;
            };
            // Warm up and start tests
            double meanTime = timer.runFromSupplier(partiallyOrdered, 30);
            System.out.println("Size:" + N + "\tMean time:" + meanTime);
        }

        System.out.println("---------- Reverse-ordered array ----------");
        for (int n = 500; n <= 16000; n *= 2) {
            int N = n;
            // Reverse-ordered Array
            Supplier<Integer[]> reverseOrdered = () -> {
                Integer[] arr = new Integer[N];
                int num = N - 1;
                for (int i = 0; i < N; i++) {
                    arr[i] = num--;
                }
                return arr;
            };
            // Warm up and start tests
            double meanTime = timer.runFromSupplier(reverseOrdered, 30);
            System.out.println("Size:" + N + "\tMean time:" + meanTime);
        }

    }
}
