package problems.p3161

class SolutionImpl2 : Solution {
    override fun getResults(queries: Array<IntArray>): List<Boolean> {
        val tree = SegTree()
        val res = ArrayList<Boolean>()
        for (i in 0 until queries.size) {
            val query = queries[i]
            if (query[0] == 1) tree.addWall(query[1])
            else res.add(tree.checkBlock(query[1], query[2]))
        }
        return res
    }

    private class SegTree {
        private val parent = Segment(0, 100_000)

        fun checkBlock(x: Int, sz: Int): Boolean {
            return checkBlock(x, sz, parent)
        }

        private fun checkBlock(x: Int, sz: Int, seg: Segment): Boolean {
            if (seg.max < sz) return false
            if (x < seg.start) return false
            if (x >= seg.end) return true
            if (seg.left == null) return seg.start + sz <= x
            return checkBlock(x, sz, seg.left!!) || checkBlock(x, sz, seg.right!!)
        }

        fun addWall(x: Int) {
            addWall(x, parent)
        }

        private fun addWall(x: Int, seg: Segment) {
            if (seg.left != null) {
                addWall(x, if (seg.left!!.end > x) seg.left!! else seg.right!!)
            } else {
                seg.left = Segment(seg.start, x)
                seg.right = Segment(x, seg.end)
            }
            seg.max = Math.max(seg.left!!.max, seg.right!!.max)
        }
    }

    private class Segment(
        val start: Int,
        val end: Int,
        var max: Int = end - start,
        var left: Segment? = null,
        var right: Segment? = null
    )
}