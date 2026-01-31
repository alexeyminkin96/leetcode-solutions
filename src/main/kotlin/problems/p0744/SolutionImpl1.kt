package problems.p0744

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.62 MB` (Beats `79.55%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-smallest-letter-greater-than-target/solutions/7540281/kotlin-ologn-0ms-01-by-alexeyminkin-pdwy)
 */
class SolutionImpl1 : Solution {
    override fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var l = 0
        var r = letters.size
        while (l < r) {
            val mid = (l + r) ushr 1
            if (target < letters[mid]) r = mid else l = mid + 1
        }
        return if (l < letters.size) letters[l] else letters[0]
    }
}