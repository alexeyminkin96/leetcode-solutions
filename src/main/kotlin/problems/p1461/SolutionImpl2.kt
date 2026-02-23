package problems.p1461

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.95 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(2^k)`
 */
class SolutionImpl2 : Solution {
    override fun hasAllCodes(s: String, k: Int): Boolean {
        var variables = 1 shl k
        if (s.length - k + 1 < variables) return false
        val s = s.toCharArray()
        val isPersists = BooleanArray(variables)
        var num = 0
        val kMask = variables - 1
        for (i in 0 until k - 1) {
            num = (num shl 1) or (s[i].code and 1)
        }
        for (i in k - 1 until s.size) {
            num = ((num shl 1) or (s[i].code and 1)) and kMask
            if (!isPersists[num]) {
                isPersists[num] = true
                if (--variables == 0) return true
            } else if (s.size - i - 1 < variables) return false
        }
        return false
    }
}
