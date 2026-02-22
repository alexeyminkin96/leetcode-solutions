package problems.p0868

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.26 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 */
class SolutionImpl1 : Solution {
    override fun binaryGap(n: Int): Int {
        var n = n
        var result = 0
        var start = -1
        for (i in 0 until 32) {
            if (n and 1 == 1) {
                if (start != -1)
                    result = Math.max(result, i - start)
                start = i
            }
            n = n ushr 1
        }
        return result
    }
}