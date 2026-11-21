package problems.p3331

class SolutionImpl3 : Solution {
    override fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = parent.size

        val children = Array(n) { ArrayList<Int>() }
        val closestParent = IntArray(n) { -1 }
        val subTreeSizes = IntArray(n) { 1 }

        for (i in 1 until n)
            children[parent[i]].add(i)

        val pa = IntArray(26) { -1 }

        fun dfs(i: Int) {
            closestParent[i] = pa[s[i] - 'a']
            pa[s[i] - 'a'] = i
            for (child in children[i])
                dfs(child)
            pa[s[i] - 'a'] = closestParent[i]
            if (i == 0) return
            val p = if (closestParent[i] != -1) closestParent[i] else parent[i]
            subTreeSizes[p] += subTreeSizes[i]
        }
        dfs(0)

        return subTreeSizes
    }
}