package problems.p1524

/**
 * **LeetCode Performance**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `84.10 MB`
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/solutions/8613537/kotlin-on-5ms-o1-by-alexeyminkin-nb76)
 */
class SolutionImpl1 : Solution {
    override fun numOfSubarrays(arr: IntArray): Int {
        var res = 0L
        var prevSum = 0L
        for (i in 0 until arr.size) {
            if (arr[i] and 1 == 1) prevSum = i - prevSum + 1
            res += prevSum
            if (res >= 1_000_000_007) res -= 1_000_000_007
        }
        return res.toInt()
    }
}