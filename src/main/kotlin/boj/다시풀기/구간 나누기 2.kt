package boj.boj_practice

//https://www.acmicpc.net/problem/13397
import kotlin.math.max
import kotlin.math.min
import kotlin.properties.Delegates


private var n by Delegates.notNull<Int>()
private var m by Delegates.notNull<Int>()
fun main() {

    var ans = 0

    val nm = readln().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    val data = readln().split(" ").map { it.toInt() }

    var left = 0
    var right = data.maxOf { it }
    while (left <= right) {
        val mid = (left + right).div(2)
        if (cntInterval(mid, data) <= m) {
            right = mid - 1
            ans = mid
        } else {
            left = mid + 1
        }

    }

    println(ans)

}

private fun cntInterval(score: Int, data: List<Int>): Int { // 해당 구간점수 값을 가지는 구간의 수
    var cnt = 1
    var (mini, maxi) = data[0] to data[0]


    for (i in 0 until n) {
        mini = min(mini, data[i])
        maxi = max(maxi, data[i])
        if (maxi - mini > score) {  //구간점수보다 크게 나눠버리는 경우
            cnt++
            mini = data[i]
            maxi = data[i]
        }
    }

    return cnt
}