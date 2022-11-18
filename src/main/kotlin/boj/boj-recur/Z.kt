package boj.`boj-recur`

private var N = 0
private var r = 0
private var c = 0

fun main() {
    readln().split(" ").map { it.toInt() }
        .also {
            N = it[0]
            r = it[1]
            c = it[2]
        }
    println(func(N, r, c))

}

// 2^n x 2^n 배열에서 (r,c)를 방문하는 순서를 반환하는 함수

// 1 1 1  half :
private fun func(n: Int, r: Int, c: Int): Int {
    if (n == 0) return 0

    val half = (1).shl(n - 1) // 2^(n-1)
    if (r < half && c < half) return func(n - 1, r, c)
    if (r < half && c >= half) return half * half + func(n - 1, r, c - half)
    if (r >= half && c < half) return 2 * half * half + func(n - 1, r - half, c)
    return 3 * half * half + func(n - 1, r - half, c - half)

}