package problems.p1846

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `61.60 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/solutions/8364049/kotlin-on-4ms-on-by-alexeyminkin-c9yw)
 */
class SolutionImpl2 : Solution {
    override fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        val n = arr.size
        val sort = IntArray(n + 1)
        for (i in 0 until n) sort[Math.min(arr[i], n)]++
        var rem = 0
        for (i in 1..n) rem = Math.max(++rem - sort[i], 0)
        return n - rem
    }
}