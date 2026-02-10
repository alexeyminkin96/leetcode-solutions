package problems.p3719

class SolutionImpl1 : Solution {
    override fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        for (i in 0 until n) {
            val counts = IntArray(100_001)
            var evens = 0
            var odds = 0
            for (j in i until n) {
                if (counts[nums[j]]++ == 0) {
                    if (nums[j] % 2 == 0) evens++
                    else odds++
                }
                if (evens == odds) result = maxOf(result, j - i + 1)
            }
        }
        return result
    }
}