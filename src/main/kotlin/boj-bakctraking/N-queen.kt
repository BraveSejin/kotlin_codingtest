private var N = 0
private var ans = 0
private lateinit var isUsed1: BooleanArray // 같은 열
private lateinit var isUsed2: BooleanArray // 왼쪽으로 내려가는 대각선
private lateinit var isUsed3: BooleanArray // 오른쪽으로 내려가는 대각선

fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()

    isUsed1 = BooleanArray(N) { false }
    isUsed2 = BooleanArray(2 * N - 1) { false }
    isUsed3 = BooleanArray(2 * N - 1) { false }

    func(0)
    println(ans)
}

private fun func(cur: Int) {
    if (cur == N) {
        ans += 1
        return
    }

    for (i in 0 until N) { // i is column
        if (isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + N - 1]) continue
        isUsed1[i] = true
        isUsed2[i + cur] = true
        isUsed3[cur - i + N - 1] = true
        func(cur + 1)
        isUsed1[i] = false
        isUsed2[i + cur] = false
        isUsed3[cur - i + N - 1] = false
    }


    // 각 행에 퀸을 놓을 수 있나? 같은 행, 열, 대각선에 다른 퀸이 없어야 한다.
    // 행마다 하나씩 놓을거니까 대각선과 열만 생각하면 된다.


}