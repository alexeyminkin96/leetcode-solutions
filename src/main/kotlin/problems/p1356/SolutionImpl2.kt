package problems.p1356

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `4 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `45.09 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n log n)`
 * - Space: `O(1)`
 */
class SolutionImpl2 : Solution {
    override fun sortByBits(arr: IntArray): IntArray {
        for (i in 0 until arr.size)
            arr[i] = (Integer.bitCount(arr[i]) shl 16) or arr[i]
        Arrays.sort(arr)
        for (i in 0 until arr.size)
            arr[i] = arr[i] and 0b1111111111111111  //16 bits
        return arr
    }
}