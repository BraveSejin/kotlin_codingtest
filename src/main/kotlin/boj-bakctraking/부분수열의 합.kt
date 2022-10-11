package `boj-bakctraking`

var N = 0
var S = 0
var ans = 0
val sequence: IntArray by lazy { IntArray(N) }

private fun main() = with(System.`in`.bufferedReader()) {
    readln().split(" ").map { it.toInt() }
        .also {
            N = it[0]
            S = it[1]
        }
    readLine().split(" ").map { it.toInt() }
        .forEachIndexed { index, i ->
            sequence[index] = i
        }
    func(0, 0)

    if (S == 0) ans -= 1
    println(ans)

}

private fun func(depth: Int, sum: Int) {
    if (depth == N) {
        if (sum == S) ans += 1
        return
    }
    func(depth + 1, sum)
    func(depth + 1, sum + sequence[depth])

}