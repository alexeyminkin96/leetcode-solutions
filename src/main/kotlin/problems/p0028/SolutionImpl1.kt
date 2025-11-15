package problems.p0028

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `40.88 MB` (Beats `77.07%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Try each index in haystack
 * - Compare needle chars
 * - Stop on mismatch
 *
 * **Techniques:**
 * - Brute force check
 */
class SolutionImpl1 : Solution {
    override fun strStr(haystack: String, needle: String): Int {
        for (i in 0..haystack.length - needle.length) {
            var isValid = true
            for (j in 0 until needle.length) {
                if (haystack[i + j] != needle[j]) {
                    isValid = false
                    break
                }
            }
            if (isValid) return i
        }

        return -1
    }
}