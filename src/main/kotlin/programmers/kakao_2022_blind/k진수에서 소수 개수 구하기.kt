package programmers.kakao_2022_blind

import kotlin.math.sqrt


// 유저, 신고당한 횟수, 신고한 유저들
// 같은 유저가 한 유저한테 여러번 신고해도 1개취급 -> set으로 설정


private fun isPrime(n: Long?): Boolean {
    if (n == null) return false
    if (n < 2) return false
    for (i: Long in 2..sqrt(n.toDouble()).toLong()) {
        if (n % i == 0L) return false
    }
    return true
}

private fun solution(n: Int, k: Int): Int {
    return n.toString(radix = k)
        .split("0") // 이거말고 좀더 나은 방법 없나?
        .filter { !it.contains('0') }
        .count { isPrime(it.toLongOrNull()) }
}

fun main() {
    solution(437674, 3).also { println(it) }
    solution(110011, 10).also { println(it) }
    solution(2, 3).also { println(it) }
}