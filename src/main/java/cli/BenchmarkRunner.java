package cli;

import algorithms.KadaneAlgorithm;
import metrics.PerformanceTracker;

import java.io.PrintWriter;
import java.nio.file.*;
import java.util.Locale;

public class BenchmarkRunner {
    private static int[] genRandomArray(int n) {
        java.util.Random r = new java.util.Random(42L);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt(2001) - 1000;
        return a;
    }

    public static void main(String[] args) throws Exception {
        int[] sizes = {100, 1000, 10_000, 100_000};
        int runs = 5;

        Path outCsv = Paths.get("docs/performance-plots/kadane.csv");
        Files.createDirectories(outCsv.getParent());

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(outCsv))) {
            pw.println("n,avg_elapsed_ns,avg_comparisons,avg_array_accesses,avg_swaps,mem_bytes");

            for (int n : sizes) {
                long timeSum = 0, cmpSum = 0, accSum = 0, swpSum = 0, memLast = 0;
                int[] data = genRandomArray(n);

                for (int r = 0; r < runs; r++) {
                    PerformanceTracker t = new PerformanceTracker();
                    KadaneAlgorithm.Result res = KadaneAlgorithm.maxSubArray(data, t);

                    timeSum += t.getElapsedNs();
                    cmpSum  += t.getComparisons();
                    accSum  += t.getArrayAccesses();
                    swpSum  += t.getSwaps();
                    memLast  = t.getMemoryBytes();
                }

                long elapsedAvgNs = timeSum / runs;
                long cmpAvg       = cmpSum  / runs;
                long accAvg       = accSum  / runs;
                long swpAvg       = swpSum  / runs;

                pw.printf(Locale.US, "%d,%d,%d,%d,%d,%d%n",
                        n, elapsedAvgNs, cmpAvg, accAvg, swpAvg, memLast);
            }
        }

        System.out.println("CSV saved to docs/performance-plots/kadane.csv");
    }
}

