package problems.p0033

class SolutionImpl1 : Solution {
    override fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = (l + r) shr 1
            val midNum = nums[mid]
            if (midNum == target) return mid
            if (nums[l] <= midNum) {
                if (nums[l] <= target && target < midNum) r = mid - 1
                else l = mid + 1
            } else {
                if (midNum < target && target <= nums[r]) l = mid + 1
                else r = mid - 1
            }
        }
        return -1
    }
}