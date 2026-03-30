package problems.p2840

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.27 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/solutions/7717595/kotlin-on-5ms-o1-primitives-only-by-alex-08d2)
 */
class SolutionImpl2 : Solution {
    override fun checkStrings(s1: String, s2: String): Boolean {
        val s1 = s1.toCharArray()
        val s2 = s2.toCharArray()
        val countsEven = IntArray(26)
        val countsOdd = IntArray(26)
        for (i in 0 until s1.size) {
            val parity = if (i and 1 == 0) countsEven else countsOdd
            parity[s1[i] - 'a']++
            parity[s2[i] - 'a']--
        }
        for (i in 0 until 26)
            if (countsEven[i] != 0 || countsOdd[i] != 0) return false
        return true
    }
}