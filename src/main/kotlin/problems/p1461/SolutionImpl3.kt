package problems.p1461

/**
 * **LeetCode Performance:**
 * - Runtime: `7 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.42 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(2^k)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/solutions/7602138/kotlin-on-7ms-o2k-no-hashset-no-booleana-4zq0)
 */
class SolutionImpl3 : Solution {
    private val bitShift = 5
    private val remMask = (1 shl bitShift) - 1
    override fun hasAllCodes(s: String, k: Int): Boolean {
        var variables = 1 shl k
        var remVars = s.length - k + 1
        if (remVars < variables) return false
        val s = s.toCharArray()
        var num = 0
        for (i in 0 until k - 1) {
            num = (num shl 1) or (s[i].code and 1)
        }
        val isPersists = IntArray((variables + remMask) ushr bitShift)
        val kMask = variables - 1
        for (i in k - 1 until s.size) {
            num = ((num shl 1) or (s[i].code and 1)) and kMask
            val quot = num ushr bitShift
            val rem = num and remMask
            val flag = 1 shl rem
            remVars--
            if (isPersists[quot] and flag == 0) {
                isPersists[quot] = isPersists[quot] or flag
                if (--variables == 0) return true
            } else if (remVars < variables) return false
        }
        return false
    }
}