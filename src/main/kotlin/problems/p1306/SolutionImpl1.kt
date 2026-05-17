package problems.p1306

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `62.02 MB` (Beats `44.93%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/jump-game-iii/solutions/8284040/kotlin-on-o1-by-alexeyminkin-qqhr)
 */
class SolutionImpl1 : Solution {
    override fun canReach(arr: IntArray, start: Int): Boolean {
        fun dfs(i: Int): Boolean {
            val jump = arr[i]
            arr[i] *= -1
            val l = i + jump
            if (l >= 0 && l < arr.size && arr[l] >= 0)
                if (arr[l] == 0 || dfs(l)) return true
            val r = i - jump
            if (r >= 0 && r < arr.size && arr[r] >= 0)
                if (arr[r] == 0 || dfs(r)) return true
            return false
        }
        return dfs(start)
    }
}