package boj.boj_practice

fun main() {

    val n = readln().toInt()
    val memo = LongArray(n + 1)
    memo[0] = 1
    for (i in 1..n) {
        memo[i] = getMemoValue(memo, i)
    }
    println(memo[n])


}

private fun getMemoValue(memo: LongArray, idx: Int) : Long{
    var ans = 0L
    for (i in 0 until idx) {
        ans += memo[i] * memo[idx - i - 1]
    }
    return ans
}

private fun func(memo: LongArray, target: Int) {}