package problems.p3474

/**
 * **LeetCode Performance:**
 * - Runtime: `19 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `46.68 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(n + m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/lexicographically-smallest-generated-string/solutions/7731214/kotlin-onm-19ms-onm-by-alexeyminkin-4w0q)
 */
class SolutionImpl1 : Solution {
    override fun generateString(str1: String, str2: String): String {
        val n = str1.length
        val m = str2.length
        val ar = CharArray(n + m - 1)
        val nul = ar[0]
        for (i in 0 until n) {
            if (str1[i] != 'T') continue
            for (j in 0 until m)
                if (ar[j + i] == nul) ar[j + i] = str2[j]
                else if (ar[j + i] != str2[j]) return ""
        }
        outer@ for (i in 0 until n) {
            if (str1[i] != 'F') continue
            var lastNul = -1
            for (j in 0 until m) {
                if (ar[j + i] != nul && ar[j + i] != str2[j]) continue@outer
                if (ar[j + i] == nul)
                    if (str2[j] != 'a') continue@outer
                    else lastNul = j + i
            }
            if (lastNul == -1) return "" else ar[lastNul] = 'b'
        }
        for (i in 0 until ar.size)
            if (ar[i] == nul) ar[i] = 'a'
        return String(ar)
    }
}
