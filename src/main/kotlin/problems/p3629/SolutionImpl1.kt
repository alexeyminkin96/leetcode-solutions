package problems.p3629

class SolutionImpl1 : Solution {
    override fun minJumps(nums: IntArray): Int {
        val n = nums.size

        val dividerToIdx = HashMap<Int, MutableList<Int>>()
        for (i in 0 until n) {
            for (t in dividers[nums[i]]) {
                var v = dividerToIdx[t]
                if (v == null) {
                    v = ArrayList()
                    dividerToIdx[t] = v
                }
                v.add(i)
            }
        }

        val visited = BooleanArray(n)
        val idxQueue = IntArray(n)
        val countQueue = IntArray(n)
        var head = 0
        var tail = 0
        idxQueue[tail] = 0
        countQueue[tail++] = 0
        visited[0] = true

        fun putQueue(idx: Int, count: Int) {
            idxQueue[tail] = idx
            countQueue[tail++] = count
            visited[idx] = true
        }

        while (true) {
            val idx = idxQueue[head]
            val count = countQueue[head++]
            if (idx == n - 1) return count
            if (!visited[idx + 1])
                putQueue(idx + 1, count + 1)
            if (idx > 0 && !visited[idx - 1])
                putQueue(idx - 1, count + 1)

            for (t in dividerToIdx.remove(nums[idx]) ?: continue)
                if (!visited[t])
                    putQueue(t, count + 1)
        }
    }

    companion object {
        private val dividers = Array(1_000_001) { ArrayList<Int>() }

        init {
            for (i in 2 until dividers.size)
                if (dividers[i].isEmpty()) {
                    var j = i
                    while (j < dividers.size) {
                        dividers[j].add(i)
                        j += i
                    }
                }
        }
    }
}