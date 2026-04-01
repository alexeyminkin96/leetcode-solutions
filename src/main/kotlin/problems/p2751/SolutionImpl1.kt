package problems.p2751

import java.util.Arrays
import java.util.Collections

class SolutionImpl1 : Solution {
    override fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): IntArray {
        val n = positions.size
        if (n == 1) return intArrayOf(healths[0])
        val robots = arrayOfNulls<Robot>(n)
        for (i in 0 until n)
            robots[i] = Robot(i, positions[i], healths[i], directions[i])
        robots as Array<Robot>
        Arrays.sort(robots, compareBy { it.pos })
        robots[0].next = robots[1]
        robots[n - 1].prev = robots[n - 2]
        for (i in 1 until n - 1) {
            robots[i].prev = robots[i - 1]
            robots[i].next = robots[i + 1]
        }

        val res = ArrayList<Robot>()
        var cur = robots[0]
        while (true) {
            if (cur.dir == 'L') {
                val prev = cur.prev
                if (prev == null) {
                    res.add(cur)
                    cur = cur.next ?: break
                    cur.prev = null
                } else {
                    if (prev.dir == 'L') {
                        cur = prev
                    } else {
                        when {
                            cur.hp > prev.hp -> {
                                cur.hp--
                                cur.prev = prev.prev
                                cur.prev?.next = cur
                            }

                            cur.hp < prev.hp -> {
                                prev.hp--
                                prev.next = cur.next
                                cur.next?.prev = prev
                                cur = prev
                            }

                            else -> {
                                prev.prev?.next = cur.next
                                cur.next?.prev = prev.prev
                                cur = prev.prev ?: cur.next ?: break
                            }
                        }
                    }
                }
            } else {
                val next = cur.next
                if (next == null) {
                    res.add(cur)
                    cur = cur.prev ?: break
                    cur.next = null
                } else {
                    if (next.dir == 'R') {
                        cur = next
                    } else {
                        when {
                            cur.hp > next.hp -> {
                                cur.hp--
                                cur.next = next.next
                                cur.next?.prev = cur
                            }

                            cur.hp < next.hp -> {
                                next.hp--
                                next.prev = cur.prev
                                cur.prev?.next = next
                                cur = next
                            }

                            else -> {
                                next.next?.prev = cur.prev
                                cur.prev?.next = next.next
                                cur = next.next ?: cur.prev ?: break
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(res, compareBy { it.i })
        return res.map { it.hp }.toIntArray()
    }

    private data class Robot(
        val i: Int,
        val pos: Int,
        var hp: Int,
        val dir: Char,
        var prev: Robot? = null,
        var next: Robot? = null
    )
}