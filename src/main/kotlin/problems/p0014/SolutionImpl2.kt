package problems.p0014

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `99.41%` of Kotlin submissions)
 * - Memory: `41.55 MB` (Beats `78.32%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n * m)` where `n` is the number of strings and `m` is the length of the shortest string
 * - Space: `O(m)` for the char array
 *
 * **Approach:**
 * - Step 1: Find the shortest string length
 * - Step 2: Copy that many characters from the first string into a candidate CharArray
 * - Step 3: For each string, update the current valid prefix length `charCount` when mismatch occurs
 * - Step 4: Return substring of the candidate prefix up to `charCount`
 *
 * **Techniques:**
 * - Iterative prefix trimming
 * - Early break inside inner loop to avoid redundant comparisons
 *
 * **Notes:**
 * - This approach maintains current maximum possible prefix and shortens it when mismatches appear
 * - Slightly less intuitive than column-based iteration, but equally correct and optimal
 */
class SolutionImpl2 : Solution {
    override fun longestCommonPrefix(strs: Array<String>): String {
        var strsMinSize = strs[0].length

        for (charIndex in 1 until strs.size)
            if (strs[charIndex].length < strsMinSize) strsMinSize = strs[charIndex].length

        val result = CharArray(strsMinSize) { strs[0][it] }

        var charCount = strsMinSize

        for (strsIndex in 1 until strs.size)
            for (charIndex in 0 until charCount)
                if (strs[strsIndex][charIndex] != result[charIndex]) {
                    charCount = charIndex
                    break
                }

        return String(result, 0, charCount)
    }
}