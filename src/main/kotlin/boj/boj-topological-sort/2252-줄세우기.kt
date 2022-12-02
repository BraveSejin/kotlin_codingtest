package boj.`boj-topological-sort`

import java.util.*


fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
    val inDegree = IntArray(n + 1) { 0 }
    // 앞에 아무도 없는 친구들 먼저!
    repeat(m) {
        val (a, b) = readln().split(" ").map(String::toInt).let { it[0] to it[1] }
        graph[a].add(b)
        inDegree[b] += 1
    }
    // 인디그리가 0인 학생들 을 큐에 넣고 하나씩 빼자
    val queue = LinkedList<Int>()

    for (index in 1..inDegree.lastIndex) {
        if (inDegree[index] == 0) queue.offer(index)
    }

    val ans = mutableListOf<Int>()
    for (i in  1 .. n){
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
        print("$it ")
    }

}