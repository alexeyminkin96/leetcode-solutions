package problems.p3629

class SolutionImpl2 : Solution {
    override fun minJumps(nums: IntArray): Int {
        val n = nums.size

        val dividerToIdx = HashMap<Int, MutableList<Int>>()
        for (i in 0 until n) {
            var num = nums[i]
            while (num > 1) {
                val primeDivider = lfs[num]
                var idxs = dividerToIdx[primeDivider]
                if (idxs == null) {
                    idxs = ArrayList()
                    dividerToIdx[primeDivider] = idxs
                }
                idxs.add(i)
                while (num % primeDivider == 0) num /= primeDivider
            }
        }

        val visited = BooleanArray(n)
        val idxQueue = IntArray(n)
        val countQueue = IntArray(n)
        var head = 0
        var tail = 0
        idxQueue[tail] = 0
        countQueue[tail++] = 0
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

            for (t in dividerToIdx.remove(nums[idx]) ?: continue)
                if (!visited[t])
                    putQueue(t)
        }
    }

    companion object {
        private val lfs = IntArray(1_000_001)

        init {
            for (i in 2 until lfs.size) {
                if (lfs[i] != 0) continue
                var j = i
                while (j < lfs.size) {
                    lfs[j] = i
                    j += i
                }
            }
        }
    }
}