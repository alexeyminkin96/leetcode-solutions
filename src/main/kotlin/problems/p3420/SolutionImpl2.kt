package problems.p3420

/**
 * **LeetCode Performance:**
 * - Runtime: `21 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `130.70 MB` (Beats `25.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-non-decreasing-subarrays-after-k-operations/solutions/8611334/kotlin-on-21ms-on-primitives-only-by-ale-w4jh)
 */
class SolutionImpl2 : Solution {
    override fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
        val n = nums.size
        val queueNum = CircleIntArray(nums.size)
        val queueCount = CircleIntArray(nums.size)
        var windowSum = 0L
        var res = 0L
        var r = n - 1
        for (l in n - 1 downTo 0) {
            val num = nums[l]
            var count = 1
            while (queueNum.isNotEmpty() && queueNum.first() <= num) {
                count += queueCount.first()
                windowSum += (num - queueNum.removeFirst()).toLong() * queueCount.removeFirst()
            }
            queueNum.addFirst(num)
            queueCount.addFirst(count)
            while (windowSum > k) {
                windowSum -= queueNum.last() - nums[r--]
                if (queueCount.decrAndGetLast() == 0) {
                    queueNum.removeLast()
                    queueCount.removeLast()
                }
            }
            res += r - l + 1
        }
        return res
    }

    private class CircleIntArray(capacity: Int) {
        private val array: IntArray = IntArray(capacity)
        private var first: Int = array.size shr 1
        private var last: Int = first - 1
        private var size: Int = 0
        fun isNotEmpty(): Boolean = size > 0
        fun addFirst(num: Int) {
            size++
            if (first == 0) first = array.size
            array[--first] = num
        }

        fun first(): Int = array[first]
        fun last(): Int = array[last]
        fun removeFirst(): Int {
            size--
            val res = array[first++]
            if (first == array.size) first = 0
            return res
        }

        fun removeLast(): Int {
            size--
            val res = array[last--]
            if (last == -1) last = array.size - 1
            return res
        }

        fun decrAndGetLast(): Int = --array[last]
    }
}