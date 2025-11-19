package problems.p1513

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `68.39%` of Kotlin submissions)
 * - Memory: `46.13 MB` (Beats `14.84%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Scan string
 * - Count length of 1-block
 * - Add block sum with modulo
 *
 * **Techniques:**
 * - One pass
 * - Running counter
 */
class SolutionImpl1 : Solution {
    override fun numSub(s: String): Int {
        var gCount = 0
        var localCount = 0
        var onesCount = 0
        for (i in 0 until s.length) {
            if (s[i] == '0') {
                gCount += localCount
                if (gCount >= 1_000_000_007)
                    gCount -= 1_000_000_007
                localCount = 0
                onesCount = 0
            } else {
                localCount += ++onesCount
                if (localCount >= 1_000_000_007)
                    localCount -= 1_000_000_007
            }
        }
        return (gCount + localCount) % 1_000_000_007
    }
}