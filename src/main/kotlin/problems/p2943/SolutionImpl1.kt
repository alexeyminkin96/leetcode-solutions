package problems.p2943

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.28 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(h log h + v log v)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/solutions/7496187/kotlin-ohloghvlogv-3ms-o1-by-alexeyminki-ccum)
 */
class SolutionImpl1 : Solution {
    override fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
        val maxH = maxContinuous(hBars)
        val maxV = maxContinuous(vBars)
        val side = Math.min(maxH, maxV) + 1
        return side * side
    }

    private fun maxContinuous(ar: IntArray): Int {
        Arrays.sort(ar)
        var max = 1
        var continuous = 1
        for (i in 1 until ar.size) {
            if (ar[i - 1] + 1 == ar[i]) {
                if (++continuous > max) max = continuous
            } else continuous = 1
        }
        return max
    }
}