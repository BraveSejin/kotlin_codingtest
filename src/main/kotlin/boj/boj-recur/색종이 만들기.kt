package boj.`boj-recur`


private var N = 0
private lateinit var board: Array<IntArray>
private val h = HashMap<Int, Int>()
    .also {
        it[0] = 0
        it[1] = 0
    }

fun main() {
    N = readln().toInt()
    board = Array(N) {
        readln().split(' ').map { it.toInt() }.toIntArray()
    }
    function(N,0,0)

    println(h[0])
    println(h[1])

}

private fun function(length: Int, row: Int, col: Int) {
//    if (length == 1) {
//        h.merge(board[row][col], 1, Integer::sum)
//        return
//    }
    val v = board[row][col]

    var divide = false
    label@
    for (i in row until row + length) {
        for (j in col until col + length) {
            if (v != board[i][j]) {
                divide = true
                break@label
            }
        }
    }
    if (!divide) {
        h.merge(board[row][col], 1, Integer::sum)
    } else {
        for (i in 0..1) {
            for (j in 0..1) {
                function(length / 2, row + i * length / 2, col + j * length / 2)
            }
        }
    }
}