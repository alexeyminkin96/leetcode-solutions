package problems.p1200

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `60.34 MB` (Beats `95.52%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + C)`
 * - Space: `O(n + C)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-absolute-difference/solutions/7525986/kotlin-onc-8ms-onc-by-alexeyminkin-9drn)
 */
class SolutionImpl2 : Solution {
    private val base = 1_000_000
    override fun minimumAbsDifference(arr: IntArray): Array<IntArray> {
        val sort = BooleanArray(2 * base + 1)
        var min = 2 * base
        var max = 0
        for (i in 0 until arr.size) {
            val cur = arr[i] + base
            sort[cur] = true
            if (cur > max) max = cur
            if (cur < min) min = cur
        }
        var prev = min
        var count = 0
        var minDiff = Int.MAX_VALUE
        for (i in min + 1..max) {
            if (!sort[i]) continue
            val diff = i - prev
            if (diff < minDiff) {
                minDiff = diff
                count = 0
            }
            if (diff == minDiff)
                arr[count++] = i - base
            prev = i
        }
        val result = Array(count) { IntArray(2) }
        for (i in 0 until result.size) {
            result[i][0] = arr[i] - minDiff
            result[i][1] = arr[i]
        }
        return result
    }
}