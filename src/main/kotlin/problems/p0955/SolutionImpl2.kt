package problems.p0955

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.32 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/delete-columns-to-make-sorted-ii/solutions/7428290/kotlin-onm-1ms-on-by-alexeyminkin-rn0k)
 */
class SolutionImpl2 : Solution {
    override fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        var curGaps = IntArray(strs.size + 1)
        var curGapsCount = 1
        curGaps[1] = strs.size - 1

        var nextGaps = IntArray(strs.size + 1)
        var nextGapsCount = 0

        outer@ for (c in 0 until strs[0].length) {
            if (curGapsCount == 0) break
            for (i in 0 until curGapsCount) {
                var isLine = false
                var prevChar = strs[curGaps[2 * i]][c]
                for (s in curGaps[2 * i] + 1..curGaps[2 * i + 1]) {
                    val curChar = strs[s][c]
                    when {
                        curChar < prevChar -> {
                            result++
                            nextGapsCount = 0
                            continue@outer
                        }

                        curChar == prevChar -> {
                            if (!isLine)
                                nextGaps[nextGapsCount++ * 2] = s - 1
                            isLine = true
                            nextGaps[nextGapsCount * 2 - 1] = s
                        }

                        else -> isLine = false
                    }
                    prevChar = curChar
                }
            }

            val buf = curGaps
            curGaps = nextGaps
            nextGaps = buf

            curGapsCount = nextGapsCount
            nextGapsCount = 0
        }
        return result
    }
}