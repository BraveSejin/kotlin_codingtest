package thisiscodingtest.part2.c5

import java.util.LinkedList

private var n: Int = 0
private var m: Int = 0
private val dRow = arrayOf(0, 1, 0, -1)
private val dCol = arrayOf(1, 0, -1, 0)

fun main() {

//    sol1()
    sol2()

}

private fun sol2() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = mutableListOf<MutableList<Int>>()  // n+1개로 만들어보
    board.apply {
        add(mutableListOf<Int>())
        repeat(n) {
            val toAdd = mutableListOf(1)
            toAdd.addAll(readLine()!!.map { it.digitToInt() }.toMutableList())
            add(toAdd)
        }
    }

    var result = 0
    for (i in 1..n) {
        for (j in 1..m) {

            if (dfs(board, i, j, n, m)) result += 1

        }
    }

    println(result)
}

private fun dfs(board: List<MutableList<Int>>, row: Int, col: Int, n: Int, m: Int): Boolean {
    if (board[row][col] == 1) return false
    board[row][col] = 1

    for (i in 0..3) {
        val nRow = row + dRow[i]
        val nCol = col + dCol[i]
        if (nRow in 1..n && nCol in 1..m && board[nRow][nCol] == 0)
            dfs(board, nRow, nCol, n, m)
    }
    return true
}


private fun sol1() {


    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val board = mutableListOf<MutableList<Int>>()  // n+1개로 만들어보

    val dRow = arrayOf(0, 1, 0, -1)
    val dCol = arrayOf(1, 0, -1, 0)

    board.apply {
        add(mutableListOf<Int>())
        repeat(n) {
            val toAdd = mutableListOf(1)
            toAdd.addAll(readLine()!!.map { it.digitToInt() }.toMutableList())
            add(toAdd)
        }
    }
    var result = 0

    for (i in 1..n) {
        for (j in 1..m) {
            if (board[i][j] == 1) continue

            result += 1
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(Pair(i, j))

            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                val cRow = cur.first
                val cCol = cur.second
                board[cRow][cCol] = 1
                for (k in 0..3) {
                    val nRow = cRow + dRow[k]
                    val nCol = cCol + dCol[k]
                    if (nRow !in 1..n || nCol !in 1..m || board[nRow][nCol] == 1) continue
                    queue.offer(Pair(nRow, nCol))
                }

            }

        }
    }
    println(result)
}