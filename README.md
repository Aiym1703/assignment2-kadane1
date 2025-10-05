
---

## 🧩 Implementation Details

### 🔹 Algorithm
The `KadaneAlgorithm.java` file contains the main logic.  
It iterates through the array while maintaining:
- `curSum` → current subarray sum  
- `bestSum` → maximum sum found so far  
- `start` & `end` → indices of the best subarray  

### 🔹 Performance Metrics
`PerformanceTracker.java` measures:
- Comparisons  
- Array accesses  
- Swaps (if applicable)  
- Memory usage  
- Execution time (nanoseconds)

The data is saved as a CSV file inside `docs/performance-plots/kadane.csv`.

### 🔹 CLI Benchmark
`BenchmarkRunner.java` automatically runs benchmarks with:
- Input sizes: `100, 1000, 10000, 100000`
- Profiles: random, positive, negative, nearly-sorted
- Outputs: time, comparisons, and memory in `.csv` + auto-generated charts (`.png`)

---

## 🧪 Testing
JUnit tests (`KadaneAlgorithmTest.java`) cover:
- Empty array  
- Single element  
- All negative elements  
- Duplicates and mixed values  
- Random property-based tests  

✅ Verified correctness with `bruteMaxSubArray()` comparison for 100 random cases.


---

## 🛠️ Branch & Workflow
| Branch | Purpose |
|--------|----------|
| `main` | final release |
| `feature/algorithm` | main Kadane algorithm |
| `feature/metrics` | performance tracking |
| `feature/testing` | JUnit tests |
| `feature/cli` | CLI benchmark |
| `feature/optimization` | potential improvements |


### Covered Cases
| Test Name | Description |
|------------|-------------|
| `emptyArray` | Handles empty input gracefully |
| `singleElement` | Single positive or negative number |
| `allNegative` | Array with only negative numbers |
| `duplicates` | Tests repeated values |
| `classicExample` | Standard textbook case |
| `sortedIncreasing` / `sortedDecreasing` | Monotonic sequences |
| `propertyRandom100cases` | Random arrays for property-based testing |

All tests pass successfully (`mvn test` ✅).

---

## 🧠 Metrics Tracked
Implemented in `PerformanceTracker.java`:
- Comparisons
- Array accesses
- Memory usage (bytes)
- Execution time (ns)

- **Best case:** Θ(n)  
- **Average case:** O(n)  
- **Worst case:** O(n)  
- **Space complexity:** O(1) – in-place, no extra array needed.  


Benchmark results are automatically written to `docs/performance-plots/kadane.csv`.
<img width="812" height="495" alt="image" src="https://github.com/user-attachments/assets/feade41b-4bcd-4225-a570-8bfafccb5c0d" />


<img width="596" height="173" alt="image" src="https://github.com/user-attachments/assets/03d72407-1583-4aec-874b-e71ba30c7c96" />


