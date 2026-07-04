package problems.p2492

import java.util.PriorityQueue

class SolutionImpl1 : Solution {
    override fun minScore(n: Int, roads: Array<IntArray>): Int {
        val cities = Array(n + 1) { City(it) }
        for (road in roads) {
            val city1 = cities[road[0]]
            val city2 = cities[road[1]]
            val dist = road[2]
            city1.cities.add(city2)
            city1.dists.add(dist)
            city2.cities.add(city1)
            city2.dists.add(dist)
        }

        val pq = PriorityQueue<City> { a, b -> a.minDist - b.minDist }
        var cur = cities[1]
        cur.minDist = 0
        while (cur.id != n) {
            cur.visited = true
            for (i in 0 until cur.cities.size) {
                val next = cur.cities[i]
                if (!next.visited && next.minDist > cur.minDist + cur.dists[i]) {
                    next.minDist = cur.minDist + cur.dists[i]
                    pq.add(next)
                }
            }
            while (cur.visited)
                cur = pq.poll()
        }
        return cur.minDist
    }

    private data class City(
        val id: Int,
        val cities: MutableList<City> = mutableListOf(),
        val dists: MutableList<Int> = mutableListOf(),
        var visited: Boolean = false,
        var minDist: Int = Int.MAX_VALUE,
    )
}