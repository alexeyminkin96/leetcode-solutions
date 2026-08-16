package problems.p4021

/**
 * **LeetCode Performance:**
 * - Runtime: `48 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.12 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n²)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-make-a-rotated-palindrome-i/solutions/8465237/kotlin-on2-48ms-on-by-alexeyminkin-z2m7)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(s: String): Int {
        val n = s.length
        val chars = CharArray(n shl 1)
        s.toCharArray(chars)
        s.toCharArray(chars, n)
        var res = Int.MAX_VALUE
        for (i in 0 until n) {
            var sum = i
            var l = i
            var r = l + n - 1
            while (l < r && sum < res) {
                val abs = Math.abs(chars[l++] - chars[r--])
                sum += Math.min(abs, 26 - abs)
            }
            res = Math.min(res, sum)
        }
        return res
    }
}