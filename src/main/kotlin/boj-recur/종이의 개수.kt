package `boj-recur`


private val h = HashMap<Int, Int>()
private var N = 0
private lateinit var board: MutableList<MutableList<Int>>

fun main() {
    N = readln().toInt()

    board = MutableList(N) {
        val line = readln().split(' ').map { it.toInt() }
        line.toMutableList()
    }



    h[-1] = 0 // merge를 쓰더라도 null 인 경우 있을까바
    h[0] = 0
    h[1] = 0
    function(N, 0, 0)

    println(h[-1])
    println(h[0])
    println(h[1])
}

private fun function(length: Int, row: Int, col: Int) {
    if (length == 1) {
        h.merge(board[row][col], 1, Integer::sum)
        return
    }

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
        val leng = length / 3
        for (i in 0..2) {
            for (j in 0..2) {
                function(leng, row + i * leng, col + j * leng)
            }
        }
    }
}