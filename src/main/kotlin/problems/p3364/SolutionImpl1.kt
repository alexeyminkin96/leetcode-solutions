package problems.p3364

import java.util.TreeMap

class SolutionImpl1 : Solution {
    override fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val n = nums.size
        val ps = IntArray(n + 1)
        for (i in 0 until n)
            ps[i + 1] = ps[i] + nums[i]
        var res = Int.MAX_VALUE
        val tree = TreeMap<Int, Int>()
        for (i in l..r)
            tree.compute(ps[i]) { _, v -> (v ?: 0) + 1 }
        for (i in 0..n - l) {
            val higher = tree.higherKey(ps[i])
            if (higher != null)
                res = Math.min(res, higher - ps[i])
            tree.compute(ps[i + l]) { _, v -> if (v == 1) null else v!! - 1 }
            if (i + 1 + r <= n)
                tree.compute(ps[i + 1 + r]) { _, v -> (v ?: 0) + 1 }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}