package problems.p1358

/**
 * **LeetCode Performance:**
 * - Runtime: `9 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `44.86 MB` (Beats `72.22%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/solutions/8367537/kotlin-on-9ms-o1-by-alexeyminkin-bwts)
 */
class SolutionImpl3 : Solution {
    override fun numberOfSubstrings(s: String): Int {
        val n = s.length
        val s = s.toCharArray()
        var a = -1
        var b = -1
        var c = -1
        var res = 0
        for (i in 0 until n) {
            when (s[i]) {
                'a' -> a = i
                'b' -> b = i
                'c' -> c = i
            }
            res += minOf(a, b, c) + 1
        }
        return res
    }
}