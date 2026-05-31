package problems.p2126

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        var m = mass.toLong()
        Arrays.sort(asteroids)
        var i = 0
        while (i < asteroids.size && asteroids[i] <= m) m += asteroids[i++]
        return i == asteroids.size
    }
}