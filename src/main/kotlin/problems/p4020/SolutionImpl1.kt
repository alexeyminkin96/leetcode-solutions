package problems.p4020

/**
 * **LeetCode Performance:**
 * - Runtime: `1 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `43.08 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(requests.size)`
 * - Space: `O(1)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/elevator-requests-i/solutions/8465205/kotlin-or-1ms-o1-by-alexeyminkin-uuq1)
 */
class SolutionImpl1 : Solution {
    override fun elevatorRequests(n: Int, requests: IntArray): Int {
        var prev = 0
        var res = 0
        for (request in requests) {
            res += Math.abs(request - prev)
            prev = request
        }
        return res
    }
}