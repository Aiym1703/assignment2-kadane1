## 📘 Project Overview
This project implements **Kadane’s Algorithm**, a linear-time algorithm used to find the contiguous subarray within a one-dimensional array that has the largest sum.  
It also includes:
- Detailed **performance tracking** (comparisons, array accesses, memory)
- Automated **CSV export** and **benchmark analysis**
- Complete **unit tests** and **report** following peer-review structure

---

## 🧩 Algorithm Description
Kadane’s Algorithm scans the array while maintaining:
- `curSum`: current subarray sum
- `bestSum`: best sum found so far  
At each step, the algorithm decides whether to extend the current subarray or start a new one from the current element.

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

Benchmark results are automatically written to `docs/performance-plots/kadane.csv`.
<img width="812" height="495" alt="image" src="https://github.com/user-attachments/assets/feade41b-4bcd-4225-a570-8bfafccb5c0d" />
<img width="598" height="189" alt="image" src="https://github.com/user-attachments/assets/597b5b50-f4b9-4040-bebc-f925ddb81cc4" />

