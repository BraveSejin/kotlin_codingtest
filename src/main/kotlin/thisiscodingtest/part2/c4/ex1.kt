
private class Pos(var row: Int, var col: Int)

private enum class Direction { L, R, U, D }

fun main() {
    val n = readLine()!!.toInt()
    val data = readLine()!!.split(" ")

//    val board = Array(n + 1) { row ->
//        IntArray(n + 1) { col ->
//            0
//        }
//    }
    // L R U D
    val dRow = arrayOf(0, 0, -1, 1)
    val dCol = arrayOf(-1, 1, 0, 0)
    val pos = Pos(1, 1)

    data.forEach { dir ->
        var nRow = pos.row + dRow[Direction.valueOf(dir).ordinal]
        var nCol = pos.col + dCol[Direction.valueOf(dir).ordinal]
        if (nRow in 1..n && nCol in 1..n) {
            pos.row = nRow
            pos.col = nCol
        }
    }
    println("${pos.row} ${pos.col}")

}
