package boj.boj_practice


fun main() {
    val (n,m) = readln().split(" ").map { it.toInt() }
    val data = readln().split(" ").map { it.toInt() }
    val prefixSum = LongArray(n)
    val cnt = LongArray(m)
    prefixSum[0] = data[0].toLong()
    for (i in 1 until n){
        prefixSum[i] = (prefixSum[i-1] + data[i]) % m
    }
    for (i in 0 until n){
        cnt[(prefixSum[i] % m).toInt()] ++
    }

    var ans = 0L
    for (i in 0 until  m){
        ans += cnt[i] * (cnt[i] -1) / 2
    }
    ans += cnt[0]
    println(ans)
}