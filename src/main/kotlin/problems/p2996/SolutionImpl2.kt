package problems.p2996

class SolutionImpl2 : Solution {
    override fun missingInteger(nums: IntArray): Int {
        val n = nums.size
        var sum = nums[0]
        var i = 1
        while (i < n && nums[i] == nums[i - 1] + 1) sum += nums[i++]
        if (i == 1) sum++
        if (sum > 50) return sum
        val present = BooleanArray(52)
        while (i < n) present[nums[i++]] = true
        while (present[sum]) sum++
        return sum
    }
}