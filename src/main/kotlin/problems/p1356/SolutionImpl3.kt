package problems.p1356

/**
 * **LeetCode Performance:**
 * - Runtime: `15 ms` (Beats `57.14%` of Kotlin submissions)
 * - Memory: `47.14 MB` (Beats `85.71%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n + K)`
 * - Space: `O(K)`
 */
class SolutionImpl3 : Solution {
    override fun sortByBits(arr: IntArray): IntArray {
        val countSort = IntArray(270_000)
        for (i in 0 until arr.size)
            countSort[(Integer.bitCount(arr[i]) shl 14) or arr[i]]++
        var n = 0
        var i = 0
        while (n < arr.size) {
            if (countSort[i]-- > 0)
                arr[n++] = i and 0b11111111111111
            else i++
        }
        return arr
    }
}
