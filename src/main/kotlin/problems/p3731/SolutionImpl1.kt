package problems.p3731

class SolutionImpl1 : Solution {
    override fun findMissingElements(nums: IntArray): IntArray {
        val sort = BooleanArray(101)
        for (num in nums) sort[num] = true
        var r = 100
        while (!sort[r]) r--
        var l = 0
        while (!sort[l]) l++
        val res = IntArray(r - l + 1 - nums.size)
        var i = 0
        while (++l < r) if (!sort[l]) res[i++] = l
        return res
    }
}