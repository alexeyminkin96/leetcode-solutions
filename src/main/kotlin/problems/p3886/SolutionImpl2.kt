package problems.p3886

class SolutionImpl2 : Solution {
    override fun sortableIntegers(nums: IntArray): Int {
        val n = nums.size

        val maxLefter = IntArray(n)
        var max = 0
        for (i in 0 until n) {
            maxLefter[i] = max
            max = Math.max(max, nums[i])
        }
        val correctBorder = BooleanArray(n)
        var min = Int.MAX_VALUE
        for (i in n - 1 downTo 0) {
            min = Math.min(min, nums[i])
            correctBorder[i] = maxLefter[i] <= min
        }

        val dividers = ArrayList<Int>()
        for (i in 1..n)
            if (n % i == 0) dividers.add(i)
        var res = 0

        divider@ for (k in dividers) {
            for (t in 1 until n / k)
                if (!correctBorder[t * k]) continue@divider
            var i = 0
            while (i < n) {
                var prev = nums[i + k - 1]
                var hasDec = false
                for (j in 0 until k) {
                    val num = nums[i++]
                    if (num < prev)
                        if (hasDec) continue@divider
                        else hasDec = true
                    prev = num
                }
            }
            res += k
        }
        return res
    }
}