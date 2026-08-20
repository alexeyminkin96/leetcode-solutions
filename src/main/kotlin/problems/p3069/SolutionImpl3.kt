package problems.p3069

class SolutionImpl3 : Solution {
    override fun resultArray(nums: IntArray): IntArray {
        val n = nums.size
        var arr1I = 1
        var lastArr1 = nums[0]
        var lastArr2 = nums[1]
        for (i in 2 until n)
            if (lastArr1 > lastArr2) {
                lastArr1 = nums[i]
                System.arraycopy(nums, arr1I, nums, arr1I + 1, i - arr1I)
                nums[arr1I++] = lastArr1
            } else lastArr2 = nums[i]
        return nums
    }
}