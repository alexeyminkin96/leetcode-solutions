package problems.p2011

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `27.78%`)
 * - Memory: `43.81 MB` (Beats `55.56%`)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Use a `HashMap` to map '+' and '-' to their respective values.
 * - Iterate over operations and accumulate the result based on the middle char.
 *
 * **Techniques:**
 * - HashMap
 * - Iteration
 */
class SolutionImpl1 : Solution {
    override fun finalValueAfterOperations(operations: Array<String>): Int {
        val operationMap = HashMap<Char, Int>(2)
        operationMap['-'] = -1
        operationMap['+'] = 1

        var x = 0
        for (i in 0 until operations.size)
            x += operationMap[operations[i][1]]!!
        return x
    }
}