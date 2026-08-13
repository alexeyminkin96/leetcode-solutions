package problems.p2213

import java.util.LinkedList

class SolutionImpl1 : Solution {
    override fun longestRepeating(s: String, queryCharacters: String, queryIndices: IntArray): IntArray {
        val segTree = SegTree(s)
        return IntArray(queryIndices.size) { segTree.changeChar(queryIndices[it], queryCharacters[it]) }
    }

    private class SegTree(s: String) {
        private val root: Node

        init {
            val s = s.toCharArray()
            var order = LinkedList<Node>()
            for (i in 0 until s.size) order.add(Node(s[i], s[i], i, i))
            while (order.size > 1) {
                val newOrder = LinkedList<Node>()
                while (order.size > 1) {
                    val l = order.removeFirst()
                    val r = order.removeFirst()
                    newOrder.add(
                        Node(
                            lChar = l.lChar,
                            rChar = r.rChar,
                            lIdx = l.lIdx,
                            rIdx = r.rIdx,
                            lCount = l.lCount + if (l.rChar == r.lChar && l.lCount == l.len) r.lCount else 0,
                            rCount = r.rCount + if (l.rChar == r.lChar && r.rCount == r.len) l.rCount else 0,
                            l = l,
                            r = r,
                            len = l.len + r.len,
                            maxLength = maxOf(
                                l.maxLength,
                                r.maxLength,
                                if (l.rChar == r.lChar) l.rCount + r.lCount else 0
                            ),
                        )
                    )
                }
                if (!order.isEmpty()) newOrder.add(order.removeFirst())
                order = newOrder
            }
            root = order[0]
        }

        fun changeChar(i: Int, c: Char): Int {
            changeChar(root, i, c)
            return root.maxLength
        }

        private fun changeChar(node: Node, i: Int, c: Char): Boolean {
            if (node.lIdx == node.rIdx) {
                if (node.lChar == c) return false
                node.lChar = c
                node.rChar = c
                return true
            } else {
                val l = node.l!!
                val r = node.r!!
                if (!changeChar(if (l.rIdx >= i) l else r, i, c)) return false
                node.lChar = l.lChar
                node.rChar = r.rChar
                node.lCount = l.lCount + if (l.rChar == r.lChar && l.lCount == l.len) r.lCount else 0
                node.rCount = r.rCount + if (l.rChar == r.lChar && r.rCount == r.len) l.rCount else 0
                node.maxLength = maxOf(
                    l.maxLength,
                    r.maxLength,
                    if (l.rChar == r.lChar) l.rCount + r.lCount else 0
                )
                return true
            }
        }
    }

    private data class Node(
        var lChar: Char,
        var rChar: Char,
        val lIdx: Int,
        val rIdx: Int,
        var lCount: Int = 1,
        var rCount: Int = 1,
        val l: Node? = null,
        val r: Node? = null,
        val len: Int = 1,
        var maxLength: Int = 1,
    )
}