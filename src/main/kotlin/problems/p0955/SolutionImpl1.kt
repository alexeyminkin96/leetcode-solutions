package problems.p0955

import java.util.LinkedList

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `42.76 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        var curLink = LinkedList<IntArray>()
        curLink.add(IntArray(2) { it * (strs.size - 1) })
        var nextLink = LinkedList<IntArray>()
        outer@ for (c in 0 until strs[0].length) {
            if (curLink.isEmpty()) break
            for (s in curLink) {
                var l = -1
                var r = -1
                for (i in s[0] + 1..s[1]) {
                    if (strs[i][c] < strs[i - 1][c]) {
                        result++
                        nextLink.clear()
                        continue@outer
                    }
                    if (strs[i][c] == strs[i - 1][c]) {
                        if (l == -1)
                            l = i - 1
                        r = i
                    }
                    if ((strs[i][c] > strs[i - 1][c] || i == s[1]) && l != -1) {
                        val lr = IntArray(2)
                        lr[0] = l
                        lr[1] = r
                        nextLink.add(lr)
                        l = -1
                    }
                }
            }
            curLink = nextLink
            nextLink = LinkedList()
        }
        return result
    }
}