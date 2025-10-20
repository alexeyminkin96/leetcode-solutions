package problems.p2011

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%`)
 * - Memory: `44.01 MB` (Beats `37.04%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Loop through operations.
 * - Check if middle char is '-', add -1, else +1.
 *
 * **Techniques:**
 * - Iteration
 */
class SolutionImpl2 : Solution {
    override fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0
        for (i in 0 until operations.size)
            x += if (operations[i][1] == '-') -1 else 1
        return x
    }
}