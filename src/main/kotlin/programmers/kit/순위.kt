package programmers.kit

fun main() {
    solution(
        5, arrayOf(
            intArrayOf(4, 3),
            intArrayOf(4, 2),
            intArrayOf(3, 2),
            intArrayOf(1, 2),
            intArrayOf(2, 5),
        )
    ).also { println(it) }
}

private fun solution(n: Int, results: Array<IntArray>): Int {
    var ans = 0
    val array = Array(n + 1) { IntArray(n + 1) { 0 } }
    results.forEach {
        val (win, lose) = it
        array[win][lose] = 1
        array[lose][win] = -1
    }
    for (k in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                if (array[a][k] == 1 && array[k][b] == 1) {
                    array[a][b] = 1
                    array[b][a] = -1
                } else if (array[a][k] == -1 && array[k][b] == -1) {
                    array[a][b] = -1
                    array[b][a] = 1
                }
            }
        }
    }

    for (i in 1..n) {
        var cnt = 0
        for (j in 1..n) {
            if (array[i][j] != 0) cnt += 1
        }
        if (cnt == n-1) ans += 1
    }
    return ans
}

//private fun solution(n: Int, results: Array<IntArray>): Int {
//
//    val indegree = IntArray(n + 1);
//    val graph = Array(n + 1) { mutableListOf<Int>() }
//    results.forEach {
//        val (src, dest) = it
//        graph[src].add(dest)
//        indegree[dest] += 1
//    }
//    val tempQ = LinkedList<Int>()
//    val q = LinkedList<Int>()
//    for (i in 1..indegree.lastIndex) {
//        if (indegree[i] == 0)
//            tempQ.add(i)
//    }
//    while (true) {
//        var cont = false
//        for(i in 1..indegree.lastIndex){
//            if (indegree[i] != 0)
//                cont = true
//        }
//        if (!cont) break
//
//        q.addAll(tempQ)
//        tempQ.clear()
//        while (q.isNotEmpty()) {
//            val cur = q.pollFirst()
//            for (node in graph[cur]) {
//                indegree[node] -= 1
//                if(indegree[node] == 0){
//                    indegree[node] = -1
//                    tempQ.add(node)
//                }
//
//            }
//            if (indegree.drop(1).count { it == 0 } == 1) {
//                return indegree.drop(1).count() - 1
//            }
//        }
//
//    }
//    return 0
//}