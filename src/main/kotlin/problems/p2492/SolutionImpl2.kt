package problems.p2492

class SolutionImpl2 : Solution {
    override fun minScore(n: Int, roads: Array<IntArray>): Int {
        val cities = Array(n + 1) { City() }
        for (road in roads) {
            val city1 = cities[road[0]]
            val city2 = cities[road[1]]
            val dist = road[2]
            city1.cities.add(road[1])
            city1.dists.add(dist)
            city2.cities.add(road[0])
            city2.dists.add(dist)
        }
        val visited = BooleanArray(n + 1)
        fun dfs(cityIdx: Int): Int {
            visited[cityIdx] = true
            val city = cities[cityIdx]
            var min = Int.MAX_VALUE
            for (i in 0 until city.cities.size) {
                min = Math.min(min, city.dists[i])
                if (!visited[city.cities[i]])
                    min = Math.min(min, dfs(city.cities[i]))
            }
            return min
        }
        return dfs(1)
    }

    private data class City(
        val cities: MutableList<Int> = mutableListOf(),
        val dists: MutableList<Int> = mutableListOf(),
        var visited: Boolean = false
    )
}