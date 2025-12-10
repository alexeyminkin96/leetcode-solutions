package problems.p3577

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `67.73 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * - [Full explanation](https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations/solutions/7404289/kotlin-on-2ms-o1-by-alexeyminkin-cxsr)
 */class SolutionImpl1 : Solution {
    override fun countPermutations(complexity: IntArray): Int {
        val mod = 1_000_000_007
        var result = 1L
        for (i in 1 until complexity.size) {
            if (complexity[0] >= complexity[i]) return 0
            result *= i
            if (result >= mod) result %= mod
        }
        return result.toInt()
    }
}