package problems.p2011

/**
 * **[Final Value of Variable After Performing Operations](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)**
 *
 * **Description:**
 * - Given an array of operations on a variable `x`, each either incrementing or decrementing it.
 * - Return the final value of `x` after performing all operations, starting from `x = 0`.
 *
 * **Constraints:**
 * - 1 <= operations.length <= 100
 * - Each operation is one of: "X++", "++X", "X--", "--X"
 *
 * **Notes:**
 * - Both prefix and postfix operations have the same effect.
 *
 * **Examples:**
 * - Input: ["--X","X++","X++"]
 * - Output: 1
 * - Explanation: x changes as 0 → -1 → 0 → 1
 */
interface Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int
}
