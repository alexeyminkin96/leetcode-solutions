package problems.p3886

class SolutionImpl1 : Solution {
    override fun sortableIntegers(nums: IntArray): Int {
        val n = nums.size
        val dividers = ArrayList<Int>()
        for (i in 1..n)
            if (n % i == 0) dividers.add(i)
        var res = 0
        divider@ for (k in dividers) {
            var i = 0
            var prevMax = 0
            while (i < n) {
                var min = Int.MAX_VALUE
                var max = 0
                var prev = nums[i + k - 1]
                var hasDec = false
                for (j in 0 until k) {
                    val num = nums[i++]
                    if (num < prev)
                        if (hasDec) continue@divider
                        else hasDec = true
                    min = Math.min(min, num)
                    max = Math.max(max, num)
                    prev = num
                }
                if (prevMax > min) continue@divider
                prevMax = max
            }
            res += k
        }
        return res
    }
}