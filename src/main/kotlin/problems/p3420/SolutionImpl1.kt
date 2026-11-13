package problems.p3420

class SolutionImpl1 : Solution {
    override fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
        val n = nums.size
        val queue = ArrayList<Num>()
        var windowSum = 0L
        var res = 0L
        var r = n - 1
        for (l in n - 1 downTo 0) {
            val num = nums[l]
            var count = 1
            while (!queue.isEmpty() && queue[0].num <= num) {
                val lowestNum = queue.removeFirst()
                count += lowestNum.count
                windowSum += (num - lowestNum.num).toLong() * lowestNum.count
            }
            queue.addFirst(Num(num, count))
            while (windowSum > k) {
                val highestNum = queue.last()
                if (--highestNum.count == 0) queue.removeLast()
                windowSum -= highestNum.num - nums[r--]
            }
            res += r - l + 1
        }
        return res
    }

    private data class Num(
        val num: Int,
        var count: Int
    )
}