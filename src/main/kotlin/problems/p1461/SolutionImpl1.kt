package problems.p1461

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.28 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + 2^k)`
 * - Space: `O(2^k)`
 */
class SolutionImpl1 : Solution {
    override fun hasAllCodes(s: String, k: Int): Boolean {
        val variables = 1 shl k
        if (s.length - k + 1 < variables) return false
        val s = s.toCharArray()
        val isPersists = BooleanArray(variables)
        var num = 0
        val kMask = (variables) - 1
        for (i in 0 until k - 1) {
            num = (num shl 1) or (s[i] - '0')
        }
        for (i in k - 1 until s.size) {
            num = ((num shl 1) or (s[i] - '0')) and kMask
            isPersists[num] = true
        }
        for (isPersist in isPersists) if (!isPersist) return false
        return true
    }
}