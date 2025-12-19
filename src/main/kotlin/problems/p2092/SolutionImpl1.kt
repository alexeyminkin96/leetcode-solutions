package problems.p2092

import java.util.Arrays
import java.util.LinkedList

/**
 * **LeetCode Performance:**
 * - Runtime: `97 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `105.20 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(m log m)`
 * - Space: `O(m)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/find-all-people-with-secret/solutions/7424147/kotlin-omlogm-97ms-om-by-alexeyminkin-rpl5)
 */
class SolutionImpl1 : Solution {
    private val comparator = compareBy<IntArray> { it[2] }
    override fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val know = HashSet<Int>()
        know.add(0)
        know.add(firstPerson)

        Arrays.sort(meetings, comparator)

        val manToMeets = HashMap<Int, ArrayList<Int>>()
        val knowByTime = LinkedList<Int>()

        fun add(pub: Int, sub: Int) {
            var subs = manToMeets[pub]
            if (subs == null) {
                subs = ArrayList()
                manToMeets[pub] = subs
            }
            subs.add(sub)
            if (know.contains(pub)) knowByTime.add(pub)
        }

        for (i in 0 until meetings.size) {
            val first = meetings[i][0]
            val second = meetings[i][1]
            if (manToMeets.isEmpty()) {
                val containsFirst = know.contains(first)
                val containsSecond = know.contains(second)

                if (containsFirst || containsSecond) {
                    if (!containsSecond) know.add(second)
                    else if (!containsFirst) know.add(first)
                    continue
                }
            }
            val isNextTimeSame = i + 1 < meetings.size && meetings[i][2] == meetings[i + 1][2]
            if (isNextTimeSame || !manToMeets.isEmpty()) {
                add(first, second)
                add(second, first)
            }
            if (!isNextTimeSame && !manToMeets.isEmpty()) {
                while (!knowByTime.isEmpty()) {
                    val people = manToMeets.remove(knowByTime.removeFirst())
                    if (people != null) {
                        knowByTime.addAll(people)
                        know.addAll(people)
                    }
                }
                manToMeets.clear()
            }
        }
        return know.toList()
    }
}