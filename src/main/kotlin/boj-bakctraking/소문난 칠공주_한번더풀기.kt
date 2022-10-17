package `boj-bakctraking`

import java.util.LinkedList
//https://www.acmicpc.net/problem/1941
private val board = Array(5) { CharArray(5) }
private val visited = BooleanArray(25)
private var ans = 0
private val arr = IntArray(7)
val dRow = intArrayOf(0, 0, 1, -1)
val dCol = intArrayOf(1, -1, 0, 0)


fun main() {
    repeat(5) { it ->
        board[it] = readln().toCharArray()
    }
    // 가로세로에 있는 여학생 7명을 아무렇게나 선택한다.
    // 임도연파가 4명이상되면 잘못된거임. 임다솜파는 4명 이상 포함되어야 한다. )
    comb(0, 0, 0)
    println(ans)
}

// 일단 7명을 조합으로 뽑고 인접한지 알아본다.
private fun comb(start: Int, depth: Int, numDasom: Int) {
    if (depth == 7) {
        if (numDasom < 4)
            return
        if (valid())
            ans += 1
        return
    }
    for (i in start until 25) {
        arr[depth] = i
        visited[i] = true

        val row = i / 5
        val col = i % 5
        if (board[row][col] == 'S') {
            comb(i + 1, depth + 1, numDasom + 1)
        } else {
            comb(i + 1, depth + 1, numDasom)
        }

        visited[i] = false
    }
}

private fun valid(): Boolean {
    // 7명이 서로 가로나 세로로 인접한지 여부만 알면 된다.
    var cnt = 1
    val q = LinkedList<Int>()
    val adjVisited = BooleanArray(25)
    q.add(arr[0])

    while (q.isNotEmpty()) {
        val now = q.poll()
        adjVisited[now] = true
        for (i in 0..3) {
            val nRow = now / 5 + dRow[i]
            val nCol = now % 5 + dCol[i]

            if (nRow !in 0..4) continue
            if (nCol !in 0..4) continue

            if (adjVisited[nRow * 5 + nCol]) continue // 이미 확인
            if (!visited[nRow * 5 + nCol]) continue

            cnt += 1
            adjVisited[nRow * 5 + nCol] = true
            q.add(nRow * 5 + nCol)
        }
    }
    return cnt == 7
}