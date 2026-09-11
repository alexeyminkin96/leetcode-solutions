package problems.p3483

/**
 * **LeetCode Performance:**
 * - Runtime: `2 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `41.82 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/unique-3-digit-even-numbers/solutions/8515489/kotlin-onc-2ms-o1-by-alexeyminkin-l4yq)
 */
class SolutionImpl1 : Solution {
    override fun totalNumbers(digits: IntArray): Int {
        val digs = IntArray(10)
        for (d in digits) digs[d]++
        var res = 0
        for (i1 in 1..9) {
            if (digs[i1]-- > 0)
                for (i2 in 0..9) {
                    if (digs[i2]-- > 0)
                        for (i3 in 0..8 step 2)
                            if (digs[i3] > 0) res++
                    digs[i2]++
                }
            digs[i1]++
        }
        return res
    }
}