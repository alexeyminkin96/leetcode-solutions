package problems.p3433

import java.util.Arrays

/**
 * **LeetCode Performance:**
 * - Runtime: `11 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `48.99 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*log(n))`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/count-mentions-per-user/solutions/7409009/kotlin-onlogn-11ms-on-by-alexeyminkin-dmvt)
 */
class SolutionImpl4 : Solution {
    override fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val mentions = IntArray(numberOfUsers)
        var allCount = 0
        var hereCount = 0
        var offlineCount = 0

        val hereTimestamp = IntArray(events.size)
        val offlineTimestampAndId = IntArray(events.size)

        for (i in 0 until events.size) {
            val event = events[i]
            if (event[0] == "MESSAGE") {
                when (event[2]) {
                    "ALL" -> allCount++
                    "HERE" -> hereTimestamp[hereCount++] = Integer.parseInt(event[1])

                    else -> {
                        var userId = -1
                        for (c in event[2]) {
                            if (c.code in 48..57)
                                userId = (c.code - 48) + if (userId != -1) userId * 10 else 0
                            else if (userId != -1) {
                                mentions[userId]++
                                userId = -1
                            }
                        }
                        if (userId != -1) mentions[userId]++
                    }
                }
            } else {
                offlineTimestampAndId[offlineCount++] = Integer.parseInt(event[1]) * 100 + Integer.parseInt(event[2])
            }
        }

        Arrays.sort(hereTimestamp, 0, hereCount)
        Arrays.sort(offlineTimestampAndId, 0, offlineCount)
        var offlineLeft = 0

        for (i in 0 until hereCount) {
            for (j in offlineLeft until offlineCount) {
                val offlineTimestamp = offlineTimestampAndId[j] / 100
                when {
                    hereTimestamp[i] < offlineTimestamp -> break
                    hereTimestamp[i] >= offlineTimestamp + 60 -> offlineLeft++
                    else -> mentions[offlineTimestampAndId[j] - offlineTimestamp * 100]--
                }
            }
        }

        for (i in 0 until mentions.size) {
            mentions[i] += allCount + hereCount
        }
        return mentions
    }
}
