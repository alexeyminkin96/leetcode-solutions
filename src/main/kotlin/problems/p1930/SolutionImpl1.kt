package problems.p1930

/**
 * **LeetCode Performance:**
 * - Runtime: `Time Limit Exceeded`
 * - Memory: `Time Limit Exceeded`
 *
 * **Complexity:**
 * - Time: `O(n^2)`
 * - Space: `O(k)`
 *
 * **Approach:**
 * - Try all left and right
 * - Collect middle chars in set
 *
 * **Notes:**
 * - So slow...
 */
class SolutionImpl1 : Solution {
    override fun countPalindromicSubsequence(s: String): Int {
        val set = mutableSetOf<String>()

        val charArray = s.toCharArray()
        for (l in 0 until charArray.size - 2) {
            var isFoundRight = false
            for (r in charArray.size - 1 downTo l + 1) {
                if (!isFoundRight)
                    isFoundRight = charArray[l] == charArray[r]
                else
                    set.add("${charArray[l]}${charArray[r]}")
            }
        }

        return set.size
    }
}