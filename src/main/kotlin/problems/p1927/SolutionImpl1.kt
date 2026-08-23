package problems.p1927

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sum-game/solutions/8478992/kotlin-on-6ms-o1-by-alexeyminkin-1sdj)
 */
class SolutionImpl1 : Solution {
    override fun sumGame(num: String): Boolean {
        val num = num.toCharArray()
        var s = 0
        var q = 0
        for (i in 0 until (num.size shr 1))
            if (num[i] == '?') q++ else s += num[i] - '0'
        for (i in (num.size shr 1) until num.size)
            if (num[i] == '?') q-- else s -= num[i] - '0'
        return (q and 1 == 1 || s + (q shr 1) * 9 != 0)
    }
}