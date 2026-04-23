package problems.p2615

class SolutionImpl2 : Solution {
    override fun distance(nums: IntArray): LongArray {
        val bits = 17
        val mask = (1L shl bits) - 1
        val n = nums.size
        val res = LongArray(n)
        val numToSC = HashMap<Int, Long>()
        fun dist(i: Int, num: Int) {
            val sc = numToSC[num] ?: 0
            res[i] += Math.abs((sc shr bits) - i * (sc and mask))
            numToSC[num] = sc + (i.toLong() shl bits) + 1
        }
        for (i in 0 until n) {
            dist(i, nums[i])
            dist(n - 1 - i, -nums[n - 1 - i] - 1)
        }
        return res
    }
}