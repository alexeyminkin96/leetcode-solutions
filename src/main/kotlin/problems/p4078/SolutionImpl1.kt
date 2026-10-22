package problems.p4078

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `87.80%` of Kotlin submissions)
 * - Memory: `43.04 MB` (Beats `34.15%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/three-fibonacci-sum/solutions/8583844/kotlin-ologn-1ms-o1-by-alexeyminkin-16l6)
 */
class SolutionImpl1 : Solution {
    override fun threeFibonacciSum(n: Int): Boolean {
        if (n and 1 == 1) return false
        val target = n shr 1
        var f1 = 0
        var f2 = 1
        while (f2 < target) {
            val next = f1 + f2
            f1 = f2
            f2 = next
        }
        return f2 == target
    }
}