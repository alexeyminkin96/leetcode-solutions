package problems.p3331

class SolutionImpl1 : Solution {
    override fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val n = parent.size
        val nodes = Array(n) { Node(it, s[it]) }

        for (i in 1 until n)
            nodes[parent[i]].children.add(i)


        val pa = IntArray(26) { -1 }

        fun dfs(node: Node) {
            node.closestParent = pa[node.c - 'a']
            pa[node.c - 'a'] = node.id
            for (child in node.children)
                dfs(nodes[child])
            pa[node.c - 'a'] = node.closestParent
        }
        dfs(nodes[0])


        for (node in nodes) {
            if (node.closestParent == -1) continue
            nodes[parent[node.id]].children.remove(node.id)
            nodes[node.closestParent].children.add(node.id)
        }

        fun dfs2(node: Node): Int {
            for (child in node.children)
                node.subTreeSize += dfs2(nodes[child])
            return node.subTreeSize
        }

        dfs2(nodes[0])

        return IntArray(n) { nodes[it].subTreeSize }
    }

    private data class Node(
        val id: Int,
        val c: Char,
        var closestParent: Int = -1,
        var subTreeSize: Int = 1,
        val children: ArrayList<Int> = ArrayList()
    )
}