package problems.p3518

/**
 * **LeetCode Performance:**
 * - Runtime: `13 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `47.87 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*С^2*log(k))`, C=26
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/solutions/8428138/kotlin-onc2-13ms-o1-by-alexeyminkin-51m4)
 */
class SolutionImpl1 : Solution {
    override fun smallestPalindrome(s: String, k: Int): String {
        val s = s.toCharArray()
        val n = s.size
        if (n == 1 && k > 1) return ""
        val half = n shr 1
        val charCount = IntArray(26)
        for (i in 0 until half) charCount[s[i] - 'a']++
        var k = k.toLong()
        fun perm(places: Int, same: Int): Long {
            val same = Math.min(same, places - same)
            var count = 1L
            var i = 1
            while (i <= same && count <= k)
                count = count * (places + 1 - i) / i++
            return count
        }
        outer@ for (i in 0 until half) {
            for (cur in 0 until 26) {
                if (charCount[cur] == 0) continue
                charCount[cur]--
                s[i] = 'a' + cur
                s[n - 1 - i] = 'a' + cur
                var perms = 1L
                var places = half - 1 - i
                for (other in 0 until 26) {
                    perms *= perm(places, charCount[other])
                    places -= charCount[other]
                    if (perms >= k) continue@outer
                }
                k -= perms
                charCount[cur]++
            }
            return ""
        }
        return String(s)
    }
}