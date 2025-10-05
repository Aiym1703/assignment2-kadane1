package metrics;

public class PerformanceTracker {
    private long startNs, elapsedNs, comparisons, arrayAccesses, swaps, memoryBytes;

    public void reset(){ startNs=0; elapsedNs=0; comparisons=0; arrayAccesses=0; swaps=0; memoryBytes=0; }
    public void start(){ startNs = System.nanoTime(); }
    public void stop(){ elapsedNs = System.nanoTime() - startNs; }

    public void incComparisons(){ comparisons++; }
    public void incArrayAccesses(int n){ arrayAccesses += n; }
    public void incSwaps(){ swaps++; } // unused for Kadane, kept for rubric symmetry

    public long getElapsedNs(){ return elapsedNs; }
    public long getComparisons(){ return comparisons; }
    public long getArrayAccesses(){ return arrayAccesses; }
    public long getSwaps(){ return swaps; }
    public long getMemoryBytes(){ return memoryBytes; }
    public void setMemoryBytes(long b){ memoryBytes = b; }
}
