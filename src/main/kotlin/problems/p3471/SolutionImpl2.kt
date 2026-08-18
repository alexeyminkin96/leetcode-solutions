package problems.p3471

class SolutionImpl2 : Solution {
    override fun largestInteger(nums: IntArray, k: Int): Int {
        val n = nums.size
        var res = -1
        when (k) {
            1 -> {
                val counts = IntArray(51)
                for (num in nums) counts[num]++
                for (i in counts.size - 1 downTo 0) if (counts[i] == 1) return i
            }

            n -> for (num in nums) res = Math.max(res, num)

            else -> {
                var l = nums[0]
                var r = nums[n - 1]
                if (l == r) return -1
                for (i in 1 until n - 1)
                    when (nums[i]) {
                        l -> l = -1
                        r -> r = -1
                    }
                res = Math.max(l, r)
            }
        }
        return res
    }
}