package problems.p3074

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.03 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + m log m)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        var appleCount = 0
        for (i in 0 until apple.size) {
            appleCount += apple[i]
        }
        Arrays.sort(capacity)
        var boxIndex = capacity.size - 1
        while (appleCount > 0) {
            appleCount -= capacity[boxIndex--]
        }
        return capacity.size - boxIndex - 1
    }
}