package problems.p2402

import java.util.Arrays
import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `166 ms` (Beats `66.67%` of Kotlin submissions)
 * - Memory: `123.04 MB` (Beats `60.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m log m + m log n)`
 * - Space: `O(n)`
 */
class SolutionImpl1 : Solution {
    private val meetingsComparator = compareBy<IntArray> { it[0] }
    private val endTimeAndRoomIdComparator = compareBy<LongArray> { it[0] }.thenBy { it[1] }
    override fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        Arrays.sort(meetings, meetingsComparator)
        val endTimeAndRoomId = PriorityQueue(endTimeAndRoomIdComparator)
        val freeRoomIds = PriorityQueue<Long>()
        for (i in 0L until n) {
            freeRoomIds.add(i)
        }
        val counts = IntArray(n)

        for (i in 0 until meetings.size) {
            val meeting = meetings[i]
            val meetingStart = meeting[0]
            val meetingEnd = meeting[1]

            while (!endTimeAndRoomId.isEmpty() && endTimeAndRoomId.peek()[0] <= meetingStart) {
                freeRoomIds.add(endTimeAndRoomId.poll()[1])
            }

            val roomId: Long
            var delay = 0L

            if (!freeRoomIds.isEmpty()) {
                roomId = freeRoomIds.poll()
            } else {
                val room = endTimeAndRoomId.poll()
                roomId = room[1]
                delay = room[0] - meetingStart
            }
            val ar = LongArray(2)
            ar[0] = meetingEnd + delay
            ar[1] = roomId
            endTimeAndRoomId.add(ar)
            counts[roomId.toInt()]++
        }

        var result = 0
        var maxCount = 0
        for (i in 0 until n) {
            if (counts[i] > maxCount) {
                maxCount = counts[i]
                result = i
            }
        }

        return result
    }
}