# LeetCode Solutions in Kotlin

![Language](https://img.shields.io/badge/language-Kotlin-blue.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)

A collection of my solutions to [LeetCode](https://leetcode.com/problemset) problems, written in **Kotlin**.  

The purpose of this repository is:
- To practice algorithms and data structures
- To track my progress over time
- To compare different solution approaches (brute force vs. optimized)
- To help others who are trying to understand algorithmic problems by providing clean and well-documented examples
- **To achieve the best possible performance in LeetCode test runs, even if it comes at the cost of code readability**

---

## 📂 Project Structure

Source code is organized under `src/main/kotlin/problems`, one folder per problem:

```
src/
 └── main/
     └── kotlin/
         └── problems/
             ├── p0001/
             │   ├── Solution.kt
             │   ├── SolutionImpl1.kt
             │   └── SolutionImpl2.kt
             ├── p0002/
             │   ├── Solution.kt
             │   └── SolutionImpl1.kt
             └── ...
```

Each folder contains:
- `Solution.kt` — interface with problem statement, constraints, and examples
- `SolutionImplX.kt` — one or more implementations with documented approach, complexity, and used techniques

---

## 📝 Documentation style

Instead of inline examples, see the package [p0000](src/main/kotlin/problems/p0000) which contains:
1. template [Solution.kt](src/main/kotlin/problems/p0000/Solution.kt): problem description, constraints, examples
2. template [SolutionImplX.kt](src/main/kotlin/problems/p0000/SolutionImplX.kt): approach, complexity, techniques.

---

## 📂 Navigation

See [NAVIGATION.md](NAVIGATION.md) for the full list of solved problems,  
with links to implementations and performance metrics.

---

## 🚀 Usage

You can run the solutions using your favorite Kotlin environment or IDE (e.g., IntelliJ IDEA).  
Tests and benchmarks can be added later for validation and performance comparison.

---

## 📄 License

This repository is licensed under the [MIT License](LICENSE).
