package `boj-recur`

private var N = 0
private lateinit var board: Array<IntArray>
private val h = HashMap<Int, Int>()
fun main() {
    N = readln().toInt()
    board = Array(N) {
        readln().map { it.digitToInt() }.toIntArray()
    }
    func(N, 0, 0).also { println(it) }


}

private fun func(length: Int, row: Int, col: Int): String {
    if (chk(length, row, col)) {
        return "${board[row][col]}"
    } else {
        val len = length / 2
        return "(${func(len, row, col)}" +
                "${func(len, row, col + len)}" +
                "${func(len, row + len, col)}" +
                "${func(len, row + len, col + len)})"
    }

}

private fun chk(length: Int, row: Int, col: Int): Boolean {
    val v = board[row][col]
    for (i in row until row + length) {
        for (j in col until col + length) {
            if (v != board[i][j])
                return false
        }
    }
    return true
}