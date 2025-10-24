package problems.p0003

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `94.01%` of Kotlin submissions)
 * - Memory: `44.94 MB` (Beats `90.74%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Approach:**
 * - Use sliding window and hash map.
 * - Move left pointer after duplicates.
 * - Update max window length on each iteration.
 *
 * **Techniques:**
 * - HashMap
 * - Sliding Window
 * - Two Pointers
 */
class SolutionImpl1 : Solution {
    override fun lengthOfLongestSubstring(s: String): Int {
        val charToIndexMap = HashMap<Char, Int>()
        var maxWindowSize = 0
        var currentWindowFirstIndex = 0

        s
            .forEachIndexed { index, char ->
                val currentCharPreviousIndex = charToIndexMap[char]
                charToIndexMap[char] = index

                if (currentCharPreviousIndex != null
                    && currentCharPreviousIndex >= currentWindowFirstIndex
                )
                    currentWindowFirstIndex = currentCharPreviousIndex + 1
                else if (index - currentWindowFirstIndex + 1 > maxWindowSize) {
                    maxWindowSize = index - currentWindowFirstIndex + 1
                }
            }

        return maxWindowSize
    }
}