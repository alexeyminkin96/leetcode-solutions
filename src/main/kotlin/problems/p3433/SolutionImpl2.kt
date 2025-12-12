package problems.p3433

import java.util.Collections
import java.util.LinkedList

/**
 * **LeetCode Performance:**
 * - Runtime: `23 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `49.59 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*log(n))`
 * - Space: `O(n)`
 */
class SolutionImpl2 : Solution {

    private val comparator = compareBy<Event> { it.timestamp }.thenBy { it.type }

    override fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
        val mentions = IntArray(numberOfUsers)
        var all = 0
        var here = 0

        val sortedEvents = ArrayList<Event>()

        for (i in 0 until events.size) {
            val event = events[i]
            val mention = event[2]
            if (event[0] == "MESSAGE") {
                when (mention) {
                    "ALL" -> all++
                    "HERE" -> {
                        here++
                        sortedEvents.add(Event(2, event[1].toInt()))
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
                sortedEvents.add(Event(1, event[1].toInt(), mention.toInt()))
            }
        }

        Collections.sort(sortedEvents, comparator)
        val offlines = LinkedList<Event>()

        for (event in sortedEvents) {
            if (event.type == 1) {
                offlines.add(event)
            } else {
                val iterator = offlines.iterator()
                while (iterator.hasNext()) {
                    val offline = iterator.next()
                    if (offline.timestamp + 60 <= event.timestamp)
                        iterator.remove()
                    else
                        mentions[offline.id]--
                }
            }
        }

        for (i in 0 until mentions.size) {
            mentions[i] += all + here
        }
        return mentions
    }

    private data class Event(
        val type: Int,
        val timestamp: Int,
        val id: Int = 0
    )
}
