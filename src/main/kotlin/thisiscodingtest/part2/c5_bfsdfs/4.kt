package thisiscodingtest.part2.c5_bfsdfs

import java.util.LinkedList
import java.util.Queue

fun main() {
    val dRow = arrayOf(0, 1, 0, -1)
    val dCol = arrayOf(1, 0, -1, 0)

    val readLine = System.`in`.bufferedReader()::readLine
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = mutableListOf<MutableList<Int>>().apply {
        add(mutableListOf())
        repeat(n) {
            val toAdd = mutableListOf<Int>().apply { add(0) }
            toAdd.addAll(readLine().map { it.digitToInt() })
            add(toAdd)
        }

    }


    var result = 0
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>()
    queue.add(Triple(1, 1, 1))


    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        if (cur.first == n && cur.second == m) {
            result = cur.third
            break
        }

        for (i in 0..3) {
            val nRow = cur.first + dRow[i]
            val nCol = cur.second + dCol[i]
            val nDist = cur.third + 1
            if (nRow !in 1..n || nCol !in 1..m || board[nRow][nCol] == 0) continue

            queue.add(Triple(nRow, nCol, nDist))
        }
    }
    println(result)

}