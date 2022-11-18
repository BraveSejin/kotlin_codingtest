package boj.`boj-recur`

private var N = 0
private lateinit var board: Array<CharArray>
fun main() {
    N = readln().toInt()
    board = Array(N) { CharArray(N) { ' ' } }

    func(length = N, 0, 0)

    board.forEach {
        println(it.joinToString(""))
    }

}

/*
* 공백인 조건: 3의 거듭제곱인 곳의 가운데
* 가운데 빼고 별로 채워주자. step 이런거 쓴다고 까불지 말고 직관적인 풀이로 하자.
* r
* */
private fun func(length: Int, row: Int, col: Int) {
    if (length == 1) {
        board[row][col] = '*'
        return
    }

    val leng = length / 3

    for (i in 0..2) {
        for (j in 0..2) {
            if (i == 1 && j == 1) continue
            else func(leng, row + i * leng, col + j * leng)
        }
    }
}