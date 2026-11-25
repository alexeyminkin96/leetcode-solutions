package problems.p3934

class SolutionImpl1 : Solution {
    override fun smallestUniqueSubarray(nums: IntArray): Int {
        val n = nums.size
        var l = 1
        var r = n

        outer@ while (l < r) {
            val len = (l + r) shr 1
            val hashStarts = HashMap<Long, MutableList<Int>>()
            var hash = 0L
            val base = 100_003
            val mod = 92_230_000_019_999L
            for (i in 0 until len)
                hash = (hash * base + nums[i]) % mod
            var div = 1L
            for (i in 0 until len - 1)
                div = (div * base) % mod

            hashStarts[hash] = mutableListOf(0)
            for (i in len until n) {
                hash = ((hash - nums[i - len] * div % mod + mod) % mod * base + nums[i]) % mod
                hashStarts.compute(hash) { _, starts ->
                    val v = (starts ?: mutableListOf())
                    v.add(i - len + 1)
                    v
                }
            }
            for (starts in hashStarts.values) {
                if (starts.size == 1) {
                    r = len
                    continue@outer
                }
            }
            for (starts in hashStarts.values) {
                s@ for (i in 0 until starts.size) {
                    for (j in 0 until starts.size)
                        if (i != j && compareSubarrays(nums, starts[i], starts[j], len))
                            continue@s
                    r = len
                    continue@outer
                }
            }
            l = len + 1
        }
        return l
    }

    private fun compareSubarrays(nums: IntArray, start1: Int, start2: Int, len: Int): Boolean {
        val diff = start2 - start1
        for (i in start1 until start1 + len)
            if (nums[i] != nums[i + diff]) return false
        return true
    }
}