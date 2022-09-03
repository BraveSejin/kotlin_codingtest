package thisiscodingtest.part2.c4

private fun rotate(dir: Int): Int {
    if (dir == 0) return 3
    return dir - 1
}

private val dRow = arrayOf(-1, 0, 1, 0)
private val dCol = arrayOf(0, 1, 0, -1)

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    var (cRow, cCol, cDir) = readLine()!!.split(" ").map { it.toInt() }
    val data = Array(n) {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    val board = Array(n + 1) {
        if (it == 0) intArrayOf()
        else data[it - 1]
    }
    val visited = Array(n + 1) {
        if (it == 0) booleanArrayOf()
        else BooleanArray(m + 1) { false }
    }
    var stuck = false
    var res = 0
    while (true) {
        stuck = true
        for (i in 1..4) {

            cDir = rotate(cDir)
            val nRow = cRow + dRow[cDir]
            val nCol = cCol + dCol[cDir]
            if (nRow !in 1..n || nCol !in 1..m || visited[nRow][nCol] || board[nRow][nCol] == 1) continue

            visited[nRow][nCol] = true
            cRow = nRow
            cCol = nCol
            res += 1
            stuck = false
            break
        }
        // 이동 못한경우
        if(stuck) { //뒤로가기
            val nRow = cRow + dRow[cDir]
            val nCol = cCol + dCol[cDir]
            if (board[nRow][nCol] == 1 || nRow !in 1..n || nCol !in 1..m)
                break
            cRow = nRow
            cCol = nCol
            cDir = rotate(cDir)
            cDir = rotate(cDir)
        }
    }

    println(res)
}