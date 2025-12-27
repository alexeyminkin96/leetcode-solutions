package problems.p2402

import java.util.Arrays
import java.util.PriorityQueue

/**
 * **LeetCode Performance:**
 * - Runtime: `122 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `119.14 MB` (Beats `80.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m log m + m log n)`
 * - Space: `O(n)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/meeting-rooms-iii/solutions/7443595/kotlin-omlogmmlogn-122ms-on-2-heap-and-p-d2v0)
 */
class SolutionImpl2 : Solution {
    private val meetingsComparator = compareBy<IntArray> { it[0] }
    override fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        Arrays.sort(meetings, meetingsComparator)
        val endTimeAndRoomIds = PriorityQueue<Long>(n)
        val freeRoomIds = PriorityQueue<Int>(n)
        for (i in 0 until n) freeRoomIds.add(i)
        val meetingCounts = IntArray(n)
        val bits = 7
        val mask = (1L shl bits) - 1

        for (i in 0 until meetings.size) {
            val meetingStart = meetings[i][0]
            val meetingEnd = meetings[i][1]

            while (!endTimeAndRoomIds.isEmpty() && endTimeAndRoomIds.peek() shr 7 <= meetingStart) {
                freeRoomIds.add((endTimeAndRoomIds.poll() and mask).toInt())
            }

            val newEndTime: Long
            val roomId: Int
            if (!freeRoomIds.isEmpty()) {
                newEndTime = meetingEnd.toLong()
                roomId = freeRoomIds.poll()
            } else {
                val room = endTimeAndRoomIds.poll()
                newEndTime = (room shr 7) + meetingEnd - meetingStart
                roomId = (room and mask).toInt()
            }
            endTimeAndRoomIds.add((newEndTime shl 7) + roomId)
            meetingCounts[roomId]++
        }

        var roomIdMaxCount = 0
        for (i in 0 until meetingCounts.size) {
            if (meetingCounts[i] > meetingCounts[roomIdMaxCount]) roomIdMaxCount = i
        }
        return roomIdMaxCount
    }
}