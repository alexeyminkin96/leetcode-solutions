package problems.p1386

import java.util.Arrays

class SolutionImpl1 : Solution {
    override fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val m = reservedSeats.size
        val sort =
            LongArray(m) { (reservedSeats[it][0].toLong() shl 32) or reservedSeats[it][1].toLong() }
        Arrays.sort(sort)
        var res = n shl 1
        var i = 0
        while (i < m) {
            res -= 2
            val curRow = sort[i] shr 32
            var curSeat = 1L
            while (i < m && sort[i] shr 32 == curRow) {
                val nextSeat = sort[i++] and 0xffffffff
                if (nextSeat > curSeat + 8) res += 2
                else if (nextSeat > curSeat + 4 + (nextSeat and 1)) res++
                curSeat = nextSeat
            }
            val nextSeat = 10
            if (nextSeat > curSeat + 8) res += 2
            else if (nextSeat > curSeat + 4 + (nextSeat and 1)) res += 1
        }
        return res
    }
}