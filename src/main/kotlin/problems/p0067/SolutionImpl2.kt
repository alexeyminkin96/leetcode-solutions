package problems.p0067

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.75 MB` (Beats `96.12%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/add-binary/solutions/7580607/kotlin-on-1ms-o1-by-alexeyminkin-n8tv)
 */
class SolutionImpl2 : Solution {
    override fun addBinary(a: String, b: String): String {
        val res = CharArray(Math.max(a.length, b.length) + 1)
        var plus = 0
        var aIndex = a.length - 1
        var bIndex = b.length - 1
        for (i in res.size - 1 downTo 0) {
            if (aIndex >= 0) plus += a[aIndex--] - '0'
            if (bIndex >= 0) plus += b[bIndex--] - '0'
            res[i] = '0' + (plus and 1)
            plus = plus ushr 1
        }
        val offset = '1' - res[0]
        return String(res, offset, res.size - offset)
    }
}