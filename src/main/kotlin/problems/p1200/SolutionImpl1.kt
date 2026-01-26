package problems.p1200

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `26 ms` (Beats `95.52%` of Kotlin submissions)
 * - Memory: `59.88 MB` (Beats `97.01%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minimumAbsDifference(arr: IntArray): Array<IntArray> {
        Arrays.sort(arr)
        var min = Math.abs(arr[1] - arr[0])
        var count = 1
        for (i in 2 until arr.size) {
            val absDiff = arr[i] - arr[i - 1]
            if (absDiff < min) {
                min = absDiff
                count = 0
            }
            if (absDiff == min) count++
        }
        val result = Array(count) { IntArray(2) }
        var j = 0
        for (i in 1 until arr.size) {
            val absDiff = arr[i] - arr[i - 1]
            if (absDiff == min) {
                result[j][0] = arr[i - 1]
                result[j++][1] = arr[i]
            }
        }
        return result
    }
}