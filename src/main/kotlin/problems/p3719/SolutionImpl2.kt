package problems.p3719

class SolutionImpl2 : Solution {
    override fun longestBalanced(nums: IntArray): Int {
        val n = nums.size
        var result = 0
        val counts = IntArray(100_001)
        val evenOdd = IntArray(2)
        for (i in 0 until n step 2) {
            for (j in i until n) {
                if (counts[nums[j]]++ == 0)
                    evenOdd[nums[j] and 1]++
                if (evenOdd[0] == evenOdd[1]) result = maxOf(result, j - i + 1)
            }

            if (--counts[nums[i]] == 0) {
                evenOdd[nums[i] and 1]--
                if (evenOdd[0] == evenOdd[1]) result = maxOf(result, n - (i + 1))
            }

            for (j in n - 1 downTo i + 1) {
                if (--counts[nums[j]] == 0) {
                    evenOdd[nums[j] and 1]--
                    if (evenOdd[0] == evenOdd[1]) result = maxOf(result, j - (i + 1))
                }
            }
        }
        return result
    }
}