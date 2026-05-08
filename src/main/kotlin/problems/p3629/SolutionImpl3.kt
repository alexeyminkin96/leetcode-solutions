package problems.p3629

/**
 * **LeetCode Performance:**
 * - Runtime: `110 ms` (Beats `100.00%` of Kotlin submissions)
 * - Memory: `87.36 MB` (Beats `100.00%` of Kotlin submissions)
 *
 * **Complexity:**
 * - Time: `O(n*log(v)+v*log(log(v)))`
 * - Space: `O(N + V)`
 *
 * **Notes:**
 * - [Full explanation](https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/solutions/8170046/kotlin-onlogvvloglogv-110ms-ovn-by-alexe-heed)
 */
class SolutionImpl3 : Solution {
    override fun minJumps(nums: IntArray): Int {
        val n = nums.size
        var max = 0
        for (i in 0 until n)
            max = Math.max(max, nums[i])

        val counts = IntArray(max + 1)
        for (i in 0 until n) {
            var num = nums[i]
            while (num > 1) {
                val primeDivider = lpf[num]
                counts[primeDivider] = counts[primeDivider] + 1
                while (num % primeDivider == 0) num /= primeDivider
            }
        }
        val dividerToIdx = arrayOfNulls<IntArray>(max + 1)
        for (i in 0 until n) {
            var num = nums[i]
            while (num > 1) {
                val primeDivider = lpf[num]
                var idxs = dividerToIdx[primeDivider]
                if (idxs == null) {
                    idxs = IntArray(counts[primeDivider])
                    dividerToIdx[primeDivider] = idxs
                    counts[primeDivider] = 0
                }
                idxs[counts[primeDivider]] = i
                counts[primeDivider] = counts[primeDivider] + 1
                while (num % primeDivider == 0) num /= primeDivider
            }
        }

        val visited = BooleanArray(n)
        val idxQueue = IntArray(n)
        var head = 0
        var tail = 0
        idxQueue[tail++] = 0
        var count = 0
        var nextRise = tail
        visited[0] = true

        fun putQueue(idx: Int) {
            idxQueue[tail++] = idx
            visited[idx] = true
        }

        while (true) {
            if (head == nextRise) {
                count++
                nextRise = tail
            }
            val idx = idxQueue[head++]
            if (idx == n - 1) return count
            if (!visited[idx + 1])
                putQueue(idx + 1)
            if (idx > 0 && !visited[idx - 1])
                putQueue(idx - 1)

            for (t in dividerToIdx[nums[idx]] ?: continue) {
                if (!visited[t])
                    putQueue(t)
                dividerToIdx[nums[idx]] = null
            }
        }
    }

    companion object {
        private val lpf = IntArray(1_000_001)

        init {
            for (i in 2 until lpf.size) {
                if (lpf[i] != 0) continue
                var j = i
                while (j < lpf.size) {
                    lpf[j] = i
                    j += i
                }
            }
        }
    }
}