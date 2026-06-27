package problems.p3020

/**
 * **LeetCode Performance:**
 * - Runtime: `32 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `70.44 MB` (Beats `78.45%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/solutions/8362051/kotlin-onloglogm-32ms-on-by-alexeyminkin-nqq6)
 */
class SolutionImpl2 : Solution {
    override fun maximumLength(nums: IntArray): Int {
        val max = 31_623
        var ones = 0
        val lessMax = IntArray(max)
        val moreMax = HashSet<Int>(nums.size)
        for (n in nums)
            if (n == 1) ones++
            else if (n < max) lessMax[n]++
            else moreMax.add(n)
        ones -= (ones + 1) and 1
        if (ones >= 9) return ones
        var res = ones
        for (n in nums) {
            var chain = 0
            var next = n
            while (next < max && lessMax[next] >= 2) {
                next *= next
                chain += 2
            }
            if (next < max && lessMax[next] == 1 || next >= max && moreMax.contains(next)) chain++ else chain--
            res = Math.max(res, chain)
        }
        return res
    }
}