package problems.p1871

/**
 * **LeetCode Performance:**
 * - Runtime: `11 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.80 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-vii/solutions/8292759/kotlin-on-11ms-on-by-alexeyminkin-gftv)
 */
class SolutionImpl2 : Solution {
    override fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
        val n = s.length
        if (s[n - 1] != '0') return false
        val s = s.toCharArray()
        s[0]--
        var last = 0
        for (i in 0 until n) {
            if (s[i] != '/') continue
            for (j in Math.max(i + minJump, last + 1)..Math.min(i + maxJump, n - 1))
                if (s[j] == '0') s[j]--
            last = Math.min(i + maxJump, n - 1)
        }
        return s[n - 1] == '/'
    }
}
