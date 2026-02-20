package problems.p0761

/**
 * **LeetCode Performance:**
 * - Runtime: `14 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.25 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    override fun makeLargestSpecial(s: String): String {
        if (s.isEmpty()) return s
        var start = 0
        var count = 0
        val strs = ArrayList<String>()
        for (i in 0..s.length - 1) {
            if (s[i] == '0') count-- else count++
            if (count == 0) {
                strs.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0")
                start = i + 1
            }
        }
        strs.sortDescending()
        return strs.joinToString("")
    }
}