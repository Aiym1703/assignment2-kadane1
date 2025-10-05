package algorithms;

import metrics.PerformanceTracker;

public class KadaneAlgorithm {
    public static class Result {
        public final int maxSum;
        public final int start;
        public final int end;

        public Result(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Result{maxSum=" + maxSum + ", start=" + start + ", end=" + end + "}";
        }
    }

    public static Result maxSubArray(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length == 0) return new Result(0, -1, -1);
        if (tracker != null) { tracker.reset(); tracker.start(); }

        int curSum = arr[0], bestSum = arr[0];
        int curStart = 0, bestStart = 0, bestEnd = 0;
        if (tracker != null) tracker.incArrayAccesses(1);

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            if (tracker != null) tracker.incArrayAccesses(1);

            if (tracker != null) tracker.incComparisons();
            int candidate = curSum + x;
            if (candidate < x) {
                curSum = x;
                curStart = i;
            } else {
                curSum = candidate;
            }

            if (tracker != null) tracker.incComparisons();
            if (curSum > bestSum) {
                bestSum = curSum;
                bestStart = curStart;
                bestEnd = i;
            }
        }

        if (tracker != null) {
            tracker.stop();
            long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            tracker.setMemoryBytes(used);
        }

        return new Result(bestSum, bestStart, bestEnd);
    }
}