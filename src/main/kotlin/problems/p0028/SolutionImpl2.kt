package problems.p0028

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `84.47%` of Kotlin submissions)
 * - Memory: `40.75 MB` (Beats `82.58%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Compare only if first char matches
 * - Search next possible start inside loop
 * - Jump to saved index on mismatch
 *
 * **Techniques:**
 * - Manual skip
 */
class SolutionImpl2 : Solution {
    override fun strStr(haystack: String, needle: String): Int {
        var i = 0
        while (i <= haystack.length - needle.length) {
            if (haystack[i] == needle[0]) {
                var isValid = true
                var findNext = false
                var next = i
                for (j in 1 until needle.length) {
                    if (!findNext)
                        findNext = haystack[++next] == needle[0]

                    if (haystack[i + j] != needle[j]) {
                        isValid = false
                        break
                    }
                }
                if (isValid) return i
                i = next
            } else
                i++
        }

        return -1
    }
}