fun main() {
    val dRow = arrayOf(1, 1, -1, -1, 2, 2, -2, -2)
    val dCol = arrayOf(2, -2, 2, -2, 1, -1, -1, 1)

    val dest = readLine()!!
    val cRow = dest[1].digitToInt()
    val cCol = dest[0].code - 96

    var res = 0

    for (i in 0..7) {
        val nRow = cRow + dRow[i]
        val nCol = cCol + dCol[i]
        if ( nRow in 1..8 && nCol in 1..8)
            res += 1
    }
    println(res)

}