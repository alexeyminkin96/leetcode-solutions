package problems.p1477

/**
 * **LeetCode Performance**
 * - Runtime: `10 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `59.94 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/solutions/8526145/kotlin-on-10ms-on-by-alexeyminkin-y0c0)
 */
class SolutionImpl1 : Solution {
    override fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val n = arr.size
        val dp = IntArray(n)
        var sum = 0
        var minLen = Int.MAX_VALUE shr 1
        var l = 0
        for (r in 0 until n) {
            sum += arr[r]
            while (sum > target) sum -= arr[l++]
            if (sum == target) minLen = Math.min(minLen, r - l + 1)
            dp[r] = minLen
        }
        var res = Int.MAX_VALUE shr 1
        sum = 0
        minLen = Int.MAX_VALUE shr 1
        var r = n - 1
        for (l in n - 1 downTo 1) {
            sum += arr[l]
            while (sum > target) sum -= arr[r--]
            if (sum == target) minLen = Math.min(minLen, r - l + 1)
            res = Math.min(res, minLen + dp[l - 1])
        }
        return if (res >= Int.MAX_VALUE shr 1) -1 else res
    }
}