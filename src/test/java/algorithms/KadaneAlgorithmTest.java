package algorithms;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
public class KadaneAlgorithmTest {

    private int bruteMaxSubArray(int[] a) {
        if (a == null || a.length == 0) return 0;
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    @Test void emptyArray() {
        KadaneAlgorithm.Result r = KadaneAlgorithm.maxSubArray(new int[]{}, null);
        assertEquals(0, r.maxSum);
        assertEquals(-1, r.start);
        assertEquals(-1, r.end);
    }
    @Test void singleElement() {
        KadaneAlgorithm.Result r = KadaneAlgorithm.maxSubArray(new int[]{7}, null);
        assertEquals(7, r.maxSum);
        assertEquals(0, r.start);
        assertEquals(0, r.end);
    }
    @Test void allNegative() {
        int[] a = {-5,-2,-11,-3};
        KadaneAlgorithm.Result r = KadaneAlgorithm.maxSubArray(a, null);
        assertEquals(-2, r.maxSum);
        assertEquals(1, r.start);
        assertEquals(1, r.end);
    }
    @Test void duplicates() {
        int[] a = {2,2,-1,2,2};
        assertEquals(bruteMaxSubArray(a), KadaneAlgorithm.maxSubArray(a, null).maxSum);
    }
    @Test void classicExample() {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        KadaneAlgorithm.Result r = KadaneAlgorithm.maxSubArray(a, null);
        assertEquals(6, r.maxSum);  // [4,-1,2,1]
        assertEquals(3, r.start);
        assertEquals(6, r.end);
    }
    @Test void sortedIncreasing() {
        int[] a = {-5,-4,-3,-2,10,11,12};
        assertEquals(bruteMaxSubArray(a), KadaneAlgorithm.maxSubArray(a, null).maxSum);
    }
    @Test void sortedDecreasing() {
        int[] a = {9,7,5,3,1,-10};
        assertEquals(bruteMaxSubArray(a), KadaneAlgorithm.maxSubArray(a, null).maxSum);
    }
    @Test void nearlySorted() {
        int[] a = new int[100];
        for (int i=0;i<100;i++) a[i]=i-50;
        int t = a[2]; a[2]=a[3]; a[3]=t;
        t = a[70]; a[70]=a[40]; a[40]=t;
        assertEquals(bruteMaxSubArray(a), KadaneAlgorithm.maxSubArray(a, null).maxSum);
    }

    // Property-based
    @Test void propertyRandom100cases() {
        Random rnd = new Random(42);
        for (int t = 0; t < 100; t++) {
            int n = 1 + rnd.nextInt(200);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = rnd.nextInt(200) - 100;
            assertEquals(bruteMaxSubArray(a), KadaneAlgorithm.maxSubArray(a, null).maxSum);
        }
    }
}
