package problems.p3433

import java.util.Collections

/**
 * **LeetCode Performance:**
 * - Runtime: `19 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.52 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*log(n))`
 * - Space: `O(n)`
 */
class SolutionImpl3 : Solution {

    private val comparator = compareBy<IntArray> { it[1] * 10 + it[0] }

    override fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val mentions = IntArray(numberOfUsers)
        var all = 0
        var here = 0
        var offlineCount = 0

        val sortedEvents = ArrayList<IntArray>()

        for (i in 0 until events.size) {
            val event = events[i]
            val mention = event[2]
            if (event[0] == "MESSAGE") {
                when (mention) {
                    "ALL" -> all++
                    "HERE" -> {
                        here++
                        sortedEvents.add(intArrayOf(2, Integer.parseInt(event[1])))
                    }

                    else -> {
                        var userId = -1
                        for (c in mention) {
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
                sortedEvents.add(intArrayOf(1, Integer.parseInt(event[1]), Integer.parseInt(mention)))
                offlineCount++
            }
        }

        Collections.sort(sortedEvents, comparator)
        val offlineTimestamp = IntArray(offlineCount)
        val offlineId = IntArray(offlineCount)
        var offlineL = 0
        var offlineR = 0

        for (event in sortedEvents) {
            if (event[0] == 1) {
                offlineTimestamp[offlineR] = event[1]
                offlineId[offlineR++] = event[2]
            } else {
                for (i in offlineL until offlineR) {
                    if (offlineTimestamp[i] + 60 <= event[1])
                        offlineL++
                    else
                        mentions[offlineId[i]]--
                }
            }
        }

        for (i in 0 until mentions.size) {
            mentions[i] += all + here
        }
        return mentions
    }
}
