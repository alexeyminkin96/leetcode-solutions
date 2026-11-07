package problems.p1882

import java.util.PriorityQueue

class SolutionImpl1 : Solution {
    override fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val n = servers.size
        val freeServers = PriorityQueue(n, compareBy<Server> { it.w }.thenBy { it.id })
        val busyServers = PriorityQueue(n, compareBy<Server> { it.whenFree }.thenBy { it.w }.thenBy { it.id })
        for (i in 0 until n)
            freeServers.add(Server(i, servers[i], 0))
        return IntArray(tasks.size) { time ->
            while (!busyServers.isEmpty() && busyServers.peek().whenFree <= time)
                freeServers.add(busyServers.poll())
            val server = if (!freeServers.isEmpty()) freeServers.poll() else busyServers.poll()
            server.whenFree = Math.max(server.whenFree, time) + tasks[time]
            busyServers.add(server)
            server.id
        }
    }

    private data class Server(
        val id: Int,
        val w: Int,
        var whenFree: Int
    )
}