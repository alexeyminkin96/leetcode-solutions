package problems.p1526

/**
 * **LeetCode Performance:**
 * - Runtime: `6 ms` (Beats `39.02%` of Kotlin submissions)
 * - Memory: `60.45 MB` (Beats `60.98%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Traverse the array once.
 * - Add all positive drops between consecutive elements.
 * - Add the last element to cover the initial raise.
 *
 * **Techniques:**
 * - Single pass
 * - Difference accumulation
 */
class SolutionImpl1 : Solution {
    override fun minNumberOperations(target: IntArray): Int {
        var result = 0

        for (i in 1 until target.size)
            result += Math.max(target[i - 1] - target[i], 0)

        return result + target[target.size - 1]
    }
}