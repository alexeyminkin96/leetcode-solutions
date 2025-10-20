package problems.p2011

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%`)
 * - Memory: `44.60 MB` (Beats `25.93%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use `sumOf` to compute the sum of all increments/decrements.
 *
 * **Techniques:**
 * - Functional style
 * - sumOf with inline lambda
 *
 * **Notes:**
 * - Kotlin one-line
 */
class SolutionImpl3 : Solution {
    override fun finalValueAfterOperations(operations: Array<String>): Int {
        return operations.sumOf { if (it[1] == '-') -1 as Int else 1 }
    }
}