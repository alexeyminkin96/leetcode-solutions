package problems.p3075

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `567 ms` (Beats `50.00%` of Kotlin submissions)
 * - Memory: `84.85 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximize-happiness-of-selected-children/solutions/7437627/kotlin-onlogn-567ms-o1-by-alexeyminkin-unf0)
 */
class SolutionImpl1 : Solution {
    override fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        var result = 0L
        Arrays.sort(happiness)
        var ind = happiness.size - 1
        for (i in 0 until k) {
            if (happiness[ind] - i <= 0) break
            result += happiness[ind--] - i
        }
        return result
    }
}