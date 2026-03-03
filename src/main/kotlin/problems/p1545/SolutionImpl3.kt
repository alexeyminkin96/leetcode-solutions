package problems.p1545

/**
 * **LeetCode Performance:**
 * - Runtime: `0 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `39.86 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(log k)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/solutions/7622514/kotlin-ologk-0ms-o1-not-recursion-by-ale-sj5h)
 */
class SolutionImpl3 : Solution {
    override fun findKthBit(n: Int, k: Int): Char {
        var varK = k
        var count = 0
        while (varK > 1) {
            if (varK and (varK - 1) == 0) return '1' - (count and 1)
            varK = (Integer.highestOneBit(varK) shl 1) - varK
            count++
        }
        return '0' + (count and 1)
    }
}