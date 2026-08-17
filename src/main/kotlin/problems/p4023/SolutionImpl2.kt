package problems.p4023

import java.util.Arrays

class SolutionImpl2 : Solution {
    override fun elevatorRequests(n: Int, start: Int, requests: IntArray): Long {
        val reqSize = requests.size
        Arrays.sort(requests)
        var startI = 0
        while (startI < reqSize && requests[startI] < start) startI++
        val inf = Long.MAX_VALUE shr 1
        val lDp = Array(reqSize) { LongArray(reqSize) { inf } }
        val rDp = Array(reqSize) { LongArray(reqSize) { inf } }
        if (startI > 0) lDp[startI - 1][startI - 1] = (start - requests[startI - 1]) * reqSize.toLong()
        if (startI < reqSize) rDp[startI][startI] = (requests[startI] - start) * reqSize.toLong()
        for (len in 0..reqSize) {
            val remReq = reqSize.toLong() - 1 - len
            for (l in Math.max(startI - 1 - len, 0)..Math.min(startI, reqSize - 1 - len)) {
                val r = l + len
                if (l > 0)
                    lDp[l - 1][r] = minOf(
                        lDp[l - 1][r],
                        lDp[l][r] + (requests[l] - requests[l - 1]) * remReq,
                        rDp[l][r] + (requests[r] - requests[l - 1]) * remReq
                    )
                if (r < reqSize - 1)
                    rDp[l][r + 1] = minOf(
                        rDp[l][r + 1],
                        rDp[l][r] + (requests[r + 1] - requests[r]) * remReq,
                        lDp[l][r] + (requests[r + 1] - requests[l]) * remReq
                    )
            }
        }
        return Math.min(lDp[0][reqSize - 1], rDp[0][reqSize - 1])
    }
}