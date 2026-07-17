package problems.p3312

/**
 * **LeetCode Performance:**
 * - Runtime: `22 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `75.71 MB` (Beats `50.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O((m+q)*log(m))`
 * - Space: `O(m)`
 */
class SolutionImpl1 : Solution {
    override fun gcdValues(nums: IntArray, queries: LongArray): IntArray {
        var max = 0
        for (num in nums) max = Math.max(max, num)
        val countSort = IntArray(max + 1)
        for (num in nums) countSort[num]++
        val gcdCount = LongArray(max + 1)
        for (i in max downTo 1) {
            var count = 0L
            for (j in i..max step i) count += countSort[j]
            count = count * (count - 1) shr 1
            for (j in 2 * i..max step i) count -= gcdCount[j]
            gcdCount[i] = count
        }
        for (i in 1..max) gcdCount[i] += gcdCount[i - 1]
        return IntArray(queries.size) {
            var l = 0
            var r = max
            while (l < r) {
                val m = (l + r) shr 1
                if (queries[it] < gcdCount[m]) r = m
                else l = m + 1
            }
            l
        }
    }
}