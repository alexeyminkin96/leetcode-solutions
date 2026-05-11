package problems.p2553

class SolutionImpl2 : Solution {
    override fun separateDigits(nums: IntArray): IntArray {
        val buf = IntArray(nums.size * 6)
        var idx = buf.size
        for (i in nums.size - 1 downTo 0) {
            var num = nums[i]
            while (num != 0) {
                val div = num / 10
                buf[--idx] = num - div * 10
                num = div
            }
        }
        val res = IntArray(buf.size - idx)

        res.reverse()
        System.arraycopy(buf, idx, res, 0, res.size)
        return res
    }
}