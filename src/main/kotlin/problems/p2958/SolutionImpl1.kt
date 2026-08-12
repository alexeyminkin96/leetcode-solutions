package problems.p2958

class SolutionImpl1 : Solution {
    override fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        val counts = HashMap<Int, Int>(n)
        var l = 0
        var r = 0
        var hasMoreK = false
        var res = 0
        while (r < n) {
            if (!hasMoreK) {
                val num = nums[r++]
                val count = (counts[num] ?: 0) + 1
                counts[num] = count
                if (count > k) hasMoreK = true
            } else {
                val num = nums[l++]
                val count = counts[num]!! - 1
                counts[num] = count
                if (count == k) hasMoreK = false
            }
            if (!hasMoreK) res = Math.max(res, r - l)
        }
        return res
    }
}