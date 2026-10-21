package problems.p3863

/**
 * **LeetCode Performance:**
 * - Runtime: `12 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `72.63 MB` (Beats `-%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-operations-to-sort-a-string/solutions/8582154/kotlin-on-12ms-o1-by-alexeyminkin-1lpp)
 */
class SolutionImpl1 : Solution {
    override fun minOperations(s: String): Int {
        val n = s.length
        val s = s.toCharArray()
        val counts = IntArray(26)
        var prev = 'a'
        var isNonDecr = true
        for (c in s) {
            counts[c - 'a']++
            if (c < prev) isNonDecr = false
            prev = c
        }
        if (isNonDecr) return 0
        if (n == 2) return -1
        var min = 0
        while (counts[min] == 0) min++
        var max = 25
        while (counts[max] == 0) max--
        if (s[0] == 'a' + min || s[n - 1] == 'a' + max) return 1
        if (s[0] == 'a' + max && s[n - 1] == 'a' + min && counts[max] == 1 && counts[min] == 1) return 3
        return 2
    }
}