package boj.boj_practice

fun main() {
    val n = readln().toInt()
    val cnt = hashMapOf<Int, Int>()

    repeat(n - 1) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        cnt.merge(a, 1, Integer::sum)
        cnt.merge(b, 1, Integer::sum)
    }

    val numQuery = readln().toInt()
    repeat(numQuery) {
        val (q, k) = readln().split(" ").map { it.toInt() }
        if (q == 2) {
            println("yes")
            return@repeat
        }
        if (n == 2) {
            println("no")
            return@repeat
        }
        // 내 생각 : 리프면 단절점이 아님.
        if (cnt[k]!! >= 2) {
            println("yes")
        } else {
            println("no")
        }
    }

}