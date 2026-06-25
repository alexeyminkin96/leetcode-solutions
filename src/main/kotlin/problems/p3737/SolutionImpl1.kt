package problems.p3737

class SolutionImpl1 : Solution {
    override fun countMajoritySubarrays(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = IntArray(n + 1)
        for (i in 0 until n)
            dp[i + 1] = dp[i] + if (nums[i] == target) 1 else 0
        var res = 0
        for (r in 1..n)
            for (l in 1..r)
                if (dp[r] - dp[l - 1] > (r - l + 1) shr 1) res++
        return res
    }
}