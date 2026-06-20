package problems.p1840

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `65 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `115.67 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m log m)`
 * - Space: `O(1)` extra, excluding sorting internals
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/maximum-building-height/solutions/8347881/kotlin-om-logm-65ms-o1-by-alexeyminkin-ttz7)
 */
class SolutionImpl1 : Solution {
    override fun maxBuilding(n: Int, restrictions: Array<IntArray>): Int {
        if (restrictions.size == 0) return n - 1
        Arrays.sort(restrictions, compareBy { it[0] })
        var curId = n
        var curH = n - 1
        for (i in restrictions.size - 1 downTo 0) {
            val nextId = restrictions[i][0]
            curH = Math.min(curH + (curId - nextId), restrictions[i][1])
            restrictions[i][1] = curH
            curId = nextId
        }
        curId = 1
        curH = 0
        var maxH = 0
        for (i in 0 until restrictions.size) {
            val nextId = restrictions[i][0]
            val h = curH + (nextId - curId)
            val nextH = Math.min(h, restrictions[i][1])
            maxH = Math.max(maxH, (h + nextH) shr 1)
            curId = nextId
            curH = nextH
        }
        maxH = Math.max(maxH, curH + (n - curId))
        return maxH
    }
}