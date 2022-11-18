package cheetsheet

import java.io.BufferedReader
import java.util.LinkedList
import java.util.Queue

/***
5 6
101010
111111
000001
111111
111111
 */
private val dx = arrayOf(0, 1, 0, -1)
private val dy = arrayOf(1, 0, -1, 0)
private lateinit var data: Array<Int>
private var n: Int = 0
private var m: Int = 0

fun bfs(array: Array<IntArray>) {

    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(Pair(0, 0))
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val (nx, ny) = Pair(x + dx[i], y + dy[i])
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if (array[nx][ny] == 0) continue
            if (array[nx][ny] == 1) {
                queue.offer(Pair(nx,ny))
                array[nx][ny] = array[x][y] + 1
            }
        }
    }
    println(array[n-1][m-1])
}

fun main() {
    val reader = System.`in`.bufferedReader()
    val data = reader.readLine().split(" ").map { it.toInt() }
    n = data[0]
    m = data[1]

    val array = Array(n) { IntArray(m) { 0 } }
    for (i in 0 until n) {
        array[i] = reader.readLine().map { it.digitToInt() }.toIntArray()
    }
    bfs(array)

}