package problems.p3364

import java.util.TreeMap

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `42.86%` of Kotlin submissions)
 * - Memory: `51.72 MB` (Beats `14.29%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * log(r - l))`
 * - Space: `O(r - l)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-positive-sum-subarray/solutions/8612475/kotlin-onlogr-l-21ms-or-l-by-alexeyminki-rs00)
 */
class SolutionImpl2 : Solution {
    override fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val n = nums.size
        var res = Int.MAX_VALUE
        val tree = TreeMap<Int, Int>()
        var iPS = 0
        var lPS = 0
        var rPS = 0
        for (i in -r..n - l) {
            if (i >= 0) {
                val higher = tree.higherKey(iPS)
                if (higher != null)
                    res = Math.min(res, higher - iPS)
                iPS += nums[i]
            }

            if (i + l > 0) {
                lPS += nums[i + l - 1]
                tree.compute(lPS) { _, v -> if (v == 1) null else v!! - 1 }
            }

            if (i + r < n) {
                rPS += nums[i + r]
                tree.compute(rPS) { _, v -> (v ?: 0) + 1 }
            }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}