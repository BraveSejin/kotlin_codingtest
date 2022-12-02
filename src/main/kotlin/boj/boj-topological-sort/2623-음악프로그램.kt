package boj.`boj-topological-sort`

import java.util.*

fun main() {

    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
    val inDegree = IntArray(n + 1) { 0 }

    repeat(m) {
        val line = readln().split(" ").map { it.toInt() }
        val num = line.first()
        val order = line.drop(1)
        repeat(num - 1) {
            val added = graph[order[it]].add(order[it + 1])
            if (added)
                inDegree[order[it + 1]] += 1
        }
    }

    val queue = LinkedList<Int>()

    for (index in 1..inDegree.lastIndex) {
        if (inDegree[index] == 0) queue.offer(index)
    }

    val ans = mutableListOf<Int>()
    for (i in 1 .. n){
        if (queue.isEmpty()){
            println(0)
            return
        }

        val now = queue.pop()
        ans.add(now)
        for (other in graph[now]) {
            inDegree[other] -= 1
            if (inDegree[other] == 0) {
                queue.offer(other)
            }
        }
    }




    ans.forEach {
        println(it)
    }


}