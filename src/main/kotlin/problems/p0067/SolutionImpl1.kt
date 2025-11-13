package problems.p0067

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `98.19%` of Kotlin submissions)
 * - Memory: `41.95 MB` (Beats `91.99%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Make result array with +1 slot for carry
 * - Align indices using gap values
 * - Add bits and carry
 * - Put result bit into array
 * - Write carry if needed
 *
 * **Techniques:**
 * - CharArray
 * - Manual index mapping
 */
class SolutionImpl1 : Solution {
    override fun addBinary(a: String, b: String): String {
        val res = CharArray(Math.max(a.length, b.length) + 1)
        val aGap = res.size - a.length
        val bGap = res.size - b.length

        var plus = 0
        for (i in res.size - 1 downTo 1) {
            val sum = (if (i - aGap >= 0 && a[i - aGap] == '1') 1 else 0) +
                (if (i - bGap >= 0 && b[i - bGap] == '1') 1 else 0) +
                plus
            res[i] = if (sum % 2 == 1) '1' else '0'
            plus = sum / 2
        }
        if (plus == 1) res[0] = '1'
        return String(res, 1 - plus, res.size - 1 + plus)
    }
}