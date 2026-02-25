package problems.p1356

/**
 * **LeetCode Performance:**
 * - Runtime: `3 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/solutions/7607743/kotlin-on-3ms-on-by-alexeyminkin-3clc)
 */
class SolutionImpl4 : Solution {
    override fun sortByBits(arr: IntArray): IntArray {
        for (i in 0 until arr.size)
            arr[i] = (Integer.bitCount(arr[i]) shl 14) or arr[i]
        radixSort(arr)
        for (i in 0 until arr.size)
            arr[i] = arr[i] and 0b11111111111111  //14 bits
        return arr
    }

    private fun radixSort(arr: IntArray) {
        var from = arr
        var to = IntArray(from.size)
        val counts = IntArray(512)
        val pos = IntArray(counts.size)
        val mask = counts.size - 1
        var shift = 0
        while (shift <= 9) {
            for (i in 0 until from.size)
                counts[(from[i] ushr shift) and mask]++
            var sum = 0
            for (i in 0 until counts.size) {
                pos[i] = sum
                sum += counts[i]
            }
            for (i in 0 until from.size) {
                val a = (from[i] ushr shift) and mask
                to[pos[a]++] = from[i]
                counts[a]--
            }
            shift += 9
            val buf = from
            from = to
            to = buf
        }
    }
}
