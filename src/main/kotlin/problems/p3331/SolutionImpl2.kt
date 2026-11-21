package problems.p3331

class SolutionImpl2 : Solution {
    override fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = parent.size

        val children = Array(n) { ArrayList<Int>() }
        val closestParent = IntArray(n) { -1 }

        for (i in 1 until n)
            children[parent[i]].add(i)

        val pa = IntArray(26) { -1 }

        fun dfs(i: Int) {
            closestParent[i] = pa[s[i] - 'a']
            pa[s[i] - 'a'] = i
            for (child in children[i])
                dfs(child)
            pa[s[i] - 'a'] = closestParent[i]
        }
        dfs(0)


        for (i in 1 until n) {
            if (closestParent[i] == -1 || closestParent[i] == parent[i]) continue
            children[parent[i]].remove(i)
            children[closestParent[i]].add(i)
        }

        val subTreeSizes = IntArray(n) { 1 }

        fun dfs2(i: Int): Int {
            for (child in children[i])
                subTreeSizes[i] += dfs2(child)
            return subTreeSizes[i]
        }
        dfs2(0)

        return subTreeSizes
    }
}