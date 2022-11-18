package boj.`boj-recur`


private var N = 0
// N = 24라면
// 한 변의 길이가 24인 이등변삼감형
// 밑변 길이는 23임.
// B = 3 * 2^k 일때
// 밑변은 2* 3 * 2^k -1

// 밑변 1일떄 그냥 그리고 센터는 무시하는 방식으로 그리면 도리듯.
// 근데 이걸 배열로 표현하나??


//https://transferhwang.tistory.com/316 참고
private lateinit var board: Array<CharArray>
fun main() {
    N = readln().toInt()
    val bottom = 2 * N
    board = Array(N) {
        CharArray(bottom) { ' ' }
    }

    func(N, 0, N - 1)
    board.forEach {
        println(it.joinToString(""))
    }

}

private fun func(length: Int, row: Int, col: Int) {

    if (length == 3) { // 더이상 쪼갤 수 없음. 별을 그린다.
        board[row][col] = '*'
        board[row + 1][col - 1] = '*'
        board[row + 1][col + 1] = '*'
        for (i in col - 2..col + 2)
            board[row + 2][i] = '*'
        return
    }

    func(length / 2, row, col)
    func(length / 2, row + length / 2, col - length / 2)
    func(length / 2, row + length / 2, col + length / 2)

}