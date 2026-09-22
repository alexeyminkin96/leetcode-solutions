package problems.p3525

class SolutionImpl1 : Solution {
    override fun resultArray(nums: IntArray, k: Int, queries: Array<IntArray>): IntArray {
        val n = nums.size
        val res = IntArray(queries.size)
        for (qI in 0 until queries.size) {
            val query = queries[qI]
            nums[query[0]] = query[1]
            val x = query[3].toLong()
            var mul = 1L
            var count = 0
            for (nI in query[2] until n) {
                mul = (mul * nums[nI]) % k
                if (mul == x) count++
            }
            res[qI] = count
        }
        return res
    }
}