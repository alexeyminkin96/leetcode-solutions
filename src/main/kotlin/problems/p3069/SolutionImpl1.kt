package problems.p3069

class SolutionImpl1 : Solution {
    override fun resultArray(nums: IntArray): IntArray {
        val n = nums.size
        val arr1 = IntArray(n)
        var arr1I = 0
        arr1[arr1I] = nums[0]
        val arr2 = IntArray(n)
        var arr2I = 0
        arr2[arr2I] = nums[1]
        for (i in 2 until n)
            if (arr1[arr1I] > arr2[arr2I]) arr1[++arr1I] = nums[i] else arr2[++arr2I] = nums[i]
        System.arraycopy(arr2, 0, arr1, arr1I + 1, arr2I + 1)
        return arr1
    }
}