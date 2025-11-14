package problems.p0009

/**
 * **LeetCode Performance:**
 * - Runtime: `5 ms` (Beats `99.08%` of Kotlin submissions)
 * - Memory: `45.48 MB` (Beats `93.25%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(d)` where d = number of digits
 * - Space: `O(1)`
 *
 * **Approach:**
 * - Reject negative numbers and numbers ending with 0 (except 0).
 * - Build reversed half of number.
 * - Stop when reversed part >= remaining part.
 * - Compare halves for even/odd digit count.
 */
class SolutionImpl2 : Solution {
    override fun isPalindrome(x: Int): Boolean {
        if (x < 0 || x % 10 == 0 && x != 0) return false

        var varX = x
        var reverseX = 0

        while (varX > reverseX) {
            reverseX = 10 * reverseX + varX % 10
            varX /= 10
        }

        return varX == reverseX || varX == reverseX / 10
    }
}