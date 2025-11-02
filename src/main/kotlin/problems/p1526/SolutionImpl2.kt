package problems.p1526

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `94.32%` of Kotlin submissions)
 * - Memory: `60.58 MB` (Beats `58.33%` of Kotlin submissions)
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
 *
 * **Notes:**
 * - Same logic as SolutionImpl1, but slightly faster due to explicit diff reuse.
 */
class SolutionImpl2 : Solution {
    override fun minNumberOperations(target: IntArray): Int {
        var result = 0

        var diff = 0

        for (i in 1 until target.size) {
            diff = target[i - 1] - target[i]
            if (diff > 0)
                result += diff
        }

        return result + target[target.size - 1]
    }
}