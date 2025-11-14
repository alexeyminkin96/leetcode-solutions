package problems.p0009

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `99.08%` of Kotlin submissions)
 * - Memory: `45.69 MB` (Beats `81.63%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(d)` where d = number of digits
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Reject negative numbers.
 * - Reverse digits step-by-step, up to 9 iterations.
 * - Stop early if number ends.
 * - For 10 digits check overflow manually.
 * - Compare original with reversed.
 */
class SolutionImpl1 : Solution {
    override fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var varX = x
        var result = 0

        var i = 0

        while (i < 9 && varX != 0) {
            result = 10 * result + varX % 10
            varX /= 10
            i++
        }

        if (varX != 0)
            if (result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && varX % 10 > Int.MAX_VALUE % 10))
                return false
            else
                result = 10 * result + varX % 10

        return x == result
    }
}
