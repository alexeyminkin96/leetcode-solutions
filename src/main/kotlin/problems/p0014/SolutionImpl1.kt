package problems.p0014

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `99.41%` of Kotlin submissions)
 * - Memory: `41.42 MB` (Beats `82.23%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)` where `n` is the number of strings and `m` is the length of the shortest string
 * - Space: `O(m)` for the char array
 *
 * **Approach:**
 * - Step 1: Find the shortest string length
 * - Step 2: Compare characters column by column across all strings
 * - Step 3: Stop at the first mismatch and return prefix built so far
 * - Step 4: If no mismatch, return entire candidate prefix
 *
 * **Techniques:**
 * - Brute force column-by-column comparison
 * - CharArray to efficiently build prefix
 *
 * **Notes:**
 * - This approach ensures early exit on mismatch
 * - Optimized to avoid unnecessary string copies
 */
class SolutionImpl1 : Solution {
    override fun longestCommonPrefix(strs: Array<String>): String {
        var strsMinSize = strs[0].length

        for (charIndex in 1 until strs.size)
            if (strs[charIndex].length < strsMinSize) strsMinSize = strs[charIndex].length

        val result = CharArray(strsMinSize) { strs[0][it] }

        for (charIndex in 0 until strsMinSize)
            for (strsIndex in 1 until strs.size)
                if (strs[strsIndex][charIndex] != result[charIndex]) return String(result, 0, charIndex)

        return String(result)
    }
}