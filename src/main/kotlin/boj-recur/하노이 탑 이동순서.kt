package `boj-recur`

private var N = 0
private val builder = StringBuilder()
val reader = System.`in`.bufferedReader()
fun main() {


    N = reader.readLine().toInt()
    builder.append("${1.shl(N) - 1}\n")
    move(1, 3, N)
    println(builder)

}

// 원판 a개를 from에서 to로 옮기는 방법을 출력하는 함수.
private fun move(from: Int, to: Int, a: Int) {
    if (a == 1) {
        builder.append("$from $to\n")
        return
    }
    move(from, 6 - (from + to), a - 1)
    builder.append("$from $to\n")
    move(6 - (from + to), to, a - 1)
}