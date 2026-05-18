package problems.p1345

/**
 * **LeetCode Performance:**
 * - Runtime: `46 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `60.39 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-iv/solutions/8263954/kotlin-on-46ms-on-by-alexeyminkin-ktoy)
 */
class SolutionImpl1 : Solution {
    override fun minJumps(arr: IntArray): Int {
        val shift = 100_000_001
        val valToIdx = HashMap<Int, MutableList<Int>>(arr.size)
        for (i in 0 until arr.size) {
            arr[i] += shift
            var list = valToIdx[arr[i]]
            if (list == null) {
                list = ArrayList()
                valToIdx[arr[i]] = list
            }
            list.add(i)
        }
        arr[0] *= -1

        val queue = IntArray(arr.size)
        var head = 0
        var tail = 1
        var count = 0
        var nextC = tail

        fun jump(i: Int) {
            if (arr[i] > 0) {
                queue[tail++] = i
                arr[i] *= -1
            }
        }

        while (true) {
            if (head == nextC) {
                count++
                nextC = tail
            }
            val i = queue[head++]
            if (i < arr.size - 1) jump(i + 1) else return count
            if (i > 0) jump(i - 1)
            for (idx in valToIdx.remove(-arr[i]) ?: continue)
                jump(idx)
        }
    }
}