package problems.p1520

import java.util.Arrays

/**
 * **LeetCode Performance**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.61 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/solutions/8527878/kotlin-on-8ms-o1-by-alexeyminkin-25w8)
 */
class SolutionImpl3 : Solution {
    override fun maxNumOfSubstrings(s: String): List<String> {
        val n = s.length
        val s = s.toCharArray()
        val leftMost = IntArray(26) { -1 }
        val rightMost = IntArray(26)
        for (i in 0 until n) rightMost[s[i] - 'a'] = i
        for (i in n - 1 downTo 0) leftMost[s[i] - 'a'] = i
        val strs = LongArray(26)
        var strsIdx = 0
        outer@ for (code in 0 until 26) {
            val left = leftMost[code]
            if (left == -1) continue
            var right = rightMost[code]
            var i = left
            while (i < right)
                if (leftMost[s[i] - 'a'] < left) continue@outer
                else right = Math.max(right, rightMost[s[i++] - 'a'])
            strs[strsIdx++] = (right.toLong() shl 32) or left.toLong()
        }
        Arrays.sort(strs, 0, strsIdx)
        val res = mutableListOf<String>()
        var prevR = -1
        for (i in 0 until strsIdx) {
            val l = strs[i].toInt()
            val r = (strs[i] shr 32).toInt()
            if (l > prevR) {
                res.add(String(s, l, r - l + 1))
                prevR = r
            }
        }
        return res
    }
}