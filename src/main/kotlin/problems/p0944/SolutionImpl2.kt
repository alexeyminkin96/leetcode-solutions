package problems.p0944

/**
 * **LeetCode Performance:**
 * - Runtime: `8 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.59 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/delete-columns-to-make-sorted/solutions/7426115/kotlin-onm-8ms-om-minimal-time-i-can-rea-qdci)
 */
class SolutionImpl2 : Solution {
    override fun minDeletionSize(strs: Array<String>): Int {
        var result = 0
        val codes = IntArray(strs[0].length)
        var prevStr = strs[0].toCharArray()
        for (i in 1 until strs.size) {
            val curStr = strs[i].toCharArray()
            for (c in 0 until codes.size) {
                if (codes[c] != -1 && curStr[c] < prevStr[c]) {
                    codes[c] = -1
                    result++
                }
            }
            if (result == codes.size) return result
            prevStr = curStr
        }
        return result
    }
}