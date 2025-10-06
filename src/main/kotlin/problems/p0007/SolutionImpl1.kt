package problems.p0007

/**
 * **LeetCode Performance:**
 * - Runtime: `80 ms` (Beats `98.38%`)
 * - Memory: `40.23 MB` (Beats `59.11%`)
 *
 * **Complexity:**
 * - Time: O(log(n)) — iterate over digits
 * - Space: O(1)
 *
 * **Approach:**
 * - Rebuild reversed number digit by digit using modulo/division
 * - Check overflow before multiplying by 10 and adding next digit
 * - Early exit when x becomes 0
 *
 * **Techniques:**
 * - Integer arithmetic only
 * - Modulo / division
 * - Overflow check
 *
 * **Notes:**
 * - Solved **without using Long (Int64) or String conversions**
 * - Handles edge cases with overflow safely
 */
class SolutionImpl1 : Solution {
    override fun reverse(x: Int): Int {
        var varX = x
        var result = 0

        for (i in 0 until 9) {
            result = 10 * result + varX % 10
            varX /= 10
            if (varX == 0) return result
        }

        if (result > Int.MAX_VALUE / 10
            || result < Int.MIN_VALUE / 10
            || (result == Int.MAX_VALUE / 10 && varX % 10 > Int.MAX_VALUE % 10)
            || (result == Int.MIN_VALUE / 10 && varX % 10 < Int.MIN_VALUE % 10)
        )
            return 0
        else
            return 10 * result + varX % 10
    }
}