package problems.p4023

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `59 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `139.40 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(r²)`
 * - Space: `O(r²)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/elevator-requests-ii/solutions/8466603/kotlin-or2-59ms-or2-by-alexeyminkin-ps3t)
 */
class SolutionImpl1 : Solution {
    override fun elevatorRequests(n: Int, start: Int, requests: IntArray): Long {
        val reqSize = requests.size + 1
        val reqs = IntArray(reqSize)
        System.arraycopy(requests, 0, reqs, 1, reqSize - 1)
        reqs[0] = start
        Arrays.sort(reqs)
        var startI = 0
        while (reqs[startI] != start) startI++
        val inf = Long.MAX_VALUE shr 1
        val lDp = Array(reqSize) { LongArray(reqSize) { inf } }
        val rDp = Array(reqSize) { LongArray(reqSize) { inf } }
        lDp[startI][startI] = 0
        rDp[startI][startI] = 0
        for (len in 0..reqSize) {
            val remReq = reqSize.toLong() - 1 - len
            for (l in Math.max(startI - len, 0)..Math.min(startI, reqSize - 1 - len)) {
                val r = l + len
                if (l > 0)
                    lDp[l - 1][r] = minOf(
                        lDp[l - 1][r],
                        lDp[l][r] + (reqs[l] - reqs[l - 1]) * remReq,
                        rDp[l][r] + (reqs[r] - reqs[l - 1]) * remReq
                    )
                if (r < reqSize - 1)
                    rDp[l][r + 1] = minOf(
                        rDp[l][r + 1],
                        rDp[l][r] + (reqs[r + 1] - reqs[r]) * remReq,
                        lDp[l][r] + (reqs[r + 1] - reqs[l]) * remReq
                    )
            }
        }
        return Math.min(lDp[0][reqSize - 1], rDp[0][reqSize - 1])
    }
}