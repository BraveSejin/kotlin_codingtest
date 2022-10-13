package `boj-bakctraking`

private val board = Array(5) { CharArray(5) }

private var numDoyeon = 0
private var numDasom = 0
private var ans = 0

private val checked = BooleanArray(25) // 칠공주로 찍힘
private val arr = IntArray(7)


fun main() {

    repeat(5) { it ->
        board[it] = readln().toCharArray()
    }
    // 가로세로에 있는 여학생 7명을 아무렇게나 선택한다.
    // 임도연파가 4명이상되면 잘못된거임. 임다솜파는 4명 이상 포함되어야 한다. )
    comb(0,0)
}

// 일단 7명을 조합으로 뽑고 인접한지 알아본다.
private fun comb(start: Int, depth: Int) {
    if (numDoyeon >= 4) {
        return
    }
    if (depth == 7) {

    }
    for (i in start until 25){
        checked[i] = true
        arr[depth] = i
        val row =  i / 5
        val col = i % 5
        if (board[row][col] == 'S'){
            comb(i+1, depth + 1 )
        }


    }
}