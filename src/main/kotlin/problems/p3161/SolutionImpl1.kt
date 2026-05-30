package problems.p3161

class SolutionImpl1 : Solution {
    override fun getResults(queries: Array<IntArray>): List<Boolean> {
        val parent = Segment(0, 100_000)
        val res = ArrayList<Boolean>()
        for (i in 0 until queries.size) {
            val query = queries[i]
            val x = query[1]
            var seg = parent
            while (seg.left != null)
                seg = if (seg.left!!.end > x) seg.left!! else seg.right!!
            if (query[0] == 1) {
                seg.left = Segment(seg.start, x)
                seg.right = Segment(x, seg.end)
            } else {
                res.add(seg.end >= x + query[2])
            }
        }
        return res
    }

    private class Segment(
        val start: Int,
        val end: Int,
        var left: Segment? = null,
        var right: Segment? = null
    )
}